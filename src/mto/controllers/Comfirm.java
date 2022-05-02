package mto.controllers;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import mto.Database.DBConnector;
import mto.models.Office;
import mto.models.services.OfficeService;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class Comfirm implements Initializable {

    public static boolean bool = false;

    @FXML
    private JFXTextField c_username;

    @FXML
    private JFXPasswordField c_password;

    String username;
    String password;

    @FXML
    void enter(ActionEvent event) {

    if (c_username.getText().equals(username) && c_password.getText().equals(password)){
            bool = true;
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String query = "select * from office";
        Connection connection = DBConnector.getConnection();
        PreparedStatement prep = null;
        ResultSet resultSet = null;

        OfficeService officeService = new OfficeService();
        List<Office> offices = officeService.getOffice();

        try {
            prep = connection.prepareStatement(query);
            resultSet = prep.executeQuery();
            while (resultSet.next()){
                offices.add(
                        new Office(
                                resultSet.getString("email"),
                                resultSet.getString("password")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (Office office : offices){
            username = office.getEmail();
            password = office.getPassword();
        }

    }
}
