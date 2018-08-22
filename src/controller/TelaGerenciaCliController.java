package controller;

import controller.alerts.Alertas;
import database.DAOs.ClienteDAO;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    private TableColumn<?, ?> colunaNome;
    @FXML
    private TableColumn<?, ?> colunaCPF;
    @FXML
    private Button voltar;
    @FXML
    private Button editaCli;
    @FXML
    private Button removeCli;
    @FXML
    private Button insereCli;
    @FXML
    private TableView<?> listaClientes;
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    }

    @FXML
    private void insereCli(ActionEvent event) {
        Cliente cli = new Cliente();
        
        cli.setNome(campoNome.getText()); 
        cli.setCpf(campoCPF.getText());
        //cli.setSexo(campo.getText());
        cli.setRua(campoRua.getText());
        cli.setNumCasa(campoNum.getText());
        cli.setBairro(campoBairro.getText());
        cli.setCidade(campoCidade.getText());
        cli.setEstado(campoEstado.getText());
        cli.setTelefone(campoTel.getText());
        cli.setCnh(campoCnh.getText());
                
        LocalDate data = campoDataNasc.getValue();
        Date nasc = Date.from(data.atStartOfDay(ZoneId.systemDefault()).toInstant());
        cli.setDataNascimento(nasc);
        
        Alertas.mostraAlertaInfo("Cadastro de Clientes", "Cadastro realizado com sucesso!");
	
        ClienteDAO cliDAO = new ClienteDAO();
        cliDAO.add(cli);
    }
    
}
