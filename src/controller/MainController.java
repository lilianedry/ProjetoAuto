package controller;

import model.Caminho;
import model.Especificacoes;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController extends Application {

    @Override
    public void start (Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource(Caminho.telaLogin));

        Scene scene = new Scene(root);

        primaryStage.setTitle(Especificacoes.getSoftwareNome());
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.show();

    }

    public static void main (String[] args)
    {
        launch(args);
    }
}