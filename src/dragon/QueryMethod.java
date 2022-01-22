package dragon;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import javax.sql.rowset.JoinRowSet;


public class QueryMethod extends ConnectionDB {	
	public static ArrayList<Dragon> read(String dragonName) {
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

	public static boolean create(Dragon dragonObj) {
			 		 
		//if create failed check with boolean
			boolean flag = false;
			//saving from dragonObj into string,int,boolean
			String dragonName = dragonObj.getNom();
			String dragonGender = dragonObj.getGenre();
			int dragonSize = dragonObj.getSize();
			int dragonScales = dragonObj.getScales();
			Boolean dragonFire = dragonObj.getFire();
			String dragonLove = dragonObj.getLove();
			
		 try {	
			 //insert each column into dragons table 
			String query = "INSERT INTO dragons (Dragon,Sexe,Longueur,NombreEcailles,CracheDuFeu,ComportementAmoureux) VALUES(?,?,?,?,?,?)";
			//creating a preparedstatement obj containing select query
		 PreparedStatement declaration = accessDataBase.prepareStatement(query);
		//executing the preparedstatement obj replacing "?" with different variables in the insert query
		 declaration.setString(1, dragonName);
		 declaration.setString(2, dragonGender);		
		 declaration.setInt(3, dragonSize);
		 declaration.setInt(4, dragonScales);
		 declaration.setBoolean(5,dragonFire);
		 declaration.setString(6, dragonLove);
		 int executeUpdate = declaration.executeUpdate();	
		 //if insert is successful set flag to true
		 flag = (executeUpdate == 1);		 
		 } catch (SQLException e) {
		 System.err.println(
		 "Error inserting dragons: " + e.getMessage()
		 );
		 }
		 return flag;

		}
	public static boolean deleteByNamePrepared(String deleteDragonName) {
			
		 boolean success = false;		
		 try {	
		//delete query on the DB in the Dragon table search by name column
		 String query = "DELETE FROM dragons WHERE Dragon = ?";
		//creating a preparedstatement obj containing select query
		 PreparedStatement declaration = accessDataBase.prepareStatement(query);
		//executing the preparedstatement obj replacing "?" with different variables in the insert query
		 declaration.setString(1, deleteDragonName);
		 int executeUpdate = declaration.executeUpdate();
		 success = (executeUpdate == 1);
		 } catch (SQLException e) {
		 System.err.println("Erreur suppression dragons: "
		 + e.getMessage());
		 }
		 return success;
		}
	 public static boolean update(Dragon dragonObj,String nameFromDB ) {

		//saving from dragonObj into string,int,boolean
			String dragonName = dragonObj.getNom();
			String dragonGender = dragonObj.getGenre();
			int dragonSize = dragonObj.getSize();
			int dragonScales = dragonObj.getScales();
			Boolean dragonFire = dragonObj.getFire();
			String dragonLove = dragonObj.getLove();		 		 
		 
			boolean flag = false;
		 try {	
			//update query to the DB in the Dragon table to update all fields, search by name column
			String query = "UPDATE dragons SET Dragon = ?, Sexe = ?, Longueur = ?, NombreEcailles = ?, CracheDuFeu = ?, ComportementAmoureux = ? WHERE Dragon = ?";
			//creating a preparedstatement obj containing select query
		 PreparedStatement declaration = accessDataBase.prepareStatement(query);
		//executing the preparedstatement obj replacing "?" with different variables in the insert query
		 declaration.setString(1, dragonName);
		 declaration.setString(2, dragonGender);		
		 declaration.setInt(3, dragonSize);
		 declaration.setInt(4, dragonScales);
		 declaration.setBoolean(5,dragonFire);
		 declaration.setString(6, dragonLove);
		 declaration.setString(7, nameFromDB);
		//executing the preparedstatement obj replacing "?" with different variables in the insert query
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
