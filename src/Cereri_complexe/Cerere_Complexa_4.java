package Cereri_complexe;/**
 * Created by DACUS on 01-Dec-16.
 */

import DBRelated.Connect;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.sql.*;

public class Cerere_Complexa_4 {

    @FXML
    private TableView<String[]> Table;
    @FXML
    private TableColumn<String[], String> adresa;
    @FXML
    private TableColumn<String[], String> pachetul;
    @FXML
    private TableColumn<String[], String> numarZile;
    @FXML
    private TableColumn<String[], String> nume;
    @FXML
    private TableColumn<String[], String> prenume;
    @FXML
    private TableColumn<String[], String> telefonul;

    private static int numD;
    private static int telN;
    private static Connection con = null;
    private Stage dialogStage;
    private boolean okClicked = false;
    final ObservableList<String[]> data = FXCollections.observableArrayList();

    //This method is automatically called after the fxml file has been loaded.
    @FXML
    private void initialize() {

        adresa.setCellValueFactory((p) -> {
            String[] x = p.getValue();
            return new SimpleStringProperty(x != null && x.length > 0 ? x[0] : "<no name>");
        });

        pachetul.setCellValueFactory((p) -> {
            String[] x = p.getValue();
            return new SimpleStringProperty(x != null && x.length > 0 ? x[1] : "<no name>");
        });

        numarZile.setCellValueFactory((p) -> {
            String[] x = p.getValue();
            return new SimpleStringProperty(x != null && x.length > 0 ? x[2] : "<no name>");
        });

        nume.setCellValueFactory((p) -> {
            String[] x = p.getValue();
            return new SimpleStringProperty(x != null && x.length > 0 ? x[3] : "<no name>");
        });

        prenume.setCellValueFactory((p) -> {
            String[] x = p.getValue();
            return new SimpleStringProperty(x != null && x.length > 0 ? x[4] : "<no name>");
        });

        telefonul.setCellValueFactory((p) -> {
            String[] x = p.getValue();
            return new SimpleStringProperty(x != null && x.length > 0 ? x[5] : "<no name>");
        });

        con = Connect.getConnection();
        CallableStatement call = null;
        try {
            call = con.prepareCall("{call Cerere_Complexa_4(?,?)}");
            call.setString(1, String.valueOf(numD));
            call.setString(2, String.valueOf(telN));
            ResultSet rs = call.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()) {
                String[] res = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)};
                data.add(res);
            }
            System.out.println(call.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }


        Table.setItems(data); //populate the table from data array

    }

    // Sets the stage of this dialog
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }


    //Returns true if the user clicked OK, false otherwise.
    public boolean isOkClicked() {
        return okClicked;
    }


    //Called when the user clicks ok.

    @FXML
    private void handleOk() {
        okClicked = true;
        dialogStage.close();
    }

    //Called when the user clicks cancel.
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    //Set local Querry paramater
    public static void setPara1(int numD){
        Cerere_Complexa_4.numD = numD;
    }

    //Set local Querry paramater
    public static void setPara2(int telN){
        Cerere_Complexa_4.telN = telN;
    }



}
