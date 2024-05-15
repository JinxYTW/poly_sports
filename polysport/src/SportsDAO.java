import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SportsDAO {
    
    private MYSQLDatabase database;

    public SportsDAO(MYSQLDatabase database) {
        this.database = database;
    }

    public ArrayList<Sport> findAll(){
        ArrayList<Sport> sports = new ArrayList<Sport>();
        try {
            ResultSet myResultSet = database.createStatement().executeQuery("SELECT * FROM sport");
            while(myResultSet.next()){
                Sport sport = new Sport(myResultSet.getInt("id"), myResultSet.getString("name"), myResultSet.getInt("required_participants"));
                sports.add(sport);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return sports;
        
    }

    public Sport findById(int id){
        try {
            ResultSet myResultSet = database.createStatement().executeQuery("SELECT * FROM sport WHERE id = " + id);
            if(myResultSet.next()){
                return new Sport(myResultSet.getInt("id"), myResultSet.getString("name"), myResultSet.getInt("required_participants"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return null;
    }

    public ArrayList<Sport> findByName(String name){
        ArrayList<Sport> sports = new ArrayList<Sport>();
        try {
            ResultSet myResultSet = database.createStatement().executeQuery("SELECT * FROM sport WHERE name LIKE '%" + name + "%'");
            while(myResultSet.next()){
                Sport sport = new Sport(myResultSet.getInt("id"), myResultSet.getString("name"), myResultSet.getInt("required_participants"));
                sports.add(sport);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return sports;

        
    }

}
