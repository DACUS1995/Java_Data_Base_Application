package sample;/**
 * Created by DACUS on 01-Dec-16.
 */

import DBRelated.SelectAngajati;
import DBRelated.SelectClienti;
import Model.Angajati;
import Model.Clienti;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Tab2Controller {

    @FXML
    private TableView<Clienti> clientiTable;
    @FXML
    private TableColumn<Clienti, String> fName;
    @FXML
    private TableColumn<Clienti, String> lName;
    @FXML
    private TextField telLabel;
    @FXML
    private TextField mailLabel;
    @FXML
    private TextField dataInregistrareLabel;
    @FXML
    private TextField fNameLabel;
    @FXML
    private TextField lNameLabel;
    @FXML
    private TextField searchField;
    @FXML
    private ChoiceBox choiceBox;

    //create table data
    final ObservableList<Clienti> data = SelectClienti.getDataFromDB(); //get loaded array of Clienti
    final ObservableList<String> searchParam = FXCollections.observableArrayList("Nume", "Prenume");

    @FXML
    public void initialize() {
        //linking tabel columns with items from data
        fName.setCellValueFactory(new PropertyValueFactory<>("fName"));
        lName.setCellValueFactory(new PropertyValueFactory<>("lName"));
        choiceBox.setItems(searchParam);
        choiceBox.getSelectionModel().select(1);

        clientiTable.setItems(data); //populate the table from data array

        //Clear Clienti Details
        showPersonDetails(null);

        // Listen for selection changes and show the person details when changed.
        clientiTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPersonDetails(newValue));


    }

    /**
     * Fills all text fields to show details about the person.
     * If the specified person is null, all text fields are cleared.
     *
     * @param client the person or null
     */
    private void showPersonDetails(Clienti client) {
        if (client != null) {

            // Fill the labels with info from the person object.
            fNameLabel.setText(client.getfName());
            lNameLabel.setText(client.getlName());
            telLabel.setText(String.valueOf(client.getTel()));
            mailLabel.setText(client.getMail());
            dataInregistrareLabel.setText(client.getDataIntregistrare().toPattern());

        } else {
            // Person is null, remove all the text.
            fNameLabel.setText("");
            lNameLabel.setText("");
            telLabel.setText("");
            mailLabel.setText("");
            dataInregistrareLabel.setText("");
        }
    }

    /**
     * Opens a dialog to edit details for the specified person. If the user
     * clicks OK, the changes are saved into the provided person object and true
     * is returned.
     *
     * @param client the person object to be edited
     * @return true if the user clicked OK, false otherwise.
     */
    public boolean showClientEditDialog(Clienti client) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("ClientEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Client");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(Main.getPrimaryStage());
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            ClientEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setClient(client);

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
    public void handleDeleteClient() {
        int selectedIndex = clientiTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Clienti selClient = clientiTable.getItems().get(selectedIndex);
            SelectClienti.deleteClient(selClient);
            clientiTable.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(Main.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Angajat Selected");
            alert.setContentText("Please select an Angajat in the table.");

            alert.showAndWait();
        }

    }

    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new person.
     */
    @FXML
    private void handleNewClient() {
        Clienti tempClient = new Clienti();
        boolean okClicked = this.showClientEditDialog(tempClient);
        if (okClicked) {
            this.data.add(tempClient);
        }
    }


    /**
     * Handle for the Update Button
     */
    @FXML
    public void handleUpdateClient() {
        Clienti client = clientiTable.getSelectionModel().getSelectedItem();
        if (client != null) {
            boolean okClicked = showClientEditDialog(client);
            SelectClienti.updateClient(client);
            if (okClicked) {
                showPersonDetails(client);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(Main.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }
    }

    /**
     * Search button for first name
     */

    public void searchButoonClicked() {
        if (searchField.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(Main.getPrimaryStage());
            alert.setTitle("Missing Parameter");
            alert.setHeaderText("Missing search parameter");
            alert.setContentText("Please insert searching term");

            alert.showAndWait();
        } else {
            int selection = choiceBox.getSelectionModel().getSelectedIndex(); //pozitia din Choice Box pentru param. de cautare
            switch (selection) {
                case 1:
                    for (int i = 0; i < data.size(); i++)
                        if (data.get(i).getfName().equals(searchField.getText())) {
                            clientiTable.getSelectionModel().select(i);
                            System.out.println(data.get(i).getfName());
                            break;
                        }
                    break;

                case 0:
                    for (int i = 0; i < data.size(); i++)
                        if (data.get(i).getlName().equals(searchField.getText())) {
                            clientiTable.getSelectionModel().select(i);
                            System.out.println(data.get(i).getlName());
                            break;
                        }
                    break;
            }
        }


    }

    public void OnCLick() {
        System.out.println("Fuck Yeah");
    }

}
