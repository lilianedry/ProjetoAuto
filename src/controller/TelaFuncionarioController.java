package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Caminho;
import model.ChangeScreen;
import model.Especificacoes;

public class TelaFuncionarioController implements Initializable {

    @FXML
    private Button insereCli;
    @FXML
    private Button editaCli;
    @FXML
    private Button removeCli;
    @FXML
    private Button insereCarro;
    @FXML
    private Button removeCarro;
    @FXML
    private Button editaCarro;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void insereCli(ActionEvent event) throws Exception {
        ChangeScreen change = new ChangeScreen();

        Stage mainStage = change.change(event, Caminho.telaCadCli, Especificacoes.getSoftwareNome(), true);
        mainStage.show();
    }

    @FXML
    private void editaCli(ActionEvent event) throws Exception {
        ChangeScreen change = new ChangeScreen();

            Stage mainStage = change.change(event, Caminho.telaEditaCli, Especificacoes.getSoftwareNome(), true);
            mainStage.show();
    }

    @FXML
    private void removeCli(ActionEvent event) throws Exception {
        ChangeScreen change = new ChangeScreen();

            Stage mainStage = change.change(event, Caminho.telaRemoveCli, Especificacoes.getSoftwareNome(), true);
            mainStage.show();
    }

    @FXML
    private void insereCarro(ActionEvent event) throws Exception {
        ChangeScreen change = new ChangeScreen();

            Stage mainStage = change.change(event, Caminho.telaCadCarro, Especificacoes.getSoftwareNome(), true);
            mainStage.show();
    }

    @FXML
    private void removeCarro(ActionEvent event) throws Exception {
        ChangeScreen change = new ChangeScreen();

            Stage mainStage = change.change(event, Caminho.telaRemoveCarro, Especificacoes.getSoftwareNome(), true);
            mainStage.show();
    }

    @FXML
    private void editaCarro(ActionEvent event) throws Exception {
        ChangeScreen change = new ChangeScreen();

            Stage mainStage = change.change(event, Caminho.telaCadCarro, Especificacoes.getSoftwareNome(), true);
            mainStage.show();
    }
    
}
