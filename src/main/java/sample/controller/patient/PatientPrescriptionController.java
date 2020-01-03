package sample.controller.patient;

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
import sample.model.Prescription;
import sample.service.DoctorService;
import sample.service.LoggedUser;
import sample.service.PatientService;
import sample.service.PrescriptionService;

import java.io.IOException;

public class PatientPrescriptionController {

    @FXML
    public ListView<Prescription> prescriptionList;

    @FXML
    public Label patientFirstName,
            patientAddress, patientSex, patientAge, doctorFirstName, doctorAddress, drugName, d, s;

    public void initialize() {
        PrescriptionService prescriptionService = new PrescriptionService();
        PatientService patientService = new PatientService();
        DoctorService doctorService = new DoctorService();

        Patient patient = LoggedUser.getInstance().getPatient();
        prescriptionList.getItems().setAll(prescriptionService.findByPatientId(patient.getId()));

        prescriptionList.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                Prescription prescription = prescriptionList.getSelectionModel().getSelectedItem();
                Patient patient = patientService.findById(prescription.getPatientId());
                Doctor doctor = doctorService.findById(prescription.getDoctorId());

                if (patient != null && doctor != null) {
                    patientFirstName.setText(patient.getFirstName());
                    patientAddress.setText(patient.getAddress());
                    patientSex.setText(patient.getSex());
                    patientAge.setText("" + patient.getAge());

                    doctorFirstName.setText(doctor.getFirstName());
                    doctorAddress.setText(doctor.getAddress());

                    drugName.setText(prescription.getDrugName());
                    d.setText("" + prescription.getQuantity());
                    s.setText(prescription.getDosage());
                }
            }
        });
    }


    public void patientHomeView(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/template/patientHome.fxml"));
        Scene scene = new Scene(parent);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
