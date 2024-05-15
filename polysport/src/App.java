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

            System.out.println("Enter the name of the sport to insert: ");
            String name2 = scanner.nextLine();
            System.out.println("Enter the number of participants: ");
            int participants = scanner.nextInt();
            sportsDAO.insert(new Sport(0, name2, participants));

            System.out.println("Enter the name of the sport to update: ");
            String name3 = scanner.nextLine();
            System.out.println("Enter the number of participants: ");
            int participants2 = scanner.nextInt();
            sportsDAO.update(new Sport(0, name3, participants2));

            System.out.println("Enter the id of the sport to delete: ");
            int id2 = scanner.nextInt();
            sportsDAO.delete(id2);


            scanner.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }


}
}

