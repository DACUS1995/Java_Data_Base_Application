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

        // Create the dialog Stage.
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Splah");
        dialogStage.initModality(Modality.NONE);

        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        Splash controller = loader.getController();
        controller.setDialogStage(dialogStage);

        dialogStage.showAndWait();

        /**
         *Splash Screen ending
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
