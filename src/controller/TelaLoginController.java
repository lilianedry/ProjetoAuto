package controller;

import database.DAOs.FuncionarioDAO;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;


import model.Caminho;
import model.ChangeScreen;
import model.Especificacoes;
import model.Usuario;
import model.entities.Funcionario;

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
        FuncionarioDAO dao = new FuncionarioDAO();
        List<Funcionario> fun = dao.all();
        
        for(int x =0; x<fun.size() ; x++){
            if (Usuario.login(campoLogin.getText().trim(), campoSenha.getText().trim())){
                x = fun.size();
                ChangeScreen change = new ChangeScreen();

                Stage mainStage = change.change(event, Caminho.telaGerente, Especificacoes.getSoftwareNome(), true);
                mainStage.show();
            }
            else if (campoLogin.getText().equals(fun.get(x).getLogin()) && campoSenha.getText().equals(fun.get(x).getSenha())){
                x = fun.size();
                ChangeScreen change = new ChangeScreen();

                Stage mainStage = change.change(event, Caminho.telaFunc, Especificacoes.getSoftwareNome(), true);
                mainStage.show();
            }
            else {
                if(x == fun.size()-1){
                mensagemErro.setVisible(true);
                mensagemErro.setText("Login e/ou senha inválido(s)");
                }
            }
        }
    }

    /*@FXML
    private void sair(ActionEvent event) {
          get a handle to the stage
        Stage stage = (Stage) sair.getScene().getWindow();
        // do what you have to do
        stage.close();
    }*/
    
}
