import java.sql.PreparedStatement;
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
        PreparedStatement statement = database.prepareStatement("SELECT * FROM sport WHERE id = ?");
        statement.setInt(1, id);
        ResultSet myResultSet = statement.executeQuery();
        if(myResultSet.next()){
            return new Sport(myResultSet.getInt("id"), myResultSet.getString("name"), myResultSet.getInt("required_participants"));
        }
    } catch (SQLException e) {
        System.out.println("Error: " + e);
    }
    return null;
}

    public ArrayList<Sport> findByName(String name){
        ArrayList<Sport> sports = new ArrayList<>();
        try {
            PreparedStatement statement = database.prepareStatement("SELECT * FROM sport WHERE name LIKE ?");
            statement.setString(1, "%" + name + "%");
            ResultSet myResultSet = statement.executeQuery();
            while(myResultSet.next()){
                sports.add(new Sport(myResultSet.getInt("id"), myResultSet.getString("name"), myResultSet.getInt("required_participants")));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return sports;
    }

    public boolean insert(Sport sport){
        try {
            PreparedStatement statement = database.prepareStatement("INSERT INTO sport (name, required_participants) VALUES (?, ?)");
            statement.setString(1, sport.getName());
            statement.setInt(2, sport.getRequiredParticipants());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return false;
    }

    public boolean update(Sport sport){
        try {
            PreparedStatement statement = database.prepareStatement("UPDATE sport SET name = ?, required_participants = ? WHERE id = ?");
            statement.setString(1, sport.getName());
            statement.setInt(2, sport.getRequiredParticipants());
            statement.setInt(3, sport.getId());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return false;
    }

    public boolean delete(int id){
        try {
            PreparedStatement statement = database.prepareStatement("DELETE FROM sport WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return false;
    }

}
