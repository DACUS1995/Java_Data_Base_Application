package DBRelated;

import Model.Angajati;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;


public class SelectAngajati {

    private static Connection con = null;
    private static ObservableList<Angajati> data = FXCollections.observableArrayList();


    //Get info from DB and return data to Connect
    public static ObservableList<Angajati> getDataFromDB() {

        con = Connect.getConnection();
        String queryString = "SELECT * FROM Angajati";
        Statement statement = null;

        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(queryString);
            ResultSetMetaData rsmd = rs.getMetaData();

            int numberColumns = rsmd.getColumnCount();
            while (rs.next()) {
                data.add(new Angajati(rs.getString(3), rs.getString(2), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }

    /**
     * Method for deleting an existing Angajat from DataBase by phonenumber
     **/
    public static void deleteAngajat(Angajati angajat) {
        con = Connect.getConnection();
        String queryString = "DELETE FROM Angajati WHERE " +
                "Nume='" + angajat.getfName() + "' AND Telefon='" +
                angajat.getTel() + "';" ;

        Statement statement = null;
        try {
            System.out.println(queryString);
            statement = con.createStatement();
            boolean res = statement.execute(queryString);

        } catch (
                SQLException e
                )

        {
            e.printStackTrace();
        }
    }


    /**
     * Method for inserting a new Angajat into the DataBase
     */
    public static void InsertAngajat(Angajati angajat) {
        con = Connect.getConnection();
        String queryString = "INSERT INTO Angajati" +
                " VALUES('" +
                angajat.getlName() + "','" +
                angajat.getfName() + "','" +
                angajat.getDataAngajare().toPattern() + "','" +
                angajat.getSex() + "','" +
                angajat.getTel() + "','" +
                angajat.getEmail() + "','" +
                angajat.getDataNastere().toPattern() + "','" +
                angajat.getSalariu() + "'," +
                angajat.getIdEchipa() + ",'" +
                angajat.getSpecializare() + "');";
        Statement statement = null;

        try {
            System.out.println(queryString);
            statement = con.createStatement();
            boolean res = statement.execute(queryString);
            //ResultSet rs = statement.executeQuery(queryString);
            // ResultSetMetaData rsmd = rs.getMetaData();
            //System.out.println(rs.next());

        } catch (
                SQLException e
                )

        {
            e.printStackTrace();
        }

    }

    //Pre-Loaded information for testing purpose
    public static ObservableList<Angajati> getPreLoadedAngajati() {

        //create table data  TODO Implement get of data from DB
        data.add(new Angajati("Nume_1", "Nume_2"));
        data.add(new Angajati("Nume_1", "Nume_2"));
        data.add(new Angajati("Nume_1", "Nume_2"));
        return data;

    }

}
