package sample;

import DBRelated.Connect;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.Connection;

public class Main extends Application {

    protected static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("My BD Window");
        primaryStage.setScene(new Scene(root, 800, 500));
        this.primaryStage = primaryStage;

        /**
        *Splash Screen loading
         */
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("Splash.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Create the SplashCreen Stage.
        Stage splashStage = new Stage();
        splashStage.setTitle("Splash");
        splashStage.initModality(Modality.NONE);

        Scene scene = new Scene(page);
        splashStage.setScene(scene);

        Splash controller = loader.getController();
        controller.setDialogStage(splashStage);

        splashStage.showAndWait();

        /**
         *Splash Screen ending
         */


        /**
         *Logging Screen
         */
        FXMLLoader loader_1 = new FXMLLoader();
        loader_1.setLocation(Main.class.getResource("LoggingScreen.fxml"));
        AnchorPane page_1 = (AnchorPane) loader_1.load();

        // Create the SplashCreen Stage.
        Stage loggingStage = new Stage();
        loggingStage.setTitle("Sign In");
        loggingStage.initModality(Modality.NONE);

        Scene scene_1 = new Scene(page_1);
        loggingStage.setScene(scene_1);

        LoggingScreen controller_1 = loader_1.getController();
        controller_1.setDialogStage(loggingStage);

        loggingStage.showAndWait();

        /**
         *Logging Screen ending
         */



        primaryStage.show();

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
