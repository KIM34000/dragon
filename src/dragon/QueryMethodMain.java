package dragon;

import java.util.ArrayList;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.PrimitiveIterator.OfDouble;

public class QueryMethodMain {
	// This is the main method that runs the scenario to test all the methods found in the QueryMethod class
	public static void main(String[] args) {
		ConnectionDB.openConnection(); // Calls upon a method in the ConnctionDB class to open a connection the DB

		String answer; // This is where we store the answer from the user
		Scanner scanner = new Scanner(System.in); // The scanner is used to capture user input
		do { // do/while loop that keeps asking the user which action they want to perform
			System.out.println("What would you like to do?"+"\n"+"1 = Search for a dragon"+"\n"+"2 = Create a new dragon"+"\n"+"3 = Delete an existing dragon"+"\n"+"4 = Update an existing dragon");

		answer = scanner.nextLine(); // here we store the user's answer into the String 'answer'
		// if/else to check what the user wants to do, then call upon the method that is needed to do it
		
        
		if (answer.equals("1")) {
					System.out.println("Please provide the name of the dragon you are looking for: ");
					String dragonName = scanner.nextLine(); //to store the name of the dragon the user is looking for
//					//array List for storing the result from the readAll method
					ArrayList<Dragon> dragonResult = new ArrayList<Dragon>();
					// calling readAll method giving it dragon name as parameter
					dragonResult = QueryMethod.readAll(dragonName);
					//checking each reseult with for loop
					for(int i =0; i < dragonResult.size(); i++) {
						System.out.println("Name is: " +dragonResult.get(i).getNom());
						System.out.println("Genre is: "+dragonResult.get(i).getGenre());
						System.out.println("Size is: "+dragonResult.get(i).getSize());
						System.out.println("Scales is: "+dragonResult.get(i).getScales());
						System.out.println("Fire is: "+dragonResult.get(i).getFire());
						System.out.println("Love is: "+dragonResult.get(i).getLove());
			        }
		            
				}else if (answer.equals("2")) {
			
		}else if (answer == "3") {
//			System.out.println("Please provide the name of the dragon you want delete: ");
//			String dragonName = scanner.nextLine(); //to store the name of the dragon the user is looking for
//			Dragon dragonResult[] = QueryMethod.readAll(dragonName);	
//			QueryMethod.deleteByNamePrepared(dragonName);			
		}else if (answer == "4") {
			
		}else { // if the user chose something else, then we ask again
			System.out.println("Sorry, I don't understand what you want, please try again");
			continue;
			
		}}while (true);
		
//		QueryMethod.readAll();
//		QueryMethod.create();
//		QueryMethod.deleteByNamePrepared();
//		QueryMethod.update();
	}

}
