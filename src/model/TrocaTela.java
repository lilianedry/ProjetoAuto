package model;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.event.ActionEvent;

public class TrocaTela {

    public Stage change (ActionEvent event, String path, String name, Boolean exp) throws Exception
    {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(path));

        Parent screenParent = loader.load();
        Scene screeScene = new Scene(screenParent);

        Stage screenStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        screenStage.close();
        screenStage.setTitle(name);
        screenStage.setScene(screeScene);
        screenStage.centerOnScreen();
        screenStage.setResizable(exp);

        return screenStage;
    }

}