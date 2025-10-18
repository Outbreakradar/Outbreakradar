
//
//<<<<<<< Updated upstream
//import com.formdev.flatlaf.FlatLightLaf;
//
//import javax.swing.*;
//
//public class Main {
//
//    public static OutbreakManager om = new OutbreakManager();
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(Main::run);
//
//    }
//
//    public static void run() {
//        // UIManager.put("ComboBox.selectionBackground", new ColorUIResource(Constants.BTNHOVERCLR));
//
//        FlatLightLaf.setup();
//        BaseScreen base = new BaseScreen();
//        try {
//            om.fetchOutbreakFromBackend();
//        }
//        catch(Exception e)
//        {
//            System.out.println("An error occured!");
//
//        }
//=======
//import java.sql.Statement;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.sql.ResultSet;
//
//public class Main
//{
//    public static void main(String[] args)
//    {
//        Connection conn= null;
//        try
//        {
//            conn = DriverManager.getConnection("jdbc:sqlite:Outbreakradar.db");
//            System.out.println("opened database connection");
//            try {
//                deleteTable(conn);
//            } catch (Exception ignored)
//            {
//
//            }
//
//            //sreegovind, the part from down here to the next comment is manual usage of the functions created
//            createTable(conn);
//            System.out.println(" ");
//            System.out.println("inserting data");
//            insertDisease(conn, "corona", "Nolan","5");
//            insertDisease(conn, "hitman", "black plague","6");
//            updateTable(conn,"cough and fever","hot water steaming","corona");
//            System.out.println(" ");
//            System.out.println("displaying database");
//            displaydatabase(conn, "disease");
//            //till here
//        }
//        catch(SQLException e)
//        {
//            e.printStackTrace();
//            System.out.println(e.getClass().getName()+": "+e.getMessage());
//
//        }
//        finally{
//            if(conn!=null) {
//                try {
//                    conn.close();
//                }
//                catch (SQLException e) {
//                    e.printStackTrace();
//                    System.out.println(e.getMessage());
//
//                }
//            }
//        }
//    }
//
//
//
//    private static void displaydatabase(Connection conn,String tableName)throws SQLException
//    {
//        String selectSQL="SELECT * from "+tableName;
//        Statement stmt = conn.createStatement();
//        ResultSet rs =stmt.executeQuery(selectSQL);
//        //the code below is to display in terminal,'rs' of Resultset contains the result
//        System.out.println("-------"+tableName+"-------");
//        while(rs.next()) {
//            System.out.println("disease_name: " + rs.getString("disease_name") + ",");
//            System.out.println("symptoms: "+rs.getString("symptoms") + ",");
//            System.out.println("treatments: "+rs.getString("treatments")+"\n");
//        }
//        System.out.println("------------------------------");
//
//    }
//
//    //insering data into table
//    private static void insertDisease(Connection conn, String disease_name,String symptoms, String treatments)throws SQLException
//    {
//        String insertSQL ="INSERT INTO disease(disease_name,symptoms,treatments)VALUES(?,?,?)";
//        PreparedStatement pstmt =conn.prepareStatement(insertSQL);
//        pstmt.setString(1,disease_name);
//        pstmt.setString(2,symptoms);
//        pstmt.setString(3,treatments);
//        pstmt.executeUpdate();
//
//
//    }
//
//    // creating table
//    private static void createTable(Connection conn)throws SQLException
//    {
//        String createTablesql=" "+
//                "create table disease("+
//                "disease_name varchar(50),"+
//                "symptoms varchar(50),"+
//                "treatments varchar(5)"
//                +")"
//                +" ";
//        Statement stmt =conn.createStatement();
//        stmt.execute(createTablesql);
//    }
////deleteing the whole table
//    private static void deleteTable(Connection conn) throws SQLException
//    {
//        String deleteTableSQL = "DROP TABLE disease";
//        Statement stmt =conn.createStatement();
//        stmt.execute(deleteTableSQL);
//
//    }
////updating exsisting table
//    private static void updateTable(Connection conn,String symptoms ,String treatments , String disease_name )throws SQLException
//    {
//        String updateTable ="UPDATE disease SET symptoms=?, treatments=? WHERE disease_name =?";
//        PreparedStatement psmt =conn.prepareStatement(updateTable);
//        psmt.setString(1,symptoms);
//        psmt.setString(2,treatments);
//        psmt.setString(3,disease_name);
//
//        psmt.executeUpdate();
//
//>>>>>>> Stashed changes
//    }
//}
//
package io.github.Outbreakradar;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class favorites
{
    public static void main(String[] args)
    {
        Connection conn= null;
        try
        {
            conn = DriverManager.getConnection("jdbc:sqlite:Outbreakradar.db");
            System.out.println("opened database connection");
            try {
                deleteTable(conn);
            } catch (Exception ignored)
            {

            }

            //sreegovind, the part from down here to the next comment is manual usage of the functions created
            createTable(conn);
            System.out.println(" ");
            System.out.println("inserting data");
            insertDisease(conn, "corona", "Nolan","5");
            insertDisease(conn, "hitman", "black plague","6");
            updateTable(conn,"cough and fever","hot water steaming","corona");
            System.out.println(" ");
            System.out.println("displaying database");
            displaydatabase(conn, "disease");
            //till here
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println(e.getClass().getName()+": "+e.getMessage());

        }
        finally{
            if(conn!=null) {
                try {
                    conn.close();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println(e.getMessage());

                }
            }
        }
    }



    private static void displaydatabase(Connection conn,String tableName)throws SQLException
    {
        String selectSQL="SELECT * from "+tableName;
        Statement stmt = conn.createStatement();
        ResultSet rs =stmt.executeQuery(selectSQL);
        //the code below is to display in terminal,'rs' of Resultset contains the result
        System.out.println("-------"+tableName+"-------");
        while(rs.next()) {
            System.out.println("disease_name: " + rs.getString("disease_name") + ",");
            System.out.println("symptoms: "+rs.getString("symptoms") + ",");
            System.out.println("treatments: "+rs.getString("treatments")+"\n");
        }
        System.out.println("------------------------------");

    }

    //insering data into table
    private static void insertDisease(Connection conn, String disease_name,String symptoms, String treatments)throws SQLException
    {
        String insertSQL ="INSERT INTO disease(disease_name,symptoms,treatments)VALUES(?,?,?)";
        PreparedStatement pstmt =conn.prepareStatement(insertSQL);
        pstmt.setString(1,disease_name);
        pstmt.setString(2,symptoms);
        pstmt.setString(3,treatments);
        pstmt.executeUpdate();


    }

    // creating table
    private static void createTable(Connection conn)throws SQLException
    {
        String createTablesql=" "+
                "create table disease("+
                "disease_name varchar(50),"+
                "symptoms varchar(50),"+
                "treatments varchar(5)"
                +")"
                +" ";
        Statement stmt =conn.createStatement();
        stmt.execute(createTablesql);
    }
    //deleteing the whole table
    private static void deleteTable(Connection conn) throws SQLException
    {
        String deleteTableSQL = "DROP TABLE disease";
        Statement stmt =conn.createStatement();
        stmt.execute(deleteTableSQL);

    }
    //updating exsisting table
    private static void updateTable(Connection conn,String symptoms ,String treatments , String disease_name )throws SQLException
    {
        String updateTable ="UPDATE disease SET symptoms=?, treatments=? WHERE disease_name =?";
        PreparedStatement psmt =conn.prepareStatement(updateTable);
        psmt.setString(1,symptoms);
        psmt.setString(2,treatments);
        psmt.setString(3,disease_name);

        psmt.executeUpdate();

    }
}

