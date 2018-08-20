package controller;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Caminho;
import model.ChangeScreen;
import model.Especificacoes;

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
    }
    
}
