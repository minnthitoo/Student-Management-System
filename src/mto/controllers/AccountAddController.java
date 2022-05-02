package mto.controllers;

import com.jfoenix.controls.JFXPasswordField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import mto.models.services.AccountAdd;

public class AccountAddController {

    public static String ps;

    @FXML
    private JFXPasswordField pass;

    @FXML
    private JFXPasswordField repass;

    @FXML
    void goCreate(ActionEvent event) {

        String password = pass.getText();
        String rePassword = repass.getText();
        if (password.contentEquals(rePassword)){

            ps = password;

        }else {
            pass.setText("");
            repass.setText("");
        }

        AccountAdd.stage.close();

    }

}
