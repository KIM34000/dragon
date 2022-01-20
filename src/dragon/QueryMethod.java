package dragon;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;


public class QueryMethod extends ConnectionDB {	
	public static ArrayList<Dragon> readAll(String dragonName) {
		//Resultset is the key for save answer from SQL query
        ResultSet rs = null; 
        //create arrayList
        ArrayList<Dragon> dragonArray = new ArrayList<Dragon>();        
		try {
			//select query to get all information from the DB in the Dragon table
			String query = "SELECT * FROM dragons WHERE Dragon = ?";
			//creating a preparedstatement obj containing select query
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			//executing the preparedstatement obj replacing "?" with dragonName in the selecte query
			declaration.setString(1, dragonName);
			rs = declaration.executeQuery();		
			//Fetching from DB 
			 while (rs.next()) {
				 //saving the result in dragon obj inside arrayList
				 dragonArray.add( new Dragon(
					 rs.getInt("id"),
					 rs.getString("Dragon"),
					 rs.getString("Sexe"),
					 rs.getInt("Longueur"),
					 rs.getInt("NombreEcailles"),
					 rs.getBoolean("CracheDuFeu"),           
					 rs.getString("ComportementAmoureux")		
						
			 ));
			 }
			//if something goes wrong with query we catch here and print error message
		} catch (SQLException e) {
		System.err.println(
		"Error finding dragon: " + e.getMessage()
		);
		}
		//return result DB as an arrayList
		return dragonArray;
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
	public static boolean deleteByNamePrepared(String dragonName) {
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
