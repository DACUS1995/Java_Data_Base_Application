package sample;/**
 * Created by DACUS on 01-Dec-16.
 */

import Cereri_complexe.Cerere_Complexa_1;
import Cereri_complexe.Cerere_Complexa_2;
import Cereri_complexe.Cerere_Complexa_3;
import Cereri_complexe.Cerere_Complexa_4;
import Cereri_simple.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Tab4Controller {

    @FXML
    private void initialize() {
    }

    @FXML
    private TextField topN;
    @FXML
    private TextField numD;
    @FXML
    private TextField telN;

//    Implementare Butoane pentru cererile simple

    public void OnCLick_1() {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("Cerere_Complexa_1.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Cerere_Complexa_1");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(Main.getPrimaryStage());
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            Cerere_Complexa_1 controller = loader.getController();
            controller.setDialogStage(dialogStage);

            dialogStage.showAndWait();

            return;
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

    }

    public void OnCLick_2() {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("Cerere_Complexa_2.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Cerere_Complexa_2");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(Main.getPrimaryStage());
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            Cerere_Complexa_2 controller = loader.getController();
            controller.setDialogStage(dialogStage);

            dialogStage.showAndWait();

            return;
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

    }

    public void OnCLick_3() {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();

            //set parameter before creating the tabel
            if (topN != null)
                Cerere_Complexa_3.setPara(Integer.parseInt(topN.getText()));
            else Cerere_Complexa_3.setPara(0);

            loader.setLocation(Main.class.getResource("Cerere_Complexa_3.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Cerere_Complexa_3");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(Main.getPrimaryStage());
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);


            // Set the person into the controller.
            Cerere_Complexa_3 controller = loader.getController();

            controller.setDialogStage(dialogStage);

            dialogStage.showAndWait();

            return;
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

    }

    public void OnCLick_4() {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();

            //set parameter before creating the tabel
            Cerere_Complexa_4.setPara1(Integer.parseInt(numD.getText()));
            Cerere_Complexa_4.setPara2(Integer.parseInt(telN.getText()));

            loader.setLocation(Main.class.getResource("Cerere_Complexa_4.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Cerere_Complexa_4");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(Main.getPrimaryStage());
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            Cerere_Complexa_4 controller = loader.getController();
            controller.setDialogStage(dialogStage);

            dialogStage.showAndWait();

            return;
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

    }


}
