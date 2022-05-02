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
import mto.Main;
import mto.models.Student;
import mto.models.services.StudentService;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class StudentController implements Initializable {
    public static Student s = null;
    @FXML
    private TableView<Student> s_table;

    @FXML
    private TableColumn<Student, Integer> s_id;

    @FXML
    private TableColumn<Student, String> s_name;

    @FXML
    private TableColumn<Student, String> s_nrc;

    @FXML
    private TableColumn<Student, String> s_class;

    @FXML
    private TableColumn<Student, String> s_phone;

    @FXML
    private TableColumn<Student, String> s_email;

    @FXML
    private TableColumn<Student, String> s_address;

    ObservableList<Student> showStudents = FXCollections.observableArrayList();

    @FXML
    void goHome(ActionEvent event) throws IOException {

        AnchorPane home = FXMLLoader.load(getClass().getResource("../views/home.fxml"));
        Main.borderPane.setCenter(home);

    }

    @FXML
    void delete(ActionEvent event) {
        if (s_table.getSelectionModel().getSelectedIndex() > -1) {
            int ind = s_table.getSelectionModel().getFocusedIndex();
            Student st = showStudents.get(ind);
            StudentService sts = new StudentService();
            int res = sts.deleteStudent(st.getId());
            if (res == 1) {
                s_table.getItems().remove(ind);
            }
        }else {
            JOptionPane.showMessageDialog(null, "Select one row");
        }

    }

    @FXML
    void goAdd(ActionEvent event) throws IOException {
        AnchorPane s_add = FXMLLoader.load(getClass().getResource("../views/studentAdd.fxml"));
        Main.borderPane.setCenter(s_add);
    }

    @FXML
    void goEdit(ActionEvent event) throws IOException {
       if (s_table.getSelectionModel().getSelectedIndex() > -1){
            int ind = s_table.getSelectionModel().getSelectedIndex();
            s = showStudents.get(ind);
            AnchorPane edit = FXMLLoader.load(getClass().getResource("../views/studentUpdate.fxml"));
            Main.borderPane.setCenter(edit);
        }else{
           JOptionPane.showMessageDialog(null, "Select one row");
       }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        s_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        s_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        s_nrc.setCellValueFactory(new PropertyValueFactory<>("nrc"));
        s_class.setCellValueFactory(new PropertyValueFactory<>("s_class"));
        s_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        s_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        s_address.setCellValueFactory(new PropertyValueFactory<>("address"));

        StudentService ss = new StudentService();
        List<Student> students = ss.getStudents();

        showStudents.addAll(students);

        s_table.setItems(showStudents);


    }
}
