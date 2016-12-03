package DBRelated;

import java.sql.*;

public class Connect {


    private static String URL = "jdbc:sqlserver://localhost:1433;DatabaseName=myBD";
    private static String userId = "sa";
    private static String password = "lollol00";
    private static Connection con = null;

    //DbConnect(URL, userId, password);

    public static Connection getConnection() {
        return con;
    }

    public static Connection DbConnect() {
       // Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(URL, userId, password);
            System.out.println("Connection Established! ");

//-----------------Realizarea Unei Interogari--------------
//			Statement statement = con.createStatement();
//			String queryString = "SELECT * FROM Angajati";
//			ResultSet rs = statement.executeQuery(queryString);
//			ResultSetMetaData rsmd = rs.getMetaData();
//
//			int numberColumns = rsmd.getColumnCount();
//
//
//            while (rs.next()) {
//				for (int i = 1; i <= numberColumns; i++)
//					System.out.print(rs.getString(i) + " ");
//				System.out.println();
//			}


        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}


/*


package tutorial14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SqlConnection {

    public static Connection DbConnector(){
        try{
            Connection conn = null;
            //https://bitbucket.org/xerial/sqlite-jdbc/downloads
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:UserDatabase.sqlite");
            return conn;
        }catch(ClassNotFoundException | SQLException e){
           System.out.println(e);
                }
        return null;
    }
}
*/
