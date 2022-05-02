package mto.controllers;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;
import mto.Main;
import mto.models.Classes;
import mto.models.services.Classes_Service;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Class_Edit_Controller implements Initializable {

    @FXML
    private JFXTextField class_name;

    @FXML
    private JFXTextField class_duration;

    @FXML
    private DatePicker start_date;

    @FXML
    void add(ActionEvent event) throws IOException {

        Classes_Service cs = new Classes_Service();

        String name = class_name.getText();
        String duration = class_duration.getText();
        LocalDate d = start_date.getValue();
        String class_date = d.toString();
        Classes classes = new Classes( ClassController.classes_foredit.getId(),name, duration, class_date);
        cs.updateClass(classes);

        AnchorPane back = FXMLLoader.load(getClass().getResource("../views/class.fxml"));
        Main.borderPane.setCenter(back);

    }

    @FXML
    void goHome(ActionEvent event) throws IOException {

        AnchorPane back = FXMLLoader.load(getClass().getResource("../views/class.fxml"));
        Main.borderPane.setCenter(back);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        class_name.setText(ClassController.classes_foredit.getClass_name());
        class_duration.setText(ClassController.classes_foredit.getDuration());

    }
}
