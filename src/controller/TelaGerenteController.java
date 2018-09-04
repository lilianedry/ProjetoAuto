package controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    private static void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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
    @FXML
    private Button gerenciaFunc;
    @FXML
    private Button gerenciaCarro;
    @FXML
    private Button gerenciaCli;
    @FXML
    private Button locarVeiculo;

    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void geraRelatorio(ActionEvent event) throws Exception {
        ChangeScreen change = new ChangeScreen();

        Stage mainStage = change.change(event, Caminho.telaRelatorios, Especificacoes.getSoftwareNome(), true);
        mainStage.show();
    }

    @FXML
    private void gerenciaFunc(ActionEvent event) {
        try {
            ChangeScreen change = new ChangeScreen();
            
            Stage mainStage = change.change(event, Caminho.telaGerFunc, Especificacoes.getSoftwareNome(), true);
            mainStage.show();
        } catch (Exception ex) {
            Logger.getLogger(TelaGerenteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void gerenciaCarro(ActionEvent event) throws Exception {
        ChangeScreen change = new ChangeScreen();
        TelaGerenciaCarroController car = new TelaGerenciaCarroController();
        car.setJanela(true);
        Stage mainStage = change.change(event, Caminho.telaGerCarro, Especificacoes.getSoftwareNome(), true);
        mainStage.show();
    }

    @FXML
    private void gerenciaCli(ActionEvent event) throws Exception {
        ChangeScreen change = new ChangeScreen();
        TelaGerenciaCliController cli = new  TelaGerenciaCliController();
        cli.setJanela(true);
        Stage mainStage = change.change(event, Caminho.telaGerCli, Especificacoes.getSoftwareNome(), true);
        mainStage.show();
    }

    @FXML
    private void locarVeiculo(ActionEvent event) throws Exception {
        ChangeScreen change = new ChangeScreen();
        TelaLocarVeiculosController locar = new  TelaLocarVeiculosController();
        locar.setJanela(true);
        Stage mainStage = change.change(event, Caminho.telaLocar, Especificacoes.getSoftwareNome(), true);
        mainStage.show();
    }
}
