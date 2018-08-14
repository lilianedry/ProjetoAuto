
package controller;

import java.net.URL; 
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import model.ArrayLists;
import model.Caminho;
import model.ChangeScreen;
import model.Especificacoes;

public class TelaPrincipalController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button botaoAlunos;

	@FXML
	private Button botaoRelatorios;

	@FXML
	void cliquePainelAlunos(ActionEvent event) throws Exception {
		ChangeScreen change = new ChangeScreen();

		Stage ofertasStage = change.change(event, Caminho.telaAlunos, Especificacoes.getSoftwareNome(), true);
		ofertasStage.show();
	}

	@FXML
	void cliquePainelOfertas(ActionEvent event) throws Exception {

		ChangeScreen change = new ChangeScreen();

		Stage ofertasStage = change.change(event, Caminho.telaOfertas, Especificacoes.getSoftwareNome(), true);
		ofertasStage.show();

	}

	@FXML
	void cliquePainelRelatorios(ActionEvent event) throws Exception {
		ChangeScreen change = new ChangeScreen();

		Stage ofertasStage = change.change(event, Caminho.telaRelatorios, Especificacoes.getSoftwareNome(), true);
		ofertasStage.show();

	}

	@FXML
	private Button botaoLogout;

	@FXML
	void cliqueBotaoLogout(ActionEvent event) throws Exception {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmação");
		alert.setHeaderText("Tem certeza que deseja sair?");
		alert.setContentText("Todos os dados serão salvos adequadamente");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			fecharTela(event);
		} else {

		}
	}

	private void fecharTela(ActionEvent event) throws Exception {
		ChangeScreen change = new ChangeScreen();

		Stage mainStage = change.change(event, Caminho.telaLogin, Especificacoes.getSoftwareNome(), false);
		mainStage.show();
	}

	@FXML
	void initialize() {
		if (ArrayLists.tobArray.isEmpty())
			botaoAlunos.setDisable(true);
		else
			botaoAlunos.setDisable(false);
		if (ArrayLists.alunoArray.isEmpty() && ArrayLists.alunoAptoArray.isEmpty())
			botaoRelatorios.setDisable(true);
		else
			botaoRelatorios.setDisable(false);
	}
}