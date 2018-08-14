package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TelaAlertaController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button botaoOK;

    @FXML
    private Button botaoCancelar;

    @FXML
    void cliqueBotaoCancelar(ActionEvent event) {

    	Stage atual = (Stage) botaoCancelar.getScene().getWindow();
    	atual.close();
    	
    }

    @FXML
    void cliqueBotaoOK(ActionEvent event) {

    	Stage atual = (Stage) botaoCancelar.getScene().getWindow();
    	
    	atual.close();
    	
    	
    }

    @FXML
    void initialize() {
    	
    	

    }
}