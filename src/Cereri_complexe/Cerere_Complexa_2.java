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

public class Cerere_Complexa_2 {

    @FXML
    private TableView<String[]> Table;
    @FXML
    private TableColumn<String[], String> indicatorEchipa;
    @FXML
    private TableColumn<String[], String> nume;
    @FXML
    private TableColumn<String[], String> prenume;
    @FXML
    private TableColumn<String[], String> salariu;
    @FXML
    private TableColumn<String[], String> telefon;
    @FXML
    private TableColumn<String[], String> bonus;

    private static Connection con = null;
    private Stage dialogStage;
    private boolean okClicked = false;
    final ObservableList<String[]> data = FXCollections.observableArrayList();

    //This method is automatically called after the fxml file has been loaded.
    @FXML
    private void initialize() {

        indicatorEchipa.setCellValueFactory((p)->{
            String[] x = p.getValue();
            return new SimpleStringProperty(x != null && x.length>0 ? x[0] : "<no name>");
        });
        salariu.setCellValueFactory((p)->{
            String[] x = p.getValue();
            return new SimpleStringProperty(x != null && x.length>0 ? x[3] : "<no name>");
        });
        nume.setCellValueFactory((p)->{
            String[] x = p.getValue();
            return new SimpleStringProperty(x != null && x.length>0 ? x[1] : "<no name>");
        });

        prenume.setCellValueFactory((p) -> {
            String[] x = p.getValue();
            return new SimpleStringProperty(x != null && x.length > 0 ? x[2] : "<no name>");
        });

        telefon.setCellValueFactory((p) -> {
            String[] x = p.getValue();
            return new SimpleStringProperty(x != null && x.length > 0 ? x[4] : "<no name>");
        });

        bonus.setCellValueFactory((p) -> {
            String[] x = p.getValue();
            return new SimpleStringProperty(x != null && x.length > 0 ? x[5] : "<no name>");
        });

        con = Connect.getConnection();
        CallableStatement call = null;
        try {
            call = con.prepareCall("{call Cerere_Simpla_2()}");
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

}
