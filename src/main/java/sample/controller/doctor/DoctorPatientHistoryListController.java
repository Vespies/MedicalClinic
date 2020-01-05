package sample.controller.doctor;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import sample.db.DataBase;
import sample.model.Note;
import sample.model.Patient;
import sample.model.Visit;
import sample.service.NoteService;
import sample.service.VisitService;

import java.io.IOException;

public class DoctorPatientHistoryListController {

    @FXML
    public ListView<Patient> patientList;

    @FXML
    public ListView<Visit> visitList;

    @FXML
    public TextArea noteField;

    private VisitService visitService = new VisitService();
    private NoteService noteService = new NoteService();

    public void initialize() {
        patientList.getItems().setAll(DataBase.getInstance().getPatientList());

        patientList.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                Patient patient = patientList.getSelectionModel().getSelectedItem();
                if (patient != null) {
                    visitList.getItems().setAll(visitService.patientVisitList(patient.getId()));
                    noteField.clear();
                }
            }
        });

        visitList.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                Visit visit = visitList.getSelectionModel().getSelectedItem();
                noteField.clear();
                if (visit != null) {
                    Note note = noteService.findById(visit.getNoteId());
                    if (note != null) noteField.setText(note.getNote());
                }
            }
        });
    }

    public void doctorHomeVie(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/template/doctorHome.fxml"));
        Scene scene = new Scene(parent);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
