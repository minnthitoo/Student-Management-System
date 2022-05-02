package mto.models.services;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mto.controllers.Account_Selection_Controller;

import java.io.IOException;

public class AccountsSelection {

    public static Stage stage;

    public static String getAccount() throws IOException {
        stage = new Stage();
        AnchorPane select = FXMLLoader.load(AccountsSelection.class.getResource("../../views/account_selection.fxml"));

        Scene scene = new Scene(select);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
        return Account_Selection_Controller.type;
    }

}
