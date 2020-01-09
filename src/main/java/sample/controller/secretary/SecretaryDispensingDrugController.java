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
import sample.service.DrugService;

import java.io.IOException;

public class SecretaryDispensingDrugController {

    @FXML
    public ListView<Drug> drugList;

    @FXML
    public TextField drugQuantity;

    private DrugService drugService = new DrugService();

    public void initialize() {
        drugList.getItems().setAll(DataBase.getInstance().getDrugList());
    }


    // giving out medicine
    public void dispenseDrug(ActionEvent actionEvent) {
        Drug drug = drugList.getSelectionModel().getSelectedItem();
        int quantity = Integer.parseInt(drugQuantity.getText());

        if (drugService.dispenseDrug(drug, quantity))
            drugList.getItems().setAll(DataBase.getInstance().getDrugList());
    }

    public void secretaryHomeView(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/template/secretaryHome.fxml"));
        Scene scene = new Scene(parent);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
