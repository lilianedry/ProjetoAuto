package controller;

import controller.alerts.Alertas;
import controller.verificadores.verCPF;
import database.DAOs.ClienteDAO;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Caminho;
import model.ChangeScreen;
import model.Especificacoes;
import model.entities.Cliente;

public class TelaGerenciaCliController implements Initializable {
    
    private static boolean janela;

    public static boolean getJanela() {
        return janela;
    }

    public static void setJanela(boolean janela) {
        TelaGerenciaCliController.janela = janela;
    }

    @FXML
    private TextField campoPesquisa;
    @FXML
    private TableColumn<Cliente, String> colunaNome;
    @FXML
    private TableColumn<Cliente, String> colunaCPF;
    @FXML
    private Button voltar;
    @FXML
    private Button editaCli;
    @FXML
    private Button removeCli;
    @FXML
    private Button insereCli;
    @FXML
    private TableView<Cliente> listaClientes;
    @FXML
    private RadioButton campoMasc;
    @FXML
    private RadioButton campoFem;
    @FXML
    private TextField campoNome;
    @FXML
    private TextField campoRG;
    @FXML
    private TextField campoCPF;
    @FXML
    private TextField campoTel;
    @FXML
    private TextField campoBairro;
    @FXML
    private TextField campoNum;
    @FXML
    private TextField campoCnh;
    @FXML
    private TextField campoRua;
    @FXML
    private DatePicker campoDataNasc;
    @FXML
    private TextField campoCidade;
    @FXML
    private TextField campoEstado;
    @FXML
    private TextField campoEmail;
    
    private Cliente selecionado;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initTable();
        
        listaClientes.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
               selecionado = (Cliente) newValue;
               
            }
        });
        
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
    private void editaCli(ActionEvent event) {
    }

    @FXML
    private void removeCli(ActionEvent event) {
        deleta();
    }

    @FXML
    private void insereCli(ActionEvent event) {
        Cliente cli = new Cliente();
        
        cli.setNome(campoNome.getText()); 
        try {
            if (!(verCPF.isValidCPF(campoCPF.getText().trim())))
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
                Alertas.mostraAlertaInfo("No campo CPF", "Digite um CPF válido.");
                return;
        }
        cli.setCpf(campoCPF.getText()); 
       
        if(campoMasc.isSelected()){
            cli.setSexo("M");
        }
        if(campoFem.isSelected()){
            cli.setSexo("F");
        }
        cli.setRua(campoRua.getText());
        cli.setNumCasa(campoNum.getText());
        cli.setRg(campoRG.getText());        
        cli.setBairro(campoBairro.getText());
        cli.setCidade(campoCidade.getText());
        cli.setEstado(campoEstado.getText());
        cli.setEmail(campoEmail.getText());
        cli.setTelefone(campoTel.getText());
        cli.setCnh(campoCnh.getText());
        cli.setAtivo(true);
                
        LocalDate data = campoDataNasc.getValue();
        Date nasc = Date.from(data.atStartOfDay(ZoneId.systemDefault()).toInstant());
        cli.setDataNascimento(nasc);
        
        Alertas.mostraAlertaInfo("Cadastro de Clientes", "Cadastro realizado com sucesso!");
	
        ClienteDAO cliDAO = new ClienteDAO();
        cliDAO.add(cli);
    }
    
    
    public void initTable(){
        colunaNome.setCellValueFactory(new PropertyValueFactory("nome"));
        colunaCPF.setCellValueFactory(new PropertyValueFactory("cpf"));
        listaClientes.setItems(atualizaTabela());
    }
    
    public ObservableList<Cliente> atualizaTabela(){
        ClienteDAO dao = new ClienteDAO();
        return FXCollections.observableArrayList(dao.all());
    }
    
    public void deleta(){
        ClienteDAO cli = new ClienteDAO();
        cli.delete(selecionado);
    }
}
