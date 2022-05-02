package mto.controllers;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;
import mto.Main;
import mto.models.Classes;
import mto.models.services.Classes_Service;

import javax.swing.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

public class Class_Add_Controller {

    @FXML
    private JFXTextField class_name;

    @FXML
    private JFXTextField class_duration;

    @FXML
    private DatePicker start_date;

    @FXML
    void add(ActionEvent event) throws IOException {
        String name = class_name.getText();
        String duration = class_duration.getText();
        LocalDate date = start_date.getValue();
        String startDate = date.toString();

        Classes clases = new Classes(name, duration, startDate);
        Classes_Service cs = new Classes_Service();
        int res = cs.insertClass(clases);
        if (res == 1){
            JOptionPane.showMessageDialog(null,"Added Successfully");
            AnchorPane home = FXMLLoader.load(getClass().getResource("../views/class.fxml"));
            Main.borderPane.setCenter(home);
        }

    }

    @FXML
    void goHome(ActionEvent event) throws IOException {
        AnchorPane home = FXMLLoader.load(getClass().getResource("../views/class.fxml"));
        Main.borderPane.setCenter(home);
    }

}
