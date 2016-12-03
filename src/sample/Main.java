package sample;

import DBRelated.Connect;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;

public class Main extends Application {

    protected static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("My BD Window");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();
        this.primaryStage = primaryStage;
    }


    public static void main(String[] args) {

        //Create DataBase connection
        Connection con = Connect.DbConnect();

        launch(args);
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }
}
