package controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Caminho;
import model.ChangeScreen;
import model.Especificacoes;

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
    private void insereCarro(ActionEvent event) {
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
