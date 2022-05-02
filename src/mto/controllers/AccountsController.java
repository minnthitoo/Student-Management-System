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
import mto.models.Accounts;
import mto.models.Office;
import mto.models.Teacher;
import mto.models.services.AccountsSelection;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

public class AccountsController implements Initializable {

    @FXML
    private TableView<Accounts> accounts;

    @FXML
    private TableColumn<Accounts, Integer> id;

    @FXML
    private TableColumn<Accounts, String> email;

    @FXML
    private TableColumn<Accounts, String> password;

    @FXML
    void delete(ActionEvent event) {

    }

    @FXML
    void edit(ActionEvent event) {

    }

    @FXML
    void goHome(ActionEvent event) throws IOException {

        AnchorPane home = FXMLLoader.load(getClass().getResource("../views/home.fxml"));
        Main.borderPane.setCenter(home);

    }

    @FXML
    void show(ActionEvent event) throws IOException {

        accounts.getItems().isEmpty();

        String type = AccountsSelection.getAccount();

        switch (type){
            case "office" : {

                List<Office> officeList = Account_Selection_Controller.getOffice;
                ObservableList office = FXCollections.observableArrayList();

                office.addAll(officeList);

                accounts.getItems().addAll(office);
            } break;

            case "Networking Teacher" : {

                List<Teacher> teachers = Account_Selection_Controller.get_Networking_Teacher;

                ObservableList teach = FXCollections.observableArrayList();

                teach.addAll(teachers);

                accounts.getItems().addAll(teach);

            } break;

            case "Web Development" : {

                List<Teacher> teachers = Account_Selection_Controller.get_Web_Development_Teacher;

                ObservableList teach = FXCollections.observableArrayList();

                teach.addAll(teachers);

                accounts.getItems().addAll(teach);

            } break;
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        password.setCellValueFactory(new PropertyValueFactory<>("password"));
    }
}
