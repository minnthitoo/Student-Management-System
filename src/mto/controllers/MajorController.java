package mto.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mto.models.services.Major;

import java.net.URL;
import java.util.ResourceBundle;

public class MajorController implements Initializable {

    public static String major;

    @FXML
    private ComboBox<String> majors;

    @FXML
    void select(ActionEvent event) {

        major = majors.getSelectionModel().getSelectedItem();
        Major.stage.close();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        majors.getItems().addAll("NetWorking", "Programming", "Web Development", "Cyber Security");
        majors.setValue("Programming");

    }
}
