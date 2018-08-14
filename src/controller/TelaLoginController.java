package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;


import model.Caminho;
import model.ChangeScreen;
import model.Especificacoes;
import model.Usuario;

public class TelaLoginController implements Initializable {

    @FXML
    private TextField campoLogin;
    @FXML
    private PasswordField campoSenha;
    @FXML
    private Label mensagemErro;
    
    //@Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void cliqueBotaoEntrar(ActionEvent event) throws Exception {
     if (Usuario.login(campoLogin.getText().trim(), campoSenha.getText().trim())){
            ChangeScreen change = new ChangeScreen();

            Stage mainStage = change.change(event, Caminho.telaFunc, Especificacoes.getSoftwareNome(), true);
            mainStage.show();
         }
	     else {
	         mensagemErro.setVisible(true);
	         mensagemErro.setText("Login e/ou senha inválido(s)");
	     }
    }
    
}
