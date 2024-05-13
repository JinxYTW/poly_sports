import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.Driver;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load the MySQL driver

            Connection myConnection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/poly_sports",
                "root",
                ""
            ); // Connect to the database

            System.out.println("Connected to the database");

            java.sql.Statement myStatement = myConnection.createStatement();
            ResultSet myResultSet = myStatement.executeQuery("SELECT * FROM sport");

            while(myResultSet.next()){
                
                System.out.println(myResultSet.getString("name")+"|"+myResultSet.getInt("required_participants"));
            }
        }
    catch(Exception e){
        System.out.println("Error: " + e);
    }

}
}
