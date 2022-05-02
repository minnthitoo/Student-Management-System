package mto.controllers;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import mto.Main;
import mto.models.Timetable;
import mto.models.services.Timetable_Service;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Timetable_Update_Controller implements Initializable {

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
    void goHome(ActionEvent event) throws IOException {

        AnchorPane home = FXMLLoader.load(getClass().getResource("../views/timetable.fxml"));
        Main.borderPane.setCenter(home);

    }

    @FXML
    void update(ActionEvent event) throws IOException {

        Timetable_Service ts = new Timetable_Service();
        Timetable timetable = new Timetable( TimetableController.timetable.getId(),mon_first.getText(), mon_second.getText(), mon_third.getText(), mon_forth.getText(), tue_first.getText(), tue_second.getText(), tue_third.getText(), tue_forth.getText(), wed_first.getText(), wed_second.getText(), wed_third.getText(), wed_forth.getText(), thu_first.getText(), thu_second.getText(), thu_third.getText(), thu_forth.getText(), fri_first.getText(), fir_second.getText(), fri_third.getText(), fri_forth.getText(), TimetableController.timetable.getMajor());

        int res = ts.updateTimetable(timetable);
        if (res == 1){
            JOptionPane.showMessageDialog(null, "Updated Successfully");
        }else {
            JOptionPane.showMessageDialog(null, "Update Fail");
        }

        TimetableController.timetable = null;

        AnchorPane time = FXMLLoader.load(getClass().getResource("../views/timetable.fxml"));
        Main.borderPane.setCenter(time);


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Timetable timetable = TimetableController.timetable;

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

        fri_first.setText(timetable.getFri_first());
        fir_second.setText(timetable.getFri_second());
        fri_third.setText(timetable.getFri_third());
        fri_forth.setText(timetable.getFri_forth());

    }
}
