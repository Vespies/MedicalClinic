package sample.controller.secretary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.db.DataBase;
import sample.model.Drug;

import java.io.IOException;

public class SecretaryAddDrugController {

    @FXML
    public ListView<Drug> drugList;

    @FXML
    public TextField drugQuantity;

    public void initialize() {
        drugList.getItems().setAll(DataBase.getInstance().getDrugList());
    }

    public void addDrug(ActionEvent actionEvent) {
        Drug drug = drugList.getSelectionModel().getSelectedItem();
        int quantity = Integer.parseInt(drugQuantity.getText());

        if (drug != null && quantity > 0){
            int tmp = drug.getQuantity();
            tmp += quantity;
            drug.setQuantity(tmp);
            drugList.getItems().setAll(DataBase.getInstance().getDrugList());
        }
    }

    public void secretaryHomeView(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/template/secretaryHome.fxml"));
        Scene scene = new Scene(parent);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
