package mto;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static Stage stage;
    public static BorderPane borderPane;

    @Override
    public void start(Stage stage) throws Exception {
        Main.stage = stage;
        borderPane = FXMLLoader.load(getClass().getResource("./views/main.fxml"));
        AnchorPane login = FXMLLoader.load(getClass().getResource("./views/login.fxml"));
        Main.borderPane.setCenter(login);
        Main.stage.setScene(new Scene(Main.borderPane));
        Main.stage.setTitle("School");
        Main.stage.setResizable(false);
        Main.stage.getIcons().add(new Image("mto/photos/graduation-hat.png"));
        Main.stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
