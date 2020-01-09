package sample.controller.doctor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import sample.model.Doctor;
import sample.model.Visit;
import sample.service.LoggedUser;
import sample.service.NoteService;
import sample.service.VisitService;

import java.io.IOException;

public class DoctorAddNoteController {

    @FXML
    public ListView<Visit> visitList;

    @FXML
    public TextArea noteField;

    private Doctor doctor = LoggedUser.getInstance().getDoctor();
    private VisitService visitService = new VisitService();
    private NoteService noteService = new NoteService();

    public void initialize() {
        visitList.getItems().setAll(visitService.doctorVisitList(doctor.getId()));
    }

    // adding notes to a visit
    public void addNote(ActionEvent actionEvent) {
        Visit visit = visitList.getSelectionModel().getSelectedItem();
        String noteString = noteField.getText();

        noteService.addNote(visit, noteString);
    }

    public void doctorHomeView(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/template/doctorHome.fxml"));
        Scene scene = new Scene(parent);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
