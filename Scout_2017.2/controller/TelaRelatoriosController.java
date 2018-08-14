package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import model.ArrayLists;
import model.Caminho;
import model.ChangeScreen;
import model.Especificacoes;
import model.GerarPDF;
import model.entidades.TipoOfertaBolsa;

public class TelaRelatoriosController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button botaoVoltar;

    @FXML
    private Button botaoGerar;
    
    private List<TipoOfertaBolsa> lista = new ArrayList<>();
    
    private ObservableList<TipoOfertaBolsa> olista;
    
    @FXML
    private ComboBox<TipoOfertaBolsa> comboBoxModalidade;
    
    public void carregaTipoModalidade ()
    {
    	comboBoxModalidade.setItems(GerarComboBoxModalidade.gerarCadastradas(lista, olista));
    }

    @FXML
    void cliqueBotaoGerar(ActionEvent event) {
    	TipoOfertaBolsa tof = comboBoxModalidade.getSelectionModel().getSelectedItem();
    	GerarPDF.geraListaSelecionados(tof, ArrayLists.alunoAptoArray, ArrayLists.pegaOfertasCadastradas(tof.getId()));
    	GerarPDF.geraRelatorioOferta(tof, ArrayLists.pegaOfertasCadastradas(tof.getId()));
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
    	carregaTipoModalidade();
    }
}