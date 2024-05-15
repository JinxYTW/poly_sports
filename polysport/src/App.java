import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            
            Sport sport = new Sport(1, "Badminton (simple)", 2);
            System.out.println(sport.getName() + " requires " + sport.getRequiredParticipants() + " participants");
            
            MYSQLDatabase.loadDriver();
            
            PolySportsDatabase mysqldatabase= PolySportsDatabase.getInstance(); //No comprendo
            mysqldatabase.connect();

            SportsDAO sportsDAO = new SportsDAO(mysqldatabase);
            for (Sport sports : sportsDAO.findAll()) {
                System.out.println(sports.getName() + " requires " + sports.getRequiredParticipants() + " participants");
            
                
            }
            
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the name of the sport: ");
            String name = scanner.nextLine();
            System.out.println(sportsDAO.findByName(name));
            System.out.println("Enter the name of the id: ");
            int id = scanner.nextInt();
            System.out.println(sportsDAO.findById(id));
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }


}
}

