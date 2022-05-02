package mto.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import mto.Main;

import java.io.IOException;

public class HomeController {

    @FXML
    void goClass(ActionEvent event) throws IOException {
        AnchorPane student = FXMLLoader.load(getClass().getResource("../views/class.fxml"));
        Main.borderPane.setCenter(student);
    }

    @FXML
    void goLogout(ActionEvent event) throws IOException {

        AnchorPane login = FXMLLoader.load(getClass().getResource("../views/login.fxml"));
        Main.borderPane.setCenter(login);

    }

    @FXML
    void goSetting(ActionEvent event) throws IOException {
        AnchorPane setting = FXMLLoader.load(getClass().getResource("../views/accounts.fxml"));
        Main.borderPane.setCenter(setting);
    }

    @FXML
    void goStudent(ActionEvent event) throws IOException {
        AnchorPane student = FXMLLoader.load(getClass().getResource("../views/student.fxml"));
        Main.borderPane.setCenter(student);
    }

    @FXML
    void goTeacher(ActionEvent event) throws IOException {
        AnchorPane teacher = FXMLLoader.load(getClass().getResource("../views/teacher.fxml"));
        Main.borderPane.setCenter(teacher);
    }

    @FXML
    void goTimetable(ActionEvent event) throws IOException {
        AnchorPane timetable = FXMLLoader.load(getClass().getResource("../views/timetable.fxml"));
        Main.borderPane.setCenter(timetable);
    }

}
