package mto.controllers;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import mto.Main;
import mto.models.Student;
import mto.models.services.AccountAdd;
import mto.models.services.StudentService;

import java.io.IOException;

public class StudentAddController {

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

        String password = AccountAdd.getPassword();

        String name = s_name.getText();
        String nrc = s_nrc.getText();
        String st_class = s_class.getText();
        String phone = s_phone.getText();
        String email = s_email.getText();
        String address = s_address.getText();

        Student student = new Student(name, nrc, st_class, phone, email, address, password);
        StudentService st = new StudentService();
        int res = st.insertStudent(student);
        if (res == 1){
            s_name.setText("");
            s_nrc.setText("");
            s_class.setText("");
            s_phone.setText("");
            s_email.setText("");
            s_address.setText("");
        }

    }

    @FXML
    void goHome(ActionEvent event) throws IOException {

        AnchorPane gohome = FXMLLoader. load(getClass().getResource("../views/student.fxml"));
        Main.borderPane.setCenter(gohome);

    }

}
