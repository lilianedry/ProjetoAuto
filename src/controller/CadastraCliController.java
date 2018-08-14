package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CadastraCliController implements Initializable {

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
    
}
