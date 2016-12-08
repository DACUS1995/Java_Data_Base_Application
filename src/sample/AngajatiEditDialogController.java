package sample;/**
 * Created by DACUS on 01-Dec-16.
 */

import DBRelated.SelectAngajati;
import Model.Angajati;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AngajatiEditDialogController {

    @FXML
    private TextField fNameField;
    @FXML
    private TextField lNameField;
    @FXML
    private TextField dataAngajareField;
    @FXML
    private TextField sexField;
    @FXML
    private TextField telefonField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField dataNastereField;
    @FXML
    private TextField salariuField;
    @FXML
    private TextField idEchipaField;
    @FXML
    private TextField specializareField;


    private Stage dialogStage;
    private Angajati angajat;
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

    public void setAngajat(Angajati angajat) {
        this.angajat = angajat;
        if (angajat.getfName() != null) updateFlag = true;
        fNameField.setText(angajat.getfName());
        lNameField.setText(angajat.getlName());
        dataAngajareField.setText(angajat.getDataAngajare().toPattern());
        sexField.setText(angajat.getSex());
        telefonField.setText(angajat.getTel());
        emailField.setText(angajat.getEmail());
        dataNastereField.setText(angajat.getDataNastere().toPattern());
        salariuField.setText(angajat.getSalariu());
        specializareField.setText(angajat.getSpecializare());
        idEchipaField.setText(String.valueOf(angajat.getIdEchipa()));
    }


    //Returns true if the user clicked OK, false otherwise.
    public boolean isOkClicked() {
        return okClicked;
    }


    //Called when the user clicks ok.

    @FXML
    private void handleOk() {
        if (isInputValid()) {
            angajat.setfName(fNameField.getText());
            angajat.setlName(lNameField.getText());
            angajat.setDataAngajare(dataAngajareField.getText());
            angajat.setSex(sexField.getText());
            angajat.setTel(telefonField.getText());
            angajat.setEmail(emailField.getText());
            angajat.setDataNastere(dataNastereField.getText());
            angajat.setSalariu(salariuField.getText());
            angajat.setIdEchipa(Integer.parseInt(idEchipaField.getText()));
            angajat.setSpecializare(specializareField.getText());
            if (updateFlag == false)
                SelectAngajati.InsertAngajat(angajat);
            else SelectAngajati.updateAngajat(angajat);
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
        if (dataAngajareField.getText() == null || dataAngajareField.getText().length() == 0) {
            errorMessage += "No valid Data Angajare!\n";
        }
        if (sexField.getText() == null || sexField.getText().length() == 0) {
            errorMessage += "No valid sex!\n";
        }
        if (telefonField.getText() == null || telefonField.getText().length() == 0) {
            errorMessage += "No valid telefon!\n";
        }
        if (emailField.getText() == null || emailField.getText().length() == 0) {
            errorMessage += "No valid Email!\n";
        }
        if (dataNastereField.getText() == null || dataNastereField.getText().length() == 0) {
            errorMessage += "No valid last Data Nastere!\n";
        }
        if (salariuField.getText() == null || salariuField.getText().length() == 0) {
            errorMessage += "No valid Salariu!\n";
        }
        if (specializareField.getText() == null || specializareField.getText().length() == 0) {
            errorMessage += "No valid Specializare!\n";
        }
        if (Integer.parseInt(idEchipaField.getText()) == 0 || idEchipaField.getText().length() == 0) {
            errorMessage += "No valid Echipa!\n";
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
