package sample.controller.patient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import sample.model.Patient;
import sample.model.Visit;
import sample.service.LoggedUser;
import sample.service.VisitService;

import java.io.IOException;

public class PatientVisitHistoryController {

    @FXML
    private ListView<Visit> visitList;

    public void initialize() {
        VisitService visitService = new VisitService();

        Patient patient = LoggedUser.getInstance().getPatient();

        visitList.getItems().setAll(visitService.patientVisitList(patient.getId()));
    }

    public void patientHome(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/template/patientHome.fxml"));
        Scene scene = new Scene(parent);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
