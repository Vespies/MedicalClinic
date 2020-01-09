package sample.controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.service.AdminService;

import java.io.IOException;

// communication with adminAddUser.fxml
public class AdminAddUserController {

    @FXML
    public TextField firstNameField, lastNameField, idNumberField, passwordField, addressField, ageField;

    @FXML
    public ChoiceBox<String> choiceBoxSex, choiceBoxRole;

    private AdminService adminService = new AdminService();

    public void initialize() {
        choiceBoxSex.getItems().add("Man");
        choiceBoxSex.getItems().add("Woman");
        choiceBoxSex.getSelectionModel().selectFirst();

        choiceBoxRole.getItems().add("Patient");
        choiceBoxRole.getItems().add("Secretary");
        choiceBoxRole.getItems().add("Doctor");
        choiceBoxRole.getItems().add("Admin");
        choiceBoxRole.getSelectionModel().selectFirst();
    }

    public boolean addUser(ActionEvent actionEvent) {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String idNumber = idNumberField.getText();
        String password = passwordField.getText();
        String address = addressField.getText();
        int age = Integer.parseInt(ageField.getText());
        String sex = choiceBoxSex.getValue();
        String role = choiceBoxRole.getValue();


        // adding new user using the data
        return adminService.addUser(firstName, lastName, idNumber, password, address, age, sex, role);
    }

    // changing view to adminHome.fxml upon clicking on the button
    public void adminHomeView(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/template/adminHome.fxml"));
        Scene scene = new Scene(parent);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
