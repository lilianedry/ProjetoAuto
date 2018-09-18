package controller;

import controller.alerts.Alertas;
import database.DAOs.CarroDAO;
import database.DAOs.ClienteDAO;
import database.DAOs.SolicitaCarroDAO;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Caminho;
import model.ChangeScreen;
import model.Especificacoes;
import model.entities.Carro;
import model.entities.Cliente;
import model.entities.relationships.SolicitaCarro;

public class TelaLocarVeiculosController implements Initializable {
    private static boolean janela;

    public static boolean getJanela() {
        return janela;
    }

    public static void setJanela(boolean janela) {
        TelaLocarVeiculosController.janela = janela;
    }
    
    @FXML
    private TextField campoPesquisa;
    @FXML
    private TextField campoCPFCli;
    @FXML
    private TextField campoPlaca;
    @FXML
    private DatePicker campoDataRetira;
    @FXML
    private DatePicker campoDataEntrega;
    @FXML
    private DatePicker campoPrazoFinal;
    @FXML
    private Button locarVeiculo;
    @FXML
    private Button devolveVeiculo;
    @FXML
    private Button voltar;
    @FXML
    private TextField campoValor;
    
    @FXML
    private TableView<Cliente> listaClientes;

    @FXML
    private TableColumn<Cliente, String> colunaNome;

    @FXML
    private TableColumn<Cliente, String> colunaCPF;
    
    private SolicitaCarro sele;
    
    private ObservableList<Cliente> cliente = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       initTable();
       
       listaClientes.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
               Cliente selecionado = (Cliente) newValue;  
               SolicitaCarro soli = new SolicitaCarro();
               soli.setCliente(selecionado);
               SolicitaCarroDAO car= new SolicitaCarroDAO();
               sele = car.selectParam(soli).get(0);
               System.out.println(selecionado.toString());
            }
        });
    }    

    @FXML
    private void locarVeiculo(ActionEvent event) {
        Cliente aux = new Cliente();
        ClienteDAO dao = new ClienteDAO();
        List<Cliente> fun = dao.all();
        aux.setCpf(campoCPFCli.getText());
        for(int x =0; x<fun.size() ; x++){
            if (campoCPFCli.getText().equals(fun.get(x).getCpf())){
                x = fun.size();
                ClienteDAO cliDAO2 = new ClienteDAO();
                System.out.println(aux);
                Cliente cli = cliDAO2.selectParam(aux).get(0);
                
                Carro auxCar = new Carro();
                auxCar.setPlaca(campoPlaca.getText());
                CarroDAO carDAO = new CarroDAO();
                Carro car = carDAO.selectParam(auxCar).get(0);

                SolicitaCarro sC = new SolicitaCarro();
                sC.setCliente(cli);
                sC.setCarro(car);

                LocalDate data = campoDataRetira.getValue();        
                Date nasc = Date.from(data.atStartOfDay(ZoneId.systemDefault()).toInstant());
                sC.setDataRetirada(nasc);
                
                LocalDate data2 = campoPrazoFinal.getValue();
                Date nasc2 = Date.from(data2.atStartOfDay(ZoneId.systemDefault()).toInstant());
                sC.setPrazoFinal(nasc2);

                cli.getSolicitaCarro().add(sC);

                ClienteDAO cliDAO3 = new ClienteDAO();
                cliDAO3.update(cli);         

                listaClientes.setItems(atualizaTabela());

                Alertas.mostraAlertaInfo("Locação de Veículo", "Locação realizada com sucesso!");
            }
            else {                    
                Alertas.mostraAlertaInfo("CPF não encontrado!", "Verifique se o cliente está cadastrado");
            }
        }
    }

    @FXML
    private void devolveVeiculo(ActionEvent event) {
        sele.setAtivo(false);
        LocalDate data1 = campoDataEntrega.getValue();
        Date nasc1 = Date.from(data1.atStartOfDay(ZoneId.systemDefault()).toInstant());
        sele.setDataEntrega(nasc1);
        SolicitaCarroDAO dao= new SolicitaCarroDAO();
        dao.update(sele);
        sele.setValor(campoValor.getText());

        
        listaClientes.setItems(atualizaTabela());
        Alertas.mostraAlertaInfo("Devolução", "Devolução realizada com sucesso!");		
    }

    @FXML
    private void voltar(ActionEvent event) {
       if(janela == true){
            ChangeScreen change = new ChangeScreen();

            Stage mainStage;
            try {
                mainStage = change.change(event, Caminho.telaGerente, Especificacoes.getSoftwareNome(), true);
                mainStage.show();
            } catch (Exception ex) {
                Logger.getLogger(TelaGerenciaCarroController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
             ChangeScreen change = new ChangeScreen();

            Stage mainStage;
            try {
                mainStage = change.change(event, Caminho.telaFunc, Especificacoes.getSoftwareNome(), true);
                mainStage.show();
            } catch (Exception ex) {
                Logger.getLogger(TelaGerenciaCarroController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void btPesquisa(ActionEvent event) {
       listaClientes.setItems(busca());
    }
    
    private ObservableList<Cliente> busca(){
        ObservableList<Cliente> cliPesquisa = FXCollections.observableArrayList();
        for(int x = 0; x<cliente.size(); x++){
            if(cliente.get(x).getNome().contains(campoPesquisa.getText())){
                cliPesquisa.add(cliente.get(x));
            }
        }
        return cliPesquisa;
    }

    public void initTable(){
        colunaNome.setCellValueFactory(new PropertyValueFactory("nome"));
        colunaCPF.setCellValueFactory(new PropertyValueFactory("cpf"));
        listaClientes.setItems(atualizaTabela());
    }
    
    public ObservableList<Cliente> atualizaTabela(){
        SolicitaCarroDAO dao = new SolicitaCarroDAO();
        List<SolicitaCarro> soli = dao.all();
        for(int x=0; x<soli.size();x++){
            cliente.add(soli.get(x).getCliente());
        }
        return FXCollections.observableArrayList(cliente);
    }    
}