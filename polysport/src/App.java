import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.cj.jdbc.Driver;

public class App {
    public static void main(String[] args) throws Exception {
        try{
        Class.forName("com.mysql.cj.jdbc.Driver"); // Load the MySQL driver
        Connection connection = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/poly_sports",
        "root",
        ""
        );
        System.out.println("Connected to the database");
    }
    catch(Exception e){
        System.out.println("Error: " + e);
    }

}
}
