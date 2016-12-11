package DBRelated;

import Model.Angajati;
import Model.Clienti;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

/**
 * Created by DACUS on 10-Dec-16.
 */
public class SelectClienti {

    private static Connection con = null;
    private static ObservableList<Clienti> data = FXCollections.observableArrayList();


    //Get info from DB and return data to Connect
    public static ObservableList<Clienti> getDataFromDB() {

        con = Connect.getConnection();
        String queryString = "SELECT * FROM Clienti";
        Statement statement = null;

        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(queryString);
            ResultSetMetaData rsmd = rs.getMetaData();

            int numberColumns = rsmd.getColumnCount();
            while (rs.next()) {
                data.add(new Clienti(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
            }
        } catch (SQLException e) {
            System.out.println("fuck me");
            e.printStackTrace();
        }

        return data;
    }



    /**
     * Method for deleting an existing Client from DataBase by IDClient
     * called by Tab2Controller
     **/
    public static void deleteClient(Clienti client) {
        con = Connect.getConnection();
        CallableStatement call = null;
        try {
            call = con.prepareCall("{call Delete_Client(?)}");
            call.setString(1,String.valueOf(client.getIdClient()));

            boolean res = call.execute();
            System.out.println(call.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * Method for inserting a new Client into the DataBase
     */
    public static void insertClienti(Clienti client) {
        con = Connect.getConnection();
        CallableStatement call = null;
        try {
            call = con.prepareCall("{call Insert_Clienti(?,?,?,?,?)}");
            call.setString(1,client.getlName());
            call.setString(2,client.getfName());
            call.setString(3, client.getDataIntregistrare().toPattern());
            call.setString(4, client.getTel());
            call.setString(5, client.getMail());

            boolean res = call.execute();
            System.out.println(call.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    /**
     * Method for updating an existing Client from DataBase
     * called from ClientEditDialogController
     * */
    public static void updateClient(Clienti client){
        con = Connect.getConnection();
        CallableStatement call = null;
        try {
            call = con.prepareCall("{call Update_Clienti(?,?,?,?,?,?)}");
            call.setString(1,String.valueOf(client.getIdClient()));
            call.setString(2,client.getlName());
            call.setString(3,client.getfName());
            call.setString(4, client.getDataIntregistrare().toPattern());
            call.setString(5, client.getTel());
            call.setString(6, client.getMail());

            boolean res = call.execute();
            System.out.println(call.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    //Pre-Loaded information for testing purpose
    public static ObservableList<Clienti> getPreLoadedAngajati() {

        //create table data  TODO Implement get of data from DB
        data.add(new Clienti("Nume_1", "Nume_2"));
        data.add(new Clienti("Nume_1", "Nume_2"));
        data.add(new Clienti("Nume_1", "Nume_2"));
        return data;

    }


}
