package controller;

import controller.alerts.Alertas;
import controller.verificadores.verCPF;
import database.DAOs.CarroDAO;
import database.DAOs.ClienteDAO;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Caminho;
import model.ChangeScreen;
import model.Especificacoes;
import model.entities.Carro;
import model.entities.Cliente;

public class TelaGerenciaCarroController implements Initializable{
    private static boolean janela;

    public static boolean getJanela() {
        return janela;
    }
    public static void setJanela(boolean janela) {
        TelaGerenciaCarroController.janela = janela;
    }

    @FXML
    private Button insereCarro;
    @FXML
    private Button voltar;
    @FXML
    private Button editaCarro;
    @FXML
    private Button removeCarro;
    @FXML
    private TextField campoPesquisa;
    @FXML
    private TableColumn<Carro, String> colunaPlaca;
    @FXML
    private TableColumn<Carro, String> colunaModelo;
    @FXML
    private TableView<Carro> listaVeiculos;
    @FXML
    private TextField campoPlaca;
    @FXML
    private TextField campoModelo;
    @FXML
    private TextField campoAno;
    @FXML
    private TextField campoCor;
    @FXML
    private TextField campoCambio;
    @FXML
    private TextField campoCombustivel;
    @FXML
    private TextField campoKm;
    @FXML
    private TextField campoChassi;
    @FXML
    private TextArea campoOpcional;
    @FXML
    private TextField campoCPF;
    @FXML
    private DatePicker campoData;    

    private Carro selecionado;
    
    private ObservableList<Carro> carr = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initTable();
        
        listaVeiculos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
               selecionado = (Carro) newValue;               
            }
        });        
    } 
    
    @FXML
    void btPesquisa(ActionEvent event) {
        listaVeiculos.setItems(busca());
    }
    
    @FXML
    private void insereCarro(ActionEvent event) {
        if(selecionado != null){
            Carro car = new Carro();
        
            car.setPlaca(campoPlaca.getText());        
            car.setModelo(campoModelo.getText());
            car.setCor(campoCor.getText());        
            car.setChassi(campoChassi.getText());  
            car.setTipoCambio(campoCambio.getText());
            car.setCombustivel(campoCombustivel.getText());          
            car.setOpcionais(campoOpcional.getText());                
            car.setAnoModelo(campoAno.getText());        
            car.setQuilometragem(campoKm.getText()); 
            car.setIdCarro(selecionado.getIdCarro());
            car.setAtivo(true);

            CarroDAO carDAO = new CarroDAO();
            carDAO.update(car);
            listaVeiculos.setItems(atualizaTabela());

            Alertas.mostraAlertaInfo("Edita Veículo", "Edição realizado com sucesso!");
       }
       else{            
            Carro car = new Carro();
            CarroDAO dao = new CarroDAO();
            List<Carro> fun = dao.all();
            
            car.setPlaca(campoPlaca.getText()); 
            
            for(int x=0; x<fun.size() ; x++){
                if (!campoPlaca.getText().equals(fun.get(x).getPlaca())){  
                    if(x == fun.size()-1){
                        car.setCor(campoCor.getText());      
                        car.setChassi(campoChassi.getText());           
                        car.setTipoCambio(campoCambio.getText());
                        car.setAnoModelo(campoAno.getText()); 
                        car.setCombustivel(campoCombustivel.getText());  
                        car.setModelo(campoModelo.getText());  
                        car.setQuilometragem(campoKm.getText());            
                        car.setOpcionais(campoOpcional.getText());  
                        car.setAtivo(true);

                        Cliente aux = new Cliente(); 
                        try {
                            if (!(verCPF.isValidCPF(campoCPF.getText().trim())))
                            throw new IllegalArgumentException();
                        } catch (IllegalArgumentException e) {
                            Alertas.mostraAlertaInfo("No campo CPF", "Digite um CPF válido.");
                            return;
                        }
                        aux.setCpf(campoCPF.getText());
                        ClienteDAO cliDAO2 = new ClienteDAO();                       
                        Cliente cliSel = cliDAO2.selectParam(aux).get(0);
                        if(cliSel != null){
                            car.setCliente(cliSel);
                            System.out.println(cliSel);
                        }else{
                            System.out.println("CPF NAO ENCONTRADO!");
                        }
                        LocalDate data = campoData.getValue();
                        Date nasc = Date.from(data.atStartOfDay(ZoneId.systemDefault()).toInstant());
                        car.setDataCede(nasc);

                        CarroDAO carDAO = new CarroDAO();
                        carDAO.add(car);
                        listaVeiculos.setItems(atualizaTabela());
                        Alertas.mostraAlertaInfo("Cadastro de Veículo", "Cadastro realizado com sucesso!");
                    }                    
                }
                else{
                    Alertas.mostraAlertaInfo("Cadastro de Veículo", "Veículo já cadastrado!!");  
                    break;                    
                }
            }
        }
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
        }
        else{
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
    private void removeCarro(ActionEvent event) throws Exception {
        if(selecionado!=null){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmação");
            alert.setHeaderText("Tem certeza que deseja excluir o veículo?");
            alert.setContentText("Todos os dados serão deletados do banco de dados");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                    remove(event);
            } else { }        
        }
        else{
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setHeaderText("Selecione um veículo");
            a.setContentText("Veículo não selecionado!");
            a.show();
        }
    }
    private void remove(ActionEvent event) throws Exception {   
        deleta();
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setHeaderText("Veículo excluído com Sucesso");
        a.show();
        listaVeiculos.setItems(atualizaTabela());           
    }
    public void deleta(){
        CarroDAO dao = new CarroDAO();        
        selecionado.setAtivo(false);
        dao.update(selecionado);
    }
    
    @FXML
    private void editaCarro(ActionEvent event) {    
        if(selecionado==null){
            try {
                if (selecionado==null)
                        throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                Alertas.mostraAlertaInfo("Edição de veículo", "Clique em um veículo para editar!");	
                    return;
            }
        }
        else{
            campoPlaca.setText(selecionado.getPlaca());
            campoModelo.setText(selecionado.getModelo());
            campoCor.setText(selecionado.getCor());
            campoChassi.setText(selecionado.getChassi());
            campoCambio.setText(selecionado.getTipoCambio());
            campoCombustivel.setText(selecionado.getCombustivel());
            campoOpcional.setText(selecionado.getOpcionais());
            campoAno.setText(selecionado.getAnoModelo());
            campoKm.setText(selecionado.getQuilometragem());
        }
    }
    
    public void initTable(){
        colunaPlaca.setCellValueFactory(new PropertyValueFactory("placa"));
        colunaModelo.setCellValueFactory(new PropertyValueFactory("modelo"));
        listaVeiculos.setItems(atualizaTabela());
    }  
    
    public ObservableList<Carro> atualizaTabela(){
        CarroDAO dao = new CarroDAO();
        carr = FXCollections.observableArrayList(dao.all());
        return carr;
    }
    
    private ObservableList<Carro> busca(){
        ObservableList<Carro> funPesquisa = FXCollections.observableArrayList();
        for(int x = 0; x<carr.size(); x++){
            if(carr.get(x).getPlaca().toLowerCase().contains(campoPesquisa.getText().toLowerCase())){
                funPesquisa.add(carr.get(x));
            }
        }
        return funPesquisa;
    }
    
}
