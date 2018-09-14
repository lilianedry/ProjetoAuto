package controller;

import database.DAOs.FuncionarioDAO;
import database.DAOs.GerenteDAO;
import java.net.URL;
import java.time.Instant;
import java.util.Date;
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
import model.entities.Gerente;

public class TelaLoginController implements Initializable {

    @FXML
    private TextField campoLogin;
    @FXML
    private PasswordField campoSenha;
    @FXML
    private Label mensagemErro;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        GerenteDAO dao = new GerenteDAO();
        List<Gerente> ger = dao.all();
        for(int x =0; x<ger.size() ; x++){
            if(ger.get(x).getCargo().equals("gerente3")){
            Gerente gere = new Gerente("Gerente", "10936736054","173850674", "M",Date.from(Instant.now()), "teste", "teste", "teste", "teste", "teste", "teste", "teste", "gerente3", "teste", "teste", Date.from(Instant.now()));
            gere.setSenha("teste3");
            gere.setLogin("teste3");
            dao.add(gere);
            }
        }   
    }    

    @FXML
    private void cliqueBotaoEntrar(ActionEvent event) throws Exception {
        FuncionarioDAO dao = new FuncionarioDAO();
        List<Funcionario> fun = dao.all();
        GerenteDAO dao1 = new GerenteDAO();
        
        if (Usuario.login(campoLogin.getText(), campoSenha.getText())){
                ChangeScreen change = new ChangeScreen();

                Stage mainStage = change.change(event, Caminho.telaGerente, Especificacoes.getSoftwareNome(), true);
                mainStage.show();
        }
        else{
            if(fun.isEmpty()){
                mensagemErro.setVisible(true);
                mensagemErro.setText("Login e/ou senha inválido(s)");
            }
            for(int x =0; x<fun.size() ; x++){
                if (campoLogin.getText().equals(fun.get(x).getLogin()) && campoSenha.getText().equals(fun.get(x).getSenha())){
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
    }
        

    /*@FXML
    private void sair(ActionEvent event) {
          get a handle to the stage
        Stage stage = (Stage) sair.getScene().getWindow();
        // do what you have to do
        stage.close();
    }*/
    
}
