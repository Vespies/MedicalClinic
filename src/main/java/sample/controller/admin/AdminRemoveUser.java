package sample.controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import sample.db.DataBase;
import sample.model.Admin;
import sample.model.Doctor;
import sample.model.Patient;
import sample.model.Secretary;
import sample.service.AdminService;
import sample.service.LoggedUser;

import java.io.IOException;

// communication with adminHome.fxml
public class AdminRemoveUser {

    @FXML
    private ListView<Patient> patientList;

    @FXML
    private ListView<Secretary> secretaryList;

    @FXML
    private ListView<Doctor> doctorList;

    @FXML
    private ListView<Admin> adminList;

    private AdminService adminService;

    public void initialize() {
        adminService = new AdminService();
        patientList.getItems().setAll(DataBase.getInstance().getPatientList());
        secretaryList.getItems().setAll(DataBase.getInstance().getSecretaryList());
        doctorList.getItems().setAll(DataBase.getInstance().getDoctorList());
        adminList.getItems().setAll(DataBase.getInstance().getAdminList());
    }

    // calling removePatient when clicking on the button
    public void removePatient(ActionEvent actionEvent) {
        Patient patient = patientList.getSelectionModel().getSelectedItem();

        // updating the list when a patient is removed
        if (adminService.removePatient(patient))
            patientList.getItems().setAll(DataBase.getInstance().getPatientList());
    }

    // calling removeSecretary when clicking on the button
    public void removeSecretary(ActionEvent actionEvent) {
        Secretary secretary = secretaryList.getSelectionModel().getSelectedItem();

        if (adminService.removeSecretary(secretary))
            secretaryList.getItems().setAll(DataBase.getInstance().getSecretaryList());
    }

    // calling removeDoctor when clicking on the button
    public void removeDoctor(ActionEvent actionEvent) {
        Doctor doctor = doctorList.getSelectionModel().getSelectedItem();

        if (adminService.removeDoctor(doctor))
            doctorList.getItems().setAll(DataBase.getInstance().getDoctorList());
    }

    // calling removeAdmin when clicking on the button
    public void removeAdmin(ActionEvent actionEvent) throws IOException {
        Admin admin = adminList.getSelectionModel().getSelectedItem();

        if (adminService.removeAdmin(admin)) {


            // removing yourself when being logged in logs you out
            if (LoggedUser.getInstance().getAdmin().equals(admin)) {
                logout(actionEvent);
            } else {
                adminList.getItems().setAll(DataBase.getInstance().getAdminList());
            }
        }
    }

    // changing view to adminHome
    public void adminHomeView(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/template/adminHome.fxml"));
        Scene scene = new Scene(parent);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    // logging out
    public void logout(ActionEvent actionEvent) throws IOException {
        LoggedUser.getInstance().logout();
        Parent parent = FXMLLoader.load(getClass().getResource("/template/login.fxml"));
        Scene scene = new Scene(parent);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
