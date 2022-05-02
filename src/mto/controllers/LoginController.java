package mto.controllers;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import mto.Database.DBConnector;
import mto.Main;
import mto.models.Office;
import mto.models.services.OfficeService;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    String username;
    String password;

    @FXML
    private JFXTextField name;

    @FXML
    private JFXPasswordField pass;

    @FXML
    void showHome(ActionEvent event) throws IOException {

        if (name.getText().toString().equals(username) && pass.getText().toString().equals(password)){
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("../views/home.fxml"));
            Main.borderPane.setCenter(anchorPane);
        }else {
            name.setText("");
            pass.setText("");
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
