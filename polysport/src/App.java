import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.Driver;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            MYSQLDatabase.loadDriver();
            
            PolySportsDatabase mysqldatabase= PolySportsDatabase.getInstance(); //No comprendo
            mysqldatabase.connect();

            ResultSet myResultSet = mysqldatabase.createStatement().executeQuery("SELECT * FROM sport");

            while(myResultSet.next()){
                
                System.out.println(myResultSet.getString("name")+"|"+myResultSet.getInt("required_participants"));
            }
        }
    catch(Exception e){
        System.out.println("Error: " + e);
    }

}
}
