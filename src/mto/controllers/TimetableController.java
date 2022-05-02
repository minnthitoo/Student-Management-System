package mto.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import mto.Main;
import mto.models.Timetable;
import mto.models.services.Major;
import mto.models.services.Timetable_Service;

import javax.swing.*;
import java.io.IOException;
import java.sql.Time;

public class TimetableController {

    public static Timetable timetable = null;

    @FXML
    private Label mon_first;

    @FXML
    private Label mon_second;

    @FXML
    private Label mon_third;

    @FXML
    private Label mon_forth;

    @FXML
    private Label tue_first;

    @FXML
    private Label wed_first;

    @FXML
    private Label thu_first;

    @FXML
    private Label fir_first;

    @FXML
    private Label tue_second;

    @FXML
    private Label wed_second;

    @FXML
    private Label thu_second;

    @FXML
    private Label fri_second;

    @FXML
    private Label tue_third;

    @FXML
    private Label wed_third;

    @FXML
    private Label thu_third;

    @FXML
    private Label fri_third;

    @FXML
    private Label tue_forth;

    @FXML
    private Label wed_forth;

    @FXML
    private Label thu_forth;

    @FXML
    private Label fri_forth;

    @FXML
    void add(ActionEvent event) throws IOException {

        AnchorPane add = FXMLLoader.load(getClass().getResource("../views/timetable_add.fxml"));
        Main.borderPane.setCenter(add);

    }

    @FXML
    void delete(ActionEvent event) throws IOException {
        String major = Major.getMajor();

        Timetable_Service ts = new Timetable_Service();
        Timetable timetable = ts.getTimetables(major);

        int res = ts.deleteTimetable(timetable);

        if (res == 1){
            JOptionPane.showMessageDialog(null, "Deleted Successfully");
        }else {
            JOptionPane.showMessageDialog(null, "Delete Fail");
        }

    }

    @FXML
    void edit(ActionEvent event) throws IOException {
        String major = Major.getMajor();
        Timetable_Service ts = new Timetable_Service();
        timetable = ts.getTimetables(major);

        AnchorPane edit = FXMLLoader.load(getClass().getResource("../views/timetable_update.fxml"));
        Main.borderPane.setCenter(edit);


    }

    @FXML
    void goHome(ActionEvent event) throws IOException {

        AnchorPane home = FXMLLoader.load(getClass().getResource("../views/home.fxml"));
        Main.borderPane.setCenter(home);

    }

    @FXML
    void show(ActionEvent event) throws IOException {

        String major = Major.getMajor();

        Timetable_Service ts = new Timetable_Service();
        Timetable timetable = ts.getTimetables(major);

        if (timetable == null){
            JOptionPane.showMessageDialog(null, "There is no Timetable");
        }else {

            mon_first.setText(timetable.getMon_first());
            mon_second.setText(timetable.getMon_second());
            mon_third.setText(timetable.getMon_third());
            mon_forth.setText(timetable.getMon_forth());

            tue_first.setText(timetable.getTue_first());
            tue_second.setText(timetable.getTue_second());
            tue_third.setText(timetable.getTue_third());
            tue_forth.setText(timetable.getTue_forth());

            wed_first.setText(timetable.getWed_first());
            wed_second.setText(timetable.getWed_second());
            wed_third.setText(timetable.getWed_third());
            wed_forth.setText(timetable.getWed_forth());

            thu_first.setText(timetable.getThu_first());
            thu_second.setText(timetable.getThu_second());
            thu_third.setText(timetable.getThu_third());
            thu_forth.setText(timetable.getThu_forth());

            fir_first.setText(timetable.getFri_first());
            fri_second.setText(timetable.getFri_second());
            fri_third.setText(timetable.getFri_third());
            fri_forth.setText(timetable.getFri_forth());

        }

    }

}
