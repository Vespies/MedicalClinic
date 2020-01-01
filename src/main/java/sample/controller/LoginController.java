package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.model.Admin;
import sample.model.Doctor;
import sample.model.Patient;
import sample.model.Secretary;
import sample.service.AdminService;
import sample.service.DoctorService;
import sample.service.PatientService;
import sample.service.SecretaryService;

import java.io.IOException;

public class LoginController {


    @FXML
    public TextField idNumberField;

    @FXML
    public TextField passwordField;

    private PatientService patientService;
    private DoctorService doctorService;
    private SecretaryService secretaryService;
    private AdminService adminService;

    public void initialize(){
        patientService = new PatientService();
        doctorService = new DoctorService();
        secretaryService = new SecretaryService();
        adminService = new AdminService();
    }

    public void login(ActionEvent actionEvent) throws IOException {
        String idNumber = idNumberField.getText();
        String password = passwordField.getText();

        if (idNumber.charAt(0) == 'p'){
            Patient patient = patientService.findByIdNumber(idNumber);
            if (patient != null && patient.getPassword().equals(password)) patientView(actionEvent);
        }else if (idNumber.charAt(0) == 'd'){
            Doctor doctor = doctorService.findByIdNumber(idNumber);
            if (doctor != null && doctor.getPassword().equals(password)) doctorView(actionEvent);
        }else if (idNumber.charAt(0) == 's'){
            Secretary secretary = secretaryService.findByIdNumber(idNumber);
            if (secretary != null && secretary.getPassword().equals(password)) secretaryView(actionEvent);
        }else if (idNumber.charAt(0) == 'a'){
            Admin admin = adminService.findByIdNumber(idNumber);
            if (admin != null && admin.getPassword().equals(password)) adminView(actionEvent);
        }
    }

    private void patientView(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/template/patientHome.fxml"));
        Scene scene = new Scene(parent);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    private void doctorView(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/template/doctorHome.fxml"));
        Scene scene = new Scene(parent);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    private void secretaryView(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/template/secretaryHome.fxml"));
        Scene scene = new Scene(parent);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    private void adminView(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/template/adminHome.fxml"));
        Scene scene = new Scene(parent);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
