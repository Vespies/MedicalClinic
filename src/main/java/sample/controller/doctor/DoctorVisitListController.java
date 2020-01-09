package sample.controller.doctor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import sample.model.Doctor;
import sample.model.Visit;
import sample.service.LoggedUser;
import sample.service.VisitService;

import java.io.IOException;

public class DoctorVisitListController {

    @FXML
    public ListView<Visit> visitList;
    private VisitService visitService = new VisitService();
    private Doctor doctor = LoggedUser.getInstance().getDoctor();

    public void initialize() {
        visitList.getItems().setAll(visitService.doctorVisitList(doctor.getId()));
    }


    // accepting notes po when clicking on the button
    public void changeVisitStatus(ActionEvent actionEvent) {
        Visit visit = visitList.getSelectionModel().getSelectedItem();

        if (visitService.changeVisitStatus(visit))
            visitList.getItems().setAll(visitService.doctorVisitList(doctor.getId()));
    }

    public void patientHomeView(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/template/doctorHome.fxml"));
        Scene scene = new Scene(parent);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
