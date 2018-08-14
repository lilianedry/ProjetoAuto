package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.ArrayLists;
import model.Caminho;
import model.ChangeScreen;
import model.Especificacoes;
import model.entidades.Aluno;

public class TelaAlunosController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField campoPesquisa;
    
    @FXML
    private Button botaoPesquisar;
    
    @FXML
    private TableView<Aluno> listaAlunos;
    
    @FXML
    private TableColumn<Aluno, String> colunaNome;

    @FXML
    private TableColumn<Aluno, String> colunaCPF;
    
    @FXML
    private Button botaoVoltar;
    
    @FXML
    private Button botaoEditar;

    @FXML
    void cliqueAlunosCadastro(ActionEvent event) throws Exception {

    	ChangeScreen change = new ChangeScreen();

        Stage ofertasStage = change.change(event, Caminho.telaAlunosCadastro, Especificacoes.getSoftwareNome(), true);
        ofertasStage.show();
    	
    }

    @FXML
    void cliqueBotaoPesquisar(ActionEvent event) {
    	listaAlunos.setItems(listaDiscentes());
    	
    }
    
    @FXML
    void cliqueBotaoEditar(ActionEvent event) {
    }
    
    @FXML
    void cliqueBotaoVoltar(ActionEvent event) throws Exception {
    	fecharTela(event);	
    }
    
    private void fecharTela (ActionEvent event) throws Exception {
    	ChangeScreen change = new ChangeScreen();

        Stage mainStage = change.change(event, Caminho.telaPrincipal, Especificacoes.getSoftwareNome(), true);
        mainStage.show();
    }


    @FXML
    void initialize() {
    	colunaNome.setCellValueFactory(new PropertyValueFactory<Aluno, String>("nomePessoa"));
    	colunaCPF.setCellValueFactory(new PropertyValueFactory<Aluno, String>("CPFPessoa")); 		
    }
    
    private ObservableList<Aluno> listaDiscentes(){
    	return FXCollections.observableArrayList(ArrayLists.buscar(campoPesquisa.getText()));
    }
}
