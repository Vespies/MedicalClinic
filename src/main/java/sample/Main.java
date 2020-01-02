package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.service.InitDataLoader;

public class Main extends Application {

    private InitDataLoader initDataLoader = new InitDataLoader();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/template/login.fxml"));
        primaryStage.setTitle("Medical Clinic");
        primaryStage.setScene(new Scene(root, 1000, 700));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() {
        initDataLoader.addPatient();
        initDataLoader.addDoctor();
        initDataLoader.addSecretary();
        initDataLoader.addAdmin();
        initDataLoader.addVisit();
        initDataLoader.addDrug();
        initDataLoader.addPrescription();
    }

    @Override
    public void stop() {

    }
}
