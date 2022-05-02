package mto.controllers;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import mto.Main;
import mto.models.Teacher;
import mto.models.services.AccountAdd;
import mto.models.services.TeacherService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Teacher_add_Controller implements Initializable {

    @FXML
    private JFXTextField t_name;

    @FXML
    private JFXTextField t_nrc;

    @FXML
    private ComboBox t_major;

    @FXML
    private JFXTextField t_email;

    @FXML
    private JFXTextField t_phone;

    @FXML
    private JFXTextArea t_address;

    @FXML
    void add(ActionEvent event) throws IOException {
        String password = AccountAdd.getPassword();
        String name = t_name.getText().toString();
        String nrc = t_nrc.getText().toString();
        String major = (String) t_major.getSelectionModel().getSelectedItem();
        String email = t_email.getText().toString();
        String phone = t_phone.getText().toString();
        String address = t_address.getText().toString();

        Teacher teachers = new Teacher(name, nrc, major, email, phone, address, password);

        TeacherService ts = new TeacherService();
        int res = ts.insertTeacher(teachers);
        if (res == 1){
            t_name.setText("");
            t_nrc.setText("");
            t_major.setValue("Programming");
            t_email.setText("");
            t_phone.setText("");
            t_address.setText("");

            AnchorPane teacher = FXMLLoader.load(getClass().getResource("../views/teacher.fxml"));
            Main.borderPane.setCenter(teacher);
        }
    }

    @FXML
    void goHome(ActionEvent event) throws IOException {
        AnchorPane teacher = FXMLLoader.load(getClass().getResource("../views/teacher.fxml"));
        Main.borderPane.setCenter(teacher);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> majors = FXCollections.observableArrayList(
                "Networking", "Programming", "Web Development", "Cyper Security"
        );
        t_major.setValue("Programming");
        t_major.setItems(majors);
    }
}
