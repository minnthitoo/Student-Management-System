package mto.models.services;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mto.controllers.AccountAddController;

import java.io.IOException;

public class AccountAdd {

    public static Stage stage;

    public static String getPassword() throws IOException {
        String password = "";

        stage = new Stage();
        AnchorPane anchorPane = FXMLLoader.load(AccountAdd.class.getResource("../../views/accountAdd.fxml"));
        Scene scene = new Scene(anchorPane);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
        password = AccountAddController.ps;
        return password;
    }

}
