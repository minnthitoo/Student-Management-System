package mto.controllers;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import mto.Database.DBConnector;
import mto.Main;
import mto.models.Teacher;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Teacher_Update_Controller implements Initializable {

    Teacher t = TeacherController.updateTeacher;

    @FXML
    private JFXTextField t_name;

    @FXML
    private JFXTextField t_nrc;

    @FXML
    private JFXTextField t_major;

    @FXML
    private JFXTextField t_email;

    @FXML
    private JFXTextField t_phone;

    @FXML
    private JFXTextArea t_address;

    @FXML
    void edit(ActionEvent event) throws IOException {
//        AnchorPane dialog = FXMLLoader.load(getClass().getResource("../views/comfirm.fxml"));
//        Stage conform = new Stage();
//        conform.setResizable(false);
//        conform.setTitle("Confirm");
//        Scene scene = new Scene( dialog);
//        conform.setScene(scene);
//
//        conform.show();
        editTecher();
//        if (Comfirm.bool){
//
//        }

    }

    ObservableList<Teacher> teachers = FXCollections.observableArrayList();

    @FXML
    void goHome(ActionEvent event) throws IOException {

        AnchorPane home = FXMLLoader.load(getClass().getResource("../views/teacher.fxml"));
        Main.borderPane.setCenter(home);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        t_name.setText(t.getName());
        t_nrc.setText(t.getNrc());
        t_major.setText(t.getMajor());
        t_email.setText(t.getEmail());
        t_phone.setText(t.getPhone());
        t_address.setText(t.getAddress());
    }

    private void editTecher(){

        String name = t_name.getText().toString();
        String nrc = t_nrc.getText().toString();
        String major = t_major.getText().toString();
        String email = t_email.getText().toString();
        String phone = t_phone.getText().toString();
        String address = t_address.getText().toString();

        Connection connection = DBConnector.getConnection();
        PreparedStatement ps = null;

        String query = "update teacher set name=?, nrc=?, major=?, email=?, phone=?, address=? where id=?";

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, nrc);
            ps.setString(3, major);
            ps.setString(4, email);
            ps.setString(5, phone);
            ps.setString(6, address);
            ps.setInt(7, t.getId());
            int i = ps.executeUpdate();
            if (i == 1){
                JOptionPane.showMessageDialog(null, "Updated Completely");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        DBConnector.CloseConnection(connection, ps, null);

    }
}
