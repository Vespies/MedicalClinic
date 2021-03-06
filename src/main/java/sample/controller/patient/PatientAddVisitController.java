package sample.controller.patient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import sample.db.DataBase;
import sample.model.Doctor;
import sample.model.Patient;
import sample.service.LoggedUser;
import sample.service.VisitService;

import java.io.IOException;
import java.time.LocalDate;

public class PatientAddVisitController {

    @FXML
    public DatePicker dataPicker;

    @FXML
    public ListView<Doctor> doctorList;

    private VisitService visitService;

    public void initialize() {
        visitService = new VisitService();
        doctorList.getItems().setAll(DataBase.getInstance().getDoctorList());
    }

    public void patientHome(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/template/patientHome.fxml"));
        Scene scene = new Scene(parent);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    // adding a visit
    public void addVisit(ActionEvent actionEvent) {
        LocalDate date = dataPicker.getValue();
        Doctor doctor = doctorList.getSelectionModel().getSelectedItem();
        Patient patient = LoggedUser.getInstance().getPatient();

        visitService.addVisit(date, doctor, patient);
    }
}
