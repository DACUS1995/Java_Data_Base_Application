package sample;

import DBRelated.SelectAngajati;
import Drawer.AlertBox;
import Model.Angajati;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.xml.soap.Text;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    @FXML
    private TableView<Angajati> angajatiTable;
    // @FXML
    // private TableColumn<Angajati, Integer> UserId;
    @FXML
    private TableColumn<Angajati, String> fName;
    @FXML
    private TableColumn<Angajati, String> lName;
    @FXML
    private TextField fNameLabel;
    @FXML
    private TextField lNameLabel;
    @FXML
    private TextField DataAngajare;
    @FXML
    private TextField Sex;
    @FXML
    private TextField Telefon;
    @FXML
    private TextField Email;
    @FXML
    private TextField DataNastere;
    @FXML
    private TextField Salariu;
    @FXML
    private TextField Specializare;
    @FXML
    private TextField idEchipa;
    @FXML
    private TextField searchField;


    //create table data
    final ObservableList<Angajati> data = SelectAngajati.getDataFromDB(); //get loaded array of Angajati

    //Connects the FXML data type from tabel with the one from Angajati class
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fName.setCellValueFactory(new PropertyValueFactory<Angajati, String>("fName"));
        lName.setCellValueFactory(new PropertyValueFactory<Angajati, String>("lName"));

        angajatiTable.setItems(data); //populate the table from data array

        //Clear Angajat Details
        showPersonDetails(null);

        // Listen for selection changes and show the person details when changed.
        angajatiTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPersonDetails(newValue));


    }


    /**
     * Fills all text fields to show details about the person.
     * If the specified person is null, all text fields are cleared.
     *
     * @param angajat the person or null
     */
    private void showPersonDetails(Angajati angajat) {
        if (angajat != null) {

            // Fill the labels with info from the person object.
            fNameLabel.setText(angajat.getfName());
            lNameLabel.setText(angajat.getlName());
            DataAngajare.setText(angajat.getDataAngajare().toPattern());
            Sex.setText(angajat.getSex());
            Telefon.setText(angajat.getTel());
            Email.setText(angajat.getEmail());
            DataNastere.setText(angajat.getDataNastere().toPattern());
            Salariu.setText(angajat.getSalariu());
            idEchipa.setText(String.valueOf(angajat.getIdEchipa()));
            Specializare.setText(angajat.getSpecializare());
        } else {
            // Person is null, remove all the text.
            fNameLabel.setText("");
            lNameLabel.setText("");
            DataAngajare.setText("");
            Sex.setText("");
            Telefon.setText("");
            Email.setText("");
            DataNastere.setText("");
            Salariu.setText("");
            idEchipa.setText("");
            Specializare.setText("");
        }
    }

    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new person.
     */
    @FXML
    private void handleNewAngajat() {
        Angajati tempAngajat = new Angajati();
        boolean okClicked = this.showAngajatEditDialog(tempAngajat);
        if (okClicked) {
            this.data.add(tempAngajat);
        }
    }

    /**
     * Opens a dialog to edit details for the specified person. If the user
     * clicks OK, the changes are saved into the provided person object and true
     * is returned.
     *
     * @param angajat the person object to be edited
     * @return true if the user clicked OK, false otherwise.
     */
    public boolean showAngajatEditDialog(Angajati angajat) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("AngajatiEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Angajat");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(Main.getPrimaryStage());
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            AngajatiEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setAngajat(angajat);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Handle for the Delete Button
     */
    @FXML
    public void handleDeleteAngajat() {
        int selectedIndex = angajatiTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Angajati selAngajat = angajatiTable.getItems().get(selectedIndex);


            SelectAngajati.deleteAngajat(selAngajat);
        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(Main.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Angajat Selected");
            alert.setContentText("Please select an Angajat in the table.");

            alert.showAndWait();
        }
        angajatiTable.getItems().remove(selectedIndex);
    }

    /**
    * Search button for first name
     * */
    //TODO Create complex search direct from DataBase with TabelView display of the results
    public void searchButoonClicked() {
        if (searchField.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(Main.getPrimaryStage());
            alert.setTitle("Missing Parameter");
            alert.setHeaderText("Missing search parameter");
            alert.setContentText("Please insert searching term");

            alert.showAndWait();
        } else
            for (int i = 0; i < data.size(); i++)
                if (data.get(i).getfName().equals(searchField.getText())) {
                    angajatiTable.getSelectionModel().select(i);
                    System.out.println(data.get(i).getfName());
                }



    }
}
