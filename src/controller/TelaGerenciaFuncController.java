
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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

public class TelaGerenciaFuncController implements Initializable {
   
    @FXML
    private Button salvaFunc;
    @FXML
    private Button editaFunc;
    @FXML
    private Button removeFunc;
    @FXML
    private Button Voltar;
    @FXML
    private TextField campoPesquisa;
    @FXML
    private TableView<?> listaAlunos;
    @FXML
    private TableColumn<?, ?> colunaNome;
    @FXML
    private TableColumn<?, ?> colunaCPF;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void salvaFunc(ActionEvent event) {
    }

    @FXML
    private void editaFunc(ActionEvent event) {
    }

    @FXML
    private void removeFunc(ActionEvent event) {
    }
    
    @FXML
    private void voltarTela(ActionEvent event) {
        System.out.println("Voltando de Cadastro para Login");
        Stage stage = new Stage();  
            try{
                Parent root = FXMLLoader.load(getClass().getResource("../view/TelaGerente.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("Titulo");
                stage.show();
            }catch(IOException e){
                e.printStackTrace();
            }finally{
                stage = (Stage) Voltar.getScene().getWindow();
                stage.close(); //fecha a pagina atual antes de sair
            }
    }
    
}
