package sample;/**
 * Created by DACUS on 01-Dec-16.
 */

import DBRelated.Connect;
import DBRelated.SelectAngajati;
import Model.Angajati;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoggingScreen {

    @FXML
    private TextField userField;
    @FXML
    private TextField passwordField;



    private Stage dialogStage;
    private boolean okClicked = false;



    //This method is automatically called after the fxml file has been loaded.
    @FXML
    private void initialize() {
    }

    // Sets the stage of this dialog
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
        dialogStage.initStyle(StageStyle.UNDECORATED);
    }


    //Returns true if the user clicked OK, false otherwise.
    public boolean isOkClicked() {
        return okClicked;
    }


    //Called when the user clicks ok.

    @FXML
    private void handleOk() {
        if (isInputValid()) {

            okClicked = true;
            dialogStage.close();
        }
    }

    //Called when the user clicks cancel.
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }


    /**
     * Validates the user input in the text fields.
     *
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if(!userField.getText().equals(Connect.getID())) {
            errorMessage += "No valid UserID!\n";
            System.out.println(Connect.getID());
        }
        if(!passwordField.getText().equals( Connect.getPass()))
            errorMessage += "No valid Password!\n";

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

}
