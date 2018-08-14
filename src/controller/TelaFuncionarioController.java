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
    private Button gerenciarCli;
    @FXML
    private Button gerenciarCarro;
    @FXML
    private TextField campoPesquisa;
    @FXML
    private TableView<?> listaCli;
    @FXML
    private TableColumn<?, ?> colunaNome;
    @FXML
    private TableColumn<?, ?> colunaCPF;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void gerenciarCli(ActionEvent event) throws Exception {
        ChangeScreen change = new ChangeScreen();

        Stage mainStage = change.change(event, Caminho.telaGerCli, Especificacoes.getSoftwareNome(), true);
        mainStage.show();
    }

    @FXML
    private void gerenciarCarro(ActionEvent event) throws Exception {
        ChangeScreen change = new ChangeScreen();

            Stage mainStage = change.change(event, Caminho.telaGerCarro, Especificacoes.getSoftwareNome(), true);
            mainStage.show();
    }
}
