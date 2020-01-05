package sample.controller.doctor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.db.DataBase;
import sample.model.Doctor;
import sample.model.Drug;
import sample.model.Patient;
import sample.model.Prescription;
import sample.service.LoggedUser;
import sample.service.PrescriptionService;

import java.io.IOException;

public class DoctorAddPrescriptionController {

    @FXML
    public ListView<Patient> patientList;

    @FXML
    public ListView<Drug> drugList;

    @FXML
    public TextField quantityField;

    @FXML
    public TextArea dosageField;


    private PrescriptionService prescriptionService = new PrescriptionService();


    public void initialize() {
        patientList.getItems().setAll(DataBase.getInstance().getPatientList());
        drugList.getItems().setAll(DataBase.getInstance().getDrugList());
    }

    public void addPrescription(ActionEvent actionEvent) {
        Patient patient = patientList.getSelectionModel().getSelectedItem();
        Drug drug = drugList.getSelectionModel().getSelectedItem();
        Doctor doctor = LoggedUser.getInstance().getDoctor();
        int quantity = Integer.parseInt(quantityField.getText());
        String dosage = dosageField.getText();

        if (patient != null && drug != null && doctor != null) {
            Prescription prescription = new Prescription(prescriptionService.generatePrescriptionId(), drug.getName(), quantity, dosage, patient.getId(), doctor.getId());
            DataBase.getInstance().getPrescriptionList().add(prescription);
        }
    }

    public void doctorHomeView(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/template/doctorHome.fxml"));
        Scene scene = new Scene(parent);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
