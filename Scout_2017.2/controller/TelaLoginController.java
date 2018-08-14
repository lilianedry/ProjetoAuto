package controller;

import java.net.URL; 
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Caminho;
import model.ChangeScreen;
import model.Especificacoes;
import model.Usuario;

public class TelaLoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField campoLogin;

    @FXML
    private PasswordField campoSenha;

    @FXML
    private Label mensagemErro;

    @FXML
    void cliqueBotaoEntrar(ActionEvent event) throws Exception {

    	 if (!campoLogin.getText().trim().isEmpty() && !campoSenha.getText().trim().isEmpty())
         {

             if (Usuario.login(campoLogin.getText().trim(), campoSenha.getText().trim()))
             {

                 ChangeScreen change = new ChangeScreen();

                 Stage mainStage = change.change(event, Caminho.telaPrincipal, Especificacoes.getSoftwareNome(), true);
                 mainStage.show();

             }
             else
             {
                 mensagemErro.setVisible(true);
                 mensagemErro.setText("Login e/ou senha inválido(s)");
             }

         }
         else
         {
             mensagemErro.setVisible(true);
             mensagemErro.setText("Login e/ou senha necessário(s)");
         }
    	
    }

    @FXML
    void initialize() {

    }
}
