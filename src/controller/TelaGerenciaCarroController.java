package controller;

import controller.alerts.Alertas;
import database.DAOs.CarroDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Caminho;
import model.ChangeScreen;
import model.Especificacoes;
import model.entities.Carro;

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
    private TableColumn<?, ?> colunaModelo;
    @FXML
    private TableColumn<?, ?> colunaPlaca;
    @FXML
    private TableView<?> listaVeiculos;
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
        
        Alertas.mostraAlertaInfo("Cadastro de Veículo", "Cadastro realizado com sucesso!");
	
        CarroDAO carDAO = new CarroDAO();
        carDAO.add(car);
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
    }

    @FXML
    private void editaCarro(ActionEvent event) {
    }

}
