package mto.controllers;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mto.Main;
import mto.models.Timetable;
import mto.models.services.Major;
import mto.models.services.Timetable_Service;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Timetable_Add_Controller implements Initializable {

    @FXML
    private JFXTextField mon_first;

    @FXML
    private JFXTextField mon_second;

    @FXML
    private JFXTextField mon_third;

    @FXML
    private JFXTextField mon_forth;

    @FXML
    private JFXTextField tue_first;

    @FXML
    private JFXTextField tue_second;

    @FXML
    private JFXTextField tue_third;

    @FXML
    private JFXTextField tue_forth;

    @FXML
    private JFXTextField wed_first;

    @FXML
    private JFXTextField wed_second;

    @FXML
    private JFXTextField wed_third;

    @FXML
    private JFXTextField wed_forth;

    @FXML
    private JFXTextField thu_first;

    @FXML
    private JFXTextField thu_second;

    @FXML
    private JFXTextField thu_third;

    @FXML
    private JFXTextField thu_forth;

    @FXML
    private JFXTextField fri_first;

    @FXML
    private JFXTextField fir_second;

    @FXML
    private JFXTextField fri_third;

    @FXML
    private JFXTextField fri_forth;

    @FXML
    void add(ActionEvent event) throws IOException {
        String major = Major.getMajor();

        String first_mon = mon_first.getText();
        String second_mon = mon_second.getText();
        String third_mon = mon_third.getText();
        String forth_mon = mon_forth.getText();

        String first_tue = tue_first.getText();
        String second_tue = tue_second.getText();
        String third_tue = tue_third.getText();
        String forth_tue = tue_forth.getText();

        String first_wed = wed_first.getText();
        String second_wed = wed_second.getText();
        String third_wed = wed_third.getText();
        String forth_wed = wed_forth.getText();

        String first_thu = thu_first.getText();
        String second_thu = thu_second.getText();
        String third_thu = thu_third.getText();
        String forth_thu = thu_forth.getText();

        String first_fri = fri_first.getText();
        String second_fri = fir_second.getText();
        String third_fir = fri_third.getText();
        String forth_fri = fri_forth.getText();

        Timetable timetable = new Timetable(first_mon, second_mon, third_mon, forth_mon, first_tue, second_tue, third_tue, forth_tue, first_wed, second_wed, third_wed, forth_wed, first_thu, second_thu, third_thu, forth_thu, first_fri, second_fri, third_fir, forth_fri, major);
        Timetable_Service ts = new Timetable_Service();
        int res = ts.insertTimetable(timetable);
        if (res == 1){
            JOptionPane.showMessageDialog(null, "Inserted Successfully");
        }else {
            JOptionPane.showMessageDialog(null, "Inserted fail");
        }

        AnchorPane prev = FXMLLoader.load(getClass().getResource("../views/timetable.fxml"));
        Main.borderPane.setCenter(prev);

    }

    @FXML
    void goHome(ActionEvent event) throws IOException {

        AnchorPane home = FXMLLoader.load(getClass().getResource("../views/timetable.fxml"));
        Main.borderPane.setCenter(home);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String monday_one = mon_first.getText();
        String monday_two = mon_second.getText();
        String monday_three = mon_third.getText();
        String monday_four = mon_forth.getText();

        String tuesday_one = tue_first.getText();
        String tuesday_two = tue_second.getText();
        String tuesday_three = tue_third.getText();
        String tuesday_four = tue_forth.getText();

        String wednesday_one = wed_first.getText();
        String wednesday_two = wed_second.getText();
        String wednesday_three = wed_third.getText();
        String wednesday_four = wed_forth.getText();

        String thursday_one = thu_first.getText();
        String thursday_two = thu_second.getText();
        String thursday_three = thu_third.getText();
        String thursday_four = thu_forth.getText();

        String friday_one = mon_first.getText();
        String friday_two = mon_second.getText();
        String friday_three = mon_third.getText();
        String friday_four = mon_forth.getText();

    }
}
