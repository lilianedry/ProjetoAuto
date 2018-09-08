package controller;

import model.Caminho;
import model.Especificacoes;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainController extends Application {
    @Override
    public void start (Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(Caminho.telaLogin));

        Scene scene = new Scene(root);

        primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.setTitle(Especificacoes.getSoftwareNome());
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.sizeToScene(); 
        primaryStage.show();
    }

    public static void main (String[] args){
        launch(args);
    }
}