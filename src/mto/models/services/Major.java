package mto.models.services;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mto.controllers.MajorController;

import java.io.IOException;


public class Major {

    public static Stage stage;

    public static String getMajor() throws IOException {

        stage = new Stage();
        AnchorPane selectMajor = FXMLLoader.load(Major.class.getResource("../../views/major.fxml"));

        Scene scene = new Scene(selectMajor);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();

        String major = MajorController.major;
        return major;
    }

}
