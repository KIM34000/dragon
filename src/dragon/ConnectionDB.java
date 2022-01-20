package dragon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConnectionDB {
	static Connection accessDataBase = null;	
	/**
	 * Connection to my data base dragon
	 * @throws SQLException
	 */
	public static void openConnection() {
		 /* Connection parameters */
		 String url = "jdbc:mysql://127.0.0.1/dragon";
		 // dragon = my data base name
		 String utilisateur = "root";
		 String motDePasse = "";
		 try {
		 System.out.println("try to connect");
		 // we add ours parameters
		 accessDataBase = DriverManager.getConnection(
		 url, utilisateur, motDePasse);
		 } catch (SQLException ex) {
		 Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null,
		ex);
		 
		 }
		 }
	/**
	 * True if the connection is OK
	 *
	 * @return
	 */
	 public static boolean testConnection() {
	 boolean flag = false;
	 try {
	 if (accessDataBase != null) {
	 if (!accessDataBase.isClosed()) {
	 System.out.println("Connexion au serveur... OK");
	 flag = true;
	 }
	 }
	 } catch (SQLException ex) {
	 Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null,
	ex);
	 }
	 return flag;
	 }
	 public static void closeConnection() {
		 if (accessDataBase != null) {
		 try {
		 accessDataBase.close();
		 System.out.println("Close connection");
		 } catch (SQLException e) {
		 System.err.println(
		 "Erreur fermreture: " + e.getMessage()
		 );
		 }
		 }
		}
}
