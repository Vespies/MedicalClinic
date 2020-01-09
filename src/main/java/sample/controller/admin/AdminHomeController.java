package sample.controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.service.LoggedUser;

import java.io.IOException;

// communication with adminHome.fxml
public class AdminHomeController {

    // changing view to adminAddUser.fxml upon clikcing on the button

    public void addUserView(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/template/adminAddUser.fxml"));
        Scene scene = new Scene(parent);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    // changing view to adminRemoveUser.fxml upon clicking on the button

    public void removeUserView(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/template/adminRemoveUser.fxml"));
        Scene scene = new Scene(parent);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    // changing view to login.fxml upon clicking on the button

    public void logout(ActionEvent actionEvent) throws IOException {
        LoggedUser.getInstance().logout();
        Parent parent = FXMLLoader.load(getClass().getResource("/template/login.fxml"));
        Scene scene = new Scene(parent);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
