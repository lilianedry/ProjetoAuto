package controller;

import controller.alerts.Alertas;
import database.DAOs.CarroDAO;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Caminho;
import model.ChangeScreen;
import model.Especificacoes;
import model.entities.Carro;
import model.entities.Cliente;

public class TelaGerenciaCarroController {
    private static boolean janela;

    public static boolean getJanela() {
        return janela;
    }
    public static void setJanela(boolean janela) {
        TelaGerenciaCarroController.janela = janela;
    }

    @FXML
    private Button insereCarro;
    @FXML
    private Button voltar;
    @FXML
    private Button editaCarro;
    @FXML
    private Button removeCarro;
    @FXML
    private TextField campoPesquisa;
    @FXML
    private TableColumn<Carro, String> colunaPlaca;
    @FXML
    private TableColumn<Carro, String> colunaModelo;
    @FXML
    private TableView<Carro> listaVeiculos;
    @FXML
    private TextField campoPlaca;
    @FXML
    private TextField campoModelo;
    @FXML
    private TextField campoAno;
    @FXML
    private TextField campoCor;
    @FXML
    private TextField campoCambio;
    @FXML
    private TextField campoCombustivel;
    @FXML
    private TextField campoKm;
    @FXML
    private TextField campoChassi;
    @FXML
    private TextArea campoOpcional;

    private Carro selecionado;
    
    public void initialize(URL url, ResourceBundle rb) {
        initTable();
        
        listaVeiculos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
               selecionado = (Carro) newValue;               
            }
        });        
    } 
    
    @FXML
    private void insereCarro(ActionEvent event) {
        Carro car = new Carro();
        
        car.setPlaca(campoPlaca.getText());        
        car.setModelo(campoModelo.getText());
        car.setCor(campoCor.getText());        
        car.setChassi(campoChassi.getText());  
        car.setTipoCambio(campoCambio.getText());
        car.setCombustivel(campoCombustivel.getText());          
        car.setOpcionais(campoOpcional.getText());                
        car.setAnoModelo(campoAno.getText());        
        car.setQuilometragem(campoKm.getText());          
       
        CarroDAO carDAO = new CarroDAO();
        carDAO.add(car);
        listaVeiculos.setItems(atualizaTabela());
        
        Alertas.mostraAlertaInfo("Cadastro de Veículo", "Cadastro realizado com sucesso!");
	
    }

    @FXML
    private void voltar(ActionEvent event) {
        if(janela == true){
            ChangeScreen change = new ChangeScreen();

            Stage mainStage;
            try {
                mainStage = change.change(event, Caminho.telaGerente, Especificacoes.getSoftwareNome(), true);
                mainStage.show();
            } catch (Exception ex) {
                Logger.getLogger(TelaGerenciaCarroController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
             ChangeScreen change = new ChangeScreen();

            Stage mainStage;
            try {
                mainStage = change.change(event, Caminho.telaFunc, Especificacoes.getSoftwareNome(), true);
                mainStage.show();
            } catch (Exception ex) {
                Logger.getLogger(TelaGerenciaCarroController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void removeCarro(ActionEvent event) {
        deleta();
        Alertas.mostraAlertaInfo("Remoção de Veículo", "Veículo removido com sucesso!");
	
    }

    @FXML
    private void editaCarro(ActionEvent event) {
        
        Alertas.mostraAlertaInfo("Edição de Veículo", "Veículo editado com sucesso!");
	
    }
    public void initTable(){
        colunaPlaca.setCellValueFactory(new PropertyValueFactory("placa"));
        colunaModelo.setCellValueFactory(new PropertyValueFactory("modelo"));
        listaVeiculos.setItems(atualizaTabela());
    }
    
    public ObservableList<Carro> atualizaTabela(){
        CarroDAO dao = new CarroDAO();
        return FXCollections.observableArrayList(dao.all());
    }
    
    public void deleta(){
        CarroDAO car = new CarroDAO();
        car.delete(selecionado);
    }
}
