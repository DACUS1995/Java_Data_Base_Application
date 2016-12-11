package sample;/**
 * Created by DACUS on 01-Dec-16.
 */

import DBRelated.SelectAngajati;
import DBRelated.SelectClienti;
import Model.Angajati;
import Model.Clienti;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ClientEditDialogController {

    @FXML
    private TextField fNameField;
    @FXML
    private TextField lNameField;
    @FXML
    private TextField dataInregistrareField;
    @FXML
    private TextField telefonField;
    @FXML
    private TextField emailField;



    private Stage dialogStage;
    private Clienti client;
    private boolean okClicked = false;
    private boolean updateFlag = false; //if true use update else use insert


    //This method is automatically called after the fxml file has been loaded.
    @FXML
    private void initialize() {
    }

    // Sets the stage of this dialog
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    //Sets the person to be edited in the dialog.

    public void setClient(Clienti client) {
        this.client = client;
        if (client.getfName() != null) updateFlag = true;
        fNameField.setText(client.getfName());
        lNameField.setText(client.getlName());
        dataInregistrareField.setText(client.getDataIntregistrare().toPattern());
        telefonField.setText(client.getTel());
        emailField.setText(client.getMail());

    }


    //Returns true if the user clicked OK, false otherwise.
    public boolean isOkClicked() {
        return okClicked;
    }


    //Called when the user clicks ok.

    @FXML
    private void handleOk() {
        if (isInputValid()) {
            client.setfName(fNameField.getText());
            client.setlName(lNameField.getText());
            client.setDataIntregistrare(dataInregistrareField.getText());
            client.setTel(telefonField.getText());
            client.setMail(emailField.getText());

            if (updateFlag == false)
                SelectClienti.insertClienti(client);
            else SelectClienti.updateClient(client);
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

        if (fNameField.getText() == null || fNameField.getText().length() == 0) {
            errorMessage += "No valid first name!\n";
        }
        if (lNameField.getText() == null || lNameField.getText().length() == 0) {
            errorMessage += "No valid last name!\n";
        }
        if (dataInregistrareField.getText() == null || dataInregistrareField.getText().length() == 0) {
            errorMessage += "No valid Data Inregistrare!\n";
        }
        if (telefonField.getText() == null || telefonField.getText().length() == 0) {
            errorMessage += "No valid telefon!\n";
        }
        if (emailField.getText() == null || emailField.getText().length() == 0) {
            errorMessage += "No valid Email!\n";
        }



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
