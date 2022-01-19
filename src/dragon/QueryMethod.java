package dragon;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class QueryMethod extends ConnectionDB {
	public static boolean readAll() {

		 Scanner scanner = new Scanner(System.in);		 		 
		 
			boolean flag = false;
		 try {	
			 System.out.println("Please enter the name of dragon that you want to read: ");
				String dragonRead = scanner.nextLine();
				System.out.println(dragonRead);
			String query = "SELECT id, Dragons,Sexe,Longueur,NombreEcailles,CracheDuFeu,ComportementAmoureux FROM dragon WHERE id = ? ";
		 PreparedStatement declaration = accessDataBase.prepareStatement(query);
		 declaration.setString(1, dragonRead);
		 int executeUpdate = declaration.executeUpdate();		 
		 flag = (executeUpdate == 1);		 
		 } catch (SQLException e) {
		 System.err.println(
		 "Error inserting dragons: " + e.getMessage()
		 );
		 }
		 return flag;

		}
	public static boolean create() {

		 Scanner scanner = new Scanner(System.in);		 		 
		 
			boolean flag = false;
		 try {	
			 System.out.println("Please enter the name of dragon: ");
				String dragonName = scanner.nextLine();
				System.out.println(dragonName);
			String query = "INSERT INTO dragons (Dragon) VALUES(?)";
		 PreparedStatement declaration = accessDataBase.prepareStatement(query);
		 declaration.setString(1, dragonName);
		 int executeUpdate = declaration.executeUpdate();		 
		 flag = (executeUpdate == 1);		 
		 } catch (SQLException e) {
		 System.err.println(
		 "Error inserting dragons: " + e.getMessage()
		 );
		 }
		 return flag;

		}
	public static boolean deleteByNamePrepared() {
		Scanner scanner = new Scanner(System.in);	
		 boolean success = false;
		 try {
			 System.out.println("Please enter which dragon want delete the name: ");
				String deleteDragonName = scanner.nextLine();
				System.out.println(deleteDragonName);
		 String query = "DELETE FROM dragons WHERE Dragon = ?";
		 PreparedStatement declaration = accessDataBase.prepareStatement(query);
		 declaration.setString(1, deleteDragonName);
		 int executeUpdate = declaration.executeUpdate();
		 success = (executeUpdate == 1);
		 } catch (SQLException e) {
		 System.err.println("Erreur suppression dragons: "
		 + e.getMessage());
		 }
		 return success;
		}
	 public static boolean update() {

		 Scanner scanner = new Scanner(System.in);		 		 
		 
			boolean flag = false;
		 try {	
			 System.out.println("Please enter the name of dragon to change: ");
				String updateDragon = scanner.nextLine();
				System.out.println(updateDragon);
				System.out.println("Please enter the new dragon name: ");
				String newDragon = scanner.nextLine();
			String query = "UPDATE dragons SET Dragon = ? WHERE Dragon = ?";
		 PreparedStatement declaration = accessDataBase.prepareStatement(query);
		 declaration.setString(1, newDragon);
		 declaration.setString(2, updateDragon);
		 int executeUpdate = declaration.executeUpdate();		 
		 flag = (executeUpdate == 1);		 
		 } catch (SQLException e) {
		 System.err.println(
		 "Erreur d'insertion dragon: " + e.getMessage()
		 );
		 }
		 return flag;

		}
}
