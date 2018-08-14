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

public class TelaGerenteController implements Initializable {

    @FXML
    private Button insereFunc;
    @FXML
    private Button editaFunc;
    @FXML
    private Button removeFunc;
    @FXML
    private Button gerarRelatorio;
    @FXML
    private TextField campoPesquisa;
    @FXML
    private TableView<?> listaClientes;
    @FXML
    private TableColumn<?, ?> colunaNome;
    @FXML
    private TableColumn<?, ?> colunaCPF;

    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void insereFunc(ActionEvent event) throws Exception {
        ChangeScreen change = new ChangeScreen();

        Stage mainStage = change.change(event, Caminho.telaCadFunc, Especificacoes.getSoftwareNome(), true);
        mainStage.show();
    }

    @FXML
    private void editaFunc(ActionEvent event) throws Exception {
        ChangeScreen change = new ChangeScreen();

        Stage mainStage = change.change(event, Caminho.telaEditaFunc, Especificacoes.getSoftwareNome(), true);
        mainStage.show();
    }

    @FXML
    private void removeFunc(ActionEvent event) throws Exception {
        ChangeScreen change = new ChangeScreen();

        Stage mainStage = change.change(event, Caminho.telaRemoveFunc, Especificacoes.getSoftwareNome(), true);
        mainStage.show();
    }

    @FXML
    private void geraRelatorio(ActionEvent event) throws Exception {
        ChangeScreen change = new ChangeScreen();

        Stage mainStage = change.change(event, Caminho.telaRelatorios, Especificacoes.getSoftwareNome(), true);
        mainStage.show();
    }
}
