package controller;

import java.net.URL;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Caminho;
import model.ChangeScreen;
import model.Especificacoes;
import model.entities.relationships.SolicitaCarro;

public class TelaFuncionarioController implements Initializable {

    @FXML
    private Button gerenciarCli;
    @FXML
    private Button gerenciarCarro;
    @FXML
    private TextField campoPesquisa;
    @FXML
    private Button locarVeiculo;
    @FXML
    private TableColumn<SolicitaCarro, String> colunaNome; 
    @FXML
    private TableColumn<?, String> colunaPlaca;
    @FXML
    private TableColumn<SolicitaCarro, Date> colunaDataVenc;
    @FXML
    private TableView<SolicitaCarro> listaAluguel;
    
    private SolicitaCarro selecionado;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initTable();        
        listaAluguel.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                selecionado = (SolicitaCarro) newValue;  
                System.out.println(selecionado.toString());
            }
        });  
    }    

    @FXML
    private void gerenciarCli(ActionEvent event) throws Exception {
        ChangeScreen change = new ChangeScreen();
        TelaGerenciaCliController cli = new  TelaGerenciaCliController();
        cli.setJanela(false);
        Stage mainStage = change.change(event, Caminho.telaGerCli, Especificacoes.getSoftwareNome(), true);
        mainStage.show();
    }

    @FXML
    private void gerenciarCarro(ActionEvent event) throws Exception {
        ChangeScreen change = new ChangeScreen();
            TelaGerenciaCarroController car = new TelaGerenciaCarroController();
            car.setJanela(false);
            Stage mainStage = change.change(event, Caminho.telaGerCarro, Especificacoes.getSoftwareNome(), true);
            mainStage.show();
    }
    @FXML
    private void locarVeiculo(ActionEvent event) throws Exception {
        ChangeScreen change = new ChangeScreen();
        TelaLocarVeiculosController locar = new  TelaLocarVeiculosController();
        locar.setJanela(false);
        Stage mainStage = change.change(event, Caminho.telaLocar, Especificacoes.getSoftwareNome(), true);
        mainStage.show();
    }
    
    public void initTable(){
        colunaNome.setCellValueFactory(new PropertyValueFactory("nome"));
        colunaPlaca.setCellValueFactory(new PropertyValueFactory("placa"));
        colunaDataVenc.setCellValueFactory(new PropertyValueFactory("vencimento"));
        listaAluguel.setItems(atualizaTabela());
    }
    
    public ObservableList<SolicitaCarro> atualizaTabela(){
        /*CarroDAO dao = new CarroDAO();
        return FXCollections.observableArrayList(dao.all());*/
        return null;
    }

    @FXML
    private void itemSair(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmação");
        alert.setHeaderText("Tem certeza que deseja sair?");
        alert.setContentText("Terá que logar novamente.");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            System.exit(0);
        } 
        else { }
    }
}
