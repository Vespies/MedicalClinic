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
import sample.service.LoggedUser;

import java.io.IOException;

public class AdminRemoveUser {

    @FXML
    public ListView<Patient> patientList;
    public ListView<Secretary> secretaryList;
    public ListView<Doctor> doctorList;
    public ListView<Admin> adminList;

    public void initialize() {
        patientList.getItems().setAll(DataBase.getInstance().getPatientList());
        secretaryList.getItems().setAll(DataBase.getInstance().getSecretaryList());
        doctorList.getItems().setAll(DataBase.getInstance().getDoctorList());
        adminList.getItems().setAll(DataBase.getInstance().getAdminList());
    }

    public void removePatient(ActionEvent actionEvent) {
        Patient patient = patientList.getSelectionModel().getSelectedItem();

        if (patient != null) {
            DataBase.getInstance().getPatientList().remove(patient);

            for (int i = 0; i < DataBase.getInstance().getPatientList().size(); i++) {
                DataBase.getInstance().getPatientList().get(i).setId(i + 1);
            }

            patientList.getItems().setAll(DataBase.getInstance().getPatientList());
        }
    }

    public void removeSecretary(ActionEvent actionEvent) {
        Secretary secretary = secretaryList.getSelectionModel().getSelectedItem();

        if (secretary != null) {
            DataBase.getInstance().getSecretaryList().remove(secretary);

            for (int i = 0; i < DataBase.getInstance().getSecretaryList().size(); i++) {
                DataBase.getInstance().getSecretaryList().get(i).setId(i + 1);
            }

            secretaryList.getItems().setAll(DataBase.getInstance().getSecretaryList());
        }
    }

    public void removeDoctor(ActionEvent actionEvent) {
        Doctor doctor = doctorList.getSelectionModel().getSelectedItem();

        if (doctor != null) {
            DataBase.getInstance().getDoctorList().remove(doctor);

            for (int i = 0; i < DataBase.getInstance().getDoctorList().size(); i++) {
                DataBase.getInstance().getDoctorList().get(i).setId(i + 1);
            }

            doctorList.getItems().setAll(DataBase.getInstance().getDoctorList());
        }
    }

    public void removeAdmin(ActionEvent actionEvent) throws IOException {
        Admin admin = adminList.getSelectionModel().getSelectedItem();

        if (admin != null) {
            if (LoggedUser.getInstance().getAdmin().equals(admin)) logout(actionEvent);

            DataBase.getInstance().getAdminList().remove(admin);
            for (int i = 0; i < DataBase.getInstance().getAdminList().size(); i++) {
                DataBase.getInstance().getAdminList().get(i).setId(i + 1);
            }
            adminList.getItems().setAll(DataBase.getInstance().getAdminList());
        }
    }

    public void adminHomeView(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/template/adminHome.fxml"));
        Scene scene = new Scene(parent);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    public void logout(ActionEvent actionEvent) throws IOException {
        LoggedUser.getInstance().logout();
        Parent parent = FXMLLoader.load(getClass().getResource("/template/login.fxml"));
        Scene scene = new Scene(parent);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
