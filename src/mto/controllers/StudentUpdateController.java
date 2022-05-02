package mto.controllers;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import mto.Main;
import mto.models.Student;
import mto.models.services.StudentService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentUpdateController implements Initializable {

    @FXML
    private JFXTextField s_name;

    @FXML
    private JFXTextField s_nrc;

    @FXML
    private JFXTextField s_class;

    @FXML
    private JFXTextField s_phone;

    @FXML
    private JFXTextField s_email;

    @FXML
    private JFXTextArea s_address;

    @FXML
    void add(ActionEvent event) throws IOException {
        String name = s_name.getText();
        String nrc = s_nrc.getText();
        String ss_class = s_class.getText();
        String phone = s_phone.getText();
        String email = s_email.getText();
        String address = s_address.getText();
        StudentService ss = new StudentService();
        Student student = new Student(StudentController.s.getId(), name, nrc, ss_class, phone, email, address);
        int res = ss.studentUpdate(student);
        if (res == 1){
            AnchorPane home = FXMLLoader.load(getClass().getResource("../views/student.fxml"));
            Main.borderPane.setCenter(home);
        }
        StudentController.s = null;

    }

    @FXML
    void goHome(ActionEvent event) throws IOException {

        AnchorPane home = FXMLLoader.load(getClass().getResource("../views/student.fxml"));
        Main.borderPane.setCenter(home);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        s_name.setText(StudentController.s.getName());
        s_nrc.setText(StudentController.s.getNrc());
        s_class.setText(StudentController.s.getS_class());
        s_phone.setText(StudentController.s.getPhone());
        s_email.setText(StudentController.s.getEmail());
        s_address.setText(StudentController.s.getAddress());
    }
}
