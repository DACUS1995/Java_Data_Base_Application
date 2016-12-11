package sample;/**
 * Created by DACUS on 01-Dec-16.
 */

import Model.Angajati;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Tab3Controller {

    @FXML
    private void initialize() {
    }



    public void OnCLick_1() {
        try {
        // Load the fxml file and create a new stage for the popup dialog.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("Cerere_Simpla_1.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Create the dialog Stage.
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Cerere_1");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(Main.getPrimaryStage());
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Set the person into the controller.
        Cerere_Simpla_1 controller = loader.getController();
        controller.setDialogStage(dialogStage);

        dialogStage.showAndWait();

        return ;
    } catch (IOException e) {
        e.printStackTrace();
        return ;
    }

    }

}
