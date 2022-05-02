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
import mto.models.Classes;
import mto.models.services.Classes_Service;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ClassController implements Initializable {

    public static Classes classes_foredit = null;

    @FXML
    private TableView<Classes> s_classes;

    @FXML
    private TableColumn<Classes, Integer> id;

    @FXML
    private TableColumn<Classes, String> c_name;

    @FXML
    private TableColumn<Classes, String> c_duration;

    @FXML
    private TableColumn<Classes, String> c_start_date;

    ObservableList<Classes> classes = FXCollections.observableArrayList();

    @FXML
    void add_class(ActionEvent event) throws IOException {

        AnchorPane add = FXMLLoader.load(getClass().getResource("../views/class_add.fxml"));
        Main.borderPane.setCenter(add);
    }

    @FXML
    void delete_class(ActionEvent event) {
        if (s_classes.getSelectionModel().getSelectedIndex() > -1){
            Classes_Service classes_service = new Classes_Service();
            int ind = s_classes.getSelectionModel().getSelectedIndex();
            Classes cs = classes.get(ind);
            classes_service.deleteClass(cs);
            s_classes.getItems().remove(ind);
        }else {
            JOptionPane.showMessageDialog(null, "Select one row");
        }
    }

    @FXML
    void edit_class(ActionEvent event) throws IOException {
        if (s_classes.getSelectionModel().getSelectedIndex() > -1) {
            int res = s_classes.getSelectionModel().getFocusedIndex();
            classes_foredit = classes.get(res);
            AnchorPane edit = FXMLLoader.load(getClass().getResource("../views/class_edit.fxml"));
            Main.borderPane.setCenter(edit);
        }else {
            JOptionPane.showMessageDialog(null, "Select one row");
        }

    }

    @FXML
    void goHome(ActionEvent event) throws IOException {
        AnchorPane home = FXMLLoader.load(getClass().getResource("../views/home.fxml"));
        Main.borderPane.setCenter(home);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        c_name.setCellValueFactory(new PropertyValueFactory<>("class_name"));
        c_duration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        c_start_date.setCellValueFactory(new PropertyValueFactory<>("startdate"));

        Classes_Service cs = new Classes_Service();
        List<Classes> cc = cs.getClasses();

        classes.addAll(cc);
        s_classes.setItems(classes);

    }
}
