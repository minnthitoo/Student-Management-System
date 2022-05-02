package mto.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import mto.Database.DBConnector;
import mto.Main;
import mto.models.Teacher;
import mto.models.services.TeacherService;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class TeacherController implements Initializable {

    public static Teacher updateTeacher;

    @FXML
    private TableView<Teacher> teacher;

    @FXML
    private TableColumn<Teacher, Integer> id;

    @FXML
    private TableColumn<Teacher, String> name;

    @FXML
    private TableColumn<Teacher, String> nrc;

    @FXML
    private TableColumn<Teacher, String> major;

    @FXML
    private TableColumn<Teacher, String> email;

    @FXML
    private TableColumn<Teacher, String> phone;

    @FXML
    private TableColumn<Teacher, String> address;

    ObservableList<Teacher> showTeachers = FXCollections.observableArrayList();

    @FXML
    void goPrevious(ActionEvent event) throws IOException {
        AnchorPane home = FXMLLoader.load(getClass().getResource("../views/home.fxml"));
        Main.borderPane.setCenter(home);
    }

    @FXML
    void teacher_add(ActionEvent event) throws IOException {
        AnchorPane teacher_add = FXMLLoader.load(getClass().getResource("../views/teacher_add.fxml"));
        Main.borderPane.setCenter(teacher_add);
    }

    @FXML
    void goDelete(ActionEvent event) {
        if (teacher.getSelectionModel().getSelectedIndex() > -1) {
            int ind = teacher.getSelectionModel().getFocusedIndex();
            updateTeacher = showTeachers.get(ind);
            Connection connection = DBConnector.getConnection();
            PreparedStatement ps = null;

            String query = "delete from teacher where id=?";

            try {
                ps = connection.prepareStatement(query);
                ps.setInt(1, updateTeacher.getId());
                int i = ps.executeUpdate();
                if (i == 1) {
                    JOptionPane.showMessageDialog(null, "Deleted Completely");
                    teacher.getItems().remove(ind);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            DBConnector.CloseConnection(connection, ps, null);
        }else {
            JOptionPane.showMessageDialog(null, "Select one row");
        }
    }

    @FXML
    void goEdit(ActionEvent event) throws IOException {
        if (teacher.getSelectionModel().getSelectedIndex() > -1) {
            int ind = teacher.getSelectionModel().getSelectedIndex();
            updateTeacher = showTeachers.get(ind);
            System.out.println(teacher);
            AnchorPane edit = FXMLLoader.load(getClass().getResource("../views/teacher_update.fxml"));
            Main.borderPane.setCenter(edit);
        }else{
            JOptionPane.showMessageDialog(null, "Select one row");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        nrc.setCellValueFactory(new PropertyValueFactory<>("nrc"));
        major.setCellValueFactory(new PropertyValueFactory<>("major"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));

        TeacherService ts = new TeacherService();
        List<Teacher> teachers = ts.getTeachers();

        showTeachers.addAll(teachers);
        System.out.println(teachers);

        teacher.setItems(showTeachers);

    }
}
