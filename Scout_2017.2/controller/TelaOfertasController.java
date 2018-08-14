package controller;

import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import controller.alertas.Alertas;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.ArrayLists;
import model.Caminho;
import model.ChangeScreen;
import model.Especificacoes;
import model.entidades.OfertaBolsa;
import model.entidades.TipoOfertaBolsa;

public class TelaOfertasController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    private List<TipoOfertaBolsa> lista = new ArrayList<>();
    
    private ObservableList<TipoOfertaBolsa> olista;

    @FXML
    private ComboBox<TipoOfertaBolsa> comboBoxTipoOferta;

    @FXML
    private TextField campoNumeroVagas;

    @FXML
    private DatePicker campoDataInicio;

    @FXML
    private DatePicker campoDataFim;
    
    @FXML
    private Button botaoConfirmar;
    
    @FXML
    private Button botaoCancelar;
    
    public void carregaTipoOferta ()
    {
    	comboBoxTipoOferta.setItems(GerarComboBoxModalidade.gerar(lista, olista));
    }

    @FXML
    void cliqueBotaoConfirmar(ActionEvent event) throws Exception {
    	
    	int nV;
    	Date dI = new Date(), dF = new Date(), dAtual = new Date();
    	LocalDate localDate;
    	Instant instant;
    	
    	TipoOfertaBolsa selecionado = comboBoxTipoOferta.getSelectionModel().getSelectedItem();
    	
    	try {
    		if (selecionado == null)
    			throw new RuntimeException();
    	}
    	catch(RuntimeException re) {
    		Alertas.mostraAlertaInfo("No campo Tipo da Oferta", "Escolha o tipo da oferta a ser cadastrada.");
    		return;
    	}
    	
    	try {
    		if (ArrayLists.ofertaNoArray(selecionado.getId()))
    			throw new IllegalArgumentException();
    	}
    	catch (IllegalArgumentException e) {
    		Alertas.mostraAlertaInfo("No campo Tipo da Oferta", "A modalidade " + selecionado.getId() + " já se encontra cadastrada.");
    		Alertas.mostraAlertaInfo("Modalidades cadastradas", ArrayLists.mostraOfertasCadastradas());
    		return;
    	}
    	
    	try {
    		nV = Integer.parseInt(campoNumeroVagas.getText());
    	}
    	catch (NumberFormatException e)
    	{
    		Alertas.mostraAlertaInfo("No campo Quantidade de Vagas", "O valor do campo deve ser preenchido com número inteiro.");
    		return;
    	}
    	
    	try {
    		if (nV < 1 || nV > 200)
    			throw new IllegalArgumentException();
    	}
    	catch (IllegalArgumentException e) {
    		Alertas.mostraAlertaInfo("No campo Quantidade de Vagas", "O valor do campo deve ser preenchido com um valor acima de zero.");
    		return;
    	}
    	
    	localDate = campoDataInicio.getValue();
    	instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
    	dI = Date.from(instant);

    	dAtual = java.sql.Date.valueOf(LocalDate.now());
    	
    	try {
    		if (dI.before(dAtual))
    			throw new IllegalArgumentException();
    	}
    	catch (IllegalArgumentException e) {
    		Alertas.mostraAlertaInfo("No campo Data de Início", "A data de início deve ser igual ou posterior a data atual.");
    		return;
    	}
    	
    	localDate = campoDataFim.getValue();
    	instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
    	dF = Date.from(instant);
   
    	try {
    		if (dF.before(dI))
    			throw new IllegalArgumentException();
    	}
    	catch (IllegalArgumentException e) {
    		Alertas.mostraAlertaInfo("No campo Data de Encerramento", "A data de fim deve ser igual ou posterior a data de início.");
    		return;
    	}

    	Optional<ButtonType> result = Alertas.retornaAlerta(AlertType.CONFIRMATION, "Confirmação", "Tem certeza que deseja continuar?", "As operações feitas a seguir são irreversíveis!").showAndWait();
    	if(result.get() == ButtonType.OK) {
    		
	    	OfertaBolsa nova = new OfertaBolsa();
	    	nova.setTipoOferta(selecionado.getId());
	    	nova.setNumVagas(nV);
	    	nova.setDataInicio(dI);
	    	nova.setDataFim(dF);
	    	
	    	ArrayLists.adicionaOferta(nova);
	    	
	    	System.out.println(""+nova.getTipoOferta()+"\n"+nova.getNumVagas()+"\n"+nova.getDataInicio()+"\n"+nova.getDataFim());
	    	Alertas.mostraAlertaInfo("Oferta cadastrada com sucesso", "Número de vagas: " + nV + "\nData de início: " + dI + "\nData de término: " + dF);
	    	fecharTela(event);
    	}
    	else {
    		return;
    	}
    }

	@FXML
    void cliqueBotaoCancelar(ActionEvent event) throws Exception {
    	Optional<ButtonType> result = Alertas.retornaAlerta(AlertType.CONFIRMATION, "Confirmação", "Tem certeza que deseja cancelar?", "Todas as alterações feitas até aqui serão perdidas!").showAndWait();
    	if(result.get() == ButtonType.OK) 
    		fecharTela(event);
    }
    
    private void fecharTela (ActionEvent event) throws Exception {
    	ChangeScreen change = new ChangeScreen();

        Stage mainStage = change.change(event, Caminho.telaPrincipal, Especificacoes.getSoftwareNome(), true);
        mainStage.show();
    }

    @FXML
    void initialize() {
    	
    	carregaTipoOferta();
    	campoDataInicio.setValue(LocalDate.now());
    	campoDataFim.setValue(LocalDate.now());
    	
    }
}
