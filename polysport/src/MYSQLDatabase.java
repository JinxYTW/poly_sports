import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.xdevapi.PreparableStatement;

public class MYSQLDatabase {
    private String host;
    private int port;
    private String database;
    private String user;
    private String password;
    private Connection connection;
    private static boolean driverLoaded;

    public MYSQLDatabase(String host, int port, String database, String user, String password) {
        connection = null;
        
        this.host = host;
        this.port = port;
        this.database = database;
        this.user = user;
        this.password = password;
    }

    public static void loadDriver() {
        if(driverLoaded)
            return;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            driverLoaded = true;
            System.out.println("Driver loaded");
        } catch (Exception e) {
            System.out.println("Error: " + e);
            
            
        } 
    }

    public void connect(){

        if (!driverLoaded)
            return;
        try{
             connection = DriverManager.getConnection(
                "jdbc:mysql://" + host + ":" + port + "/" + database+"?allowMultiQueries=true",
                user,
                password
            ); // Connect to the database
            System.out.println("Connected to the database");
        }
        catch(Exception e){
            System.out.println("Error: " + e);

        }
    }


    public Statement createStatement() throws SQLException {
        if (connection != null){
        
            return connection.createStatement();
            
                
            
            
        }
        return null;
    }  

    public PreparedStatement prepareStatement(String sql) throws SQLException {
        if (connection != null){
            return connection.prepareStatement(sql);
        }
        return null;

    }
}

