package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.db.DataBase;
import sample.service.InitDataLoader;

import java.io.IOException;

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
    public void init() throws IOException {
//        initDataLoader.initializeDataBase();
        DataBase.getInstance().loadDateFromFile();
    }

    @Override
    public void stop() throws IOException {
        DataBase.getInstance().saveDataToFile();
    }
}
