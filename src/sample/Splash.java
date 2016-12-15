package sample;/**
 * Created by DACUS on 01-Dec-16.
 */

import DBRelated.Connect;
import javafx.animation.PauseTransition;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.sql.*;

public class Splash {

    private Stage dialogStage;
    Image img = new Image("LOADING.jpg");

    @FXML
    ImageView imageView = new ImageView(img);

    //This method is automatically called after the fxml file has been loaded.
    @FXML
    private void initialize() throws InterruptedException {
        PauseTransition delay = new PauseTransition(Duration.seconds(3));
        delay.setOnFinished( event -> dialogStage.close() );
        delay.play();
    }

    // Sets the stage of this dialog
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
        dialogStage.initStyle(StageStyle.UNDECORATED);
    }

}
