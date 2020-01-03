package sample.controller.secretary;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import sample.model.Doctor;
import sample.model.Patient;
import sample.model.Visit;
import sample.service.DoctorService;
import sample.service.PatientService;
import sample.service.VisitService;

import java.io.IOException;

public class SecretaryVisitListController {

    @FXML
    public ListView<Visit> visitList;

    @FXML
    public Label patientFirstName, patientLastName, doctorFirstName, doctorLastName;

    public void initialize() {
        VisitService visitService = new VisitService();
        PatientService patientService = new PatientService();
        DoctorService doctorService = new DoctorService();

        visitList.getItems().setAll(visitService.secretaryVisitList());

        visitList.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                Visit visit = visitList.getSelectionModel().getSelectedItem();
                Patient patient = patientService.findById(visit.getPatientId());
                Doctor doctor = doctorService.findById(visit.getDoctorId());

                if (patient != null && doctor != null) {
                    patientFirstName.setText(patient.getFirstName());
                    patientLastName.setText(patient.getLastName());

                    doctorFirstName.setText(doctor.getFirstName());
                    doctorLastName.setText(doctor.getLastName());
                }
            }
        });
    }

    public void secretaryHome(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/template/secretaryHome.fxml"));
        Scene scene = new Scene(parent);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
