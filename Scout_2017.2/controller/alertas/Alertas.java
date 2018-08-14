package controller.alertas;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Alertas {
	public static void mostraAlertaInfo(String cabecalho, String conteudo) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Informação");
		alert.setHeaderText(cabecalho);
		alert.setContentText(conteudo);

		alert.showAndWait();
	}

	public static void mostraAlertaConf(String cabecalho, String conteudo) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmação");
		alert.setHeaderText(cabecalho);
		alert.setContentText(conteudo);

		alert.showAndWait();
	}

	public static void mostraAlertaErro(String cabecalho, String conteudo) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Erro");
		alert.setHeaderText(cabecalho);
		alert.setContentText(conteudo);

		alert.showAndWait();
	}

	public static Alert retornaAlerta(AlertType tipo, String titulo, String cabecalho, String conteudo) {
		Alert alert = new Alert(tipo);
		alert.setTitle(titulo);
		alert.setHeaderText(cabecalho);
		alert.setContentText(conteudo);
		return alert;
	}

}
