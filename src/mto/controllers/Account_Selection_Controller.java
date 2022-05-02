package mto.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import mto.models.Office;
import mto.models.Student;
import mto.models.Teacher;
import mto.models.services.AccountsSelection;
import mto.models.services.OfficeService;
import mto.models.services.TeacherService;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Account_Selection_Controller implements Initializable {

    public static String type;

    public static List<Office> getOffice;

    public static List<Teacher> get_Networking_Teacher;
    public static List<Teacher> get_Programming_Teacher;
    public static List<Teacher> get_Web_Development_Teacher;
    public static List<Teacher> get_Cyber_Security;

    public static List<Student> get_Networking_Student;
    public static List<Student> get_Programming_Student;
    public static List<Student> get_Web_Development_Student;
    public static List<Student> get_cyber_Security_Student;

    @FXML
    private MenuItem office;

    @FXML
    private MenuItem teacher_networking;

    @FXML
    private MenuItem teacher_programming;

    @FXML
    private MenuItem teacher_web_development;

    @FXML
    private MenuItem teacher_cyber_security;

    @FXML
    private MenuItem student_networking;

    @FXML
    private MenuItem student_programming;

    @FXML
    private MenuItem student_web_development;

    @FXML
    private MenuItem student_cyber_security;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        office.setOnAction(event -> {
            OfficeService officeService = new OfficeService();
            getOffice = officeService.getOffice();
            AccountsSelection.stage.close();;
            type = "office";
        });

        teacher_networking.setOnAction(event -> {
            TeacherService teacherService = new TeacherService();
            get_Networking_Teacher = teacherService.getTeachers("Networking");
            AccountsSelection.stage.close();
            type = "Networking Teacher";
        });

        teacher_web_development.setOnAction(event -> {
            TeacherService teacherService = new TeacherService();
            get_Web_Development_Teacher = teacherService.getTeachers("Web Development");
            AccountsSelection.stage.close();
            type = "Web Development";
        });
    }
}
