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
					dragonResult = QueryMethod.read(dragonName);
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
					int size =0;
					int scales =0;
					Boolean spitFire = true;
					int id =0;
						System.out.println("Please enter the name: ");
					String name = scanner.nextLine();
					System.out.println("Please enter the sex: ");
					String gender = scanner.nextLine();
					while (true) {//Always receive user input
						System.out.println("Please enter the size: ");
						String temp = scanner.nextLine();//Transit value
						boolean flag = temp.matches("[0-9]+");//Regular, all match numbers
						if (flag) {//If the match is successful, the input string is full of numbers
							size = Integer.parseInt(temp);//change string temp to int and pass it to the age we want
						} else {//If the match is not successful, it goes to the next loop
							System.out.println("The values entered do not match");
							continue;//Jump out of this while loop and execute the next while loop
						}
						if (temp != null) {
							break;
						} 
					}
					while (true) {//Always receive user input
						System.out.println("Please enter the number of scales: ");
						String temp = scanner.nextLine();//Transit value
						boolean flag = temp.matches("[0-9]+");//Regular, all match numbers
						if (flag) {//If the match is successful, the input string is full of numbers
							 scales = Integer.parseInt(temp);//Convert temp to int and pass it to the age we want
						} else {//If the match is not successful, it goes to the next loop
							System.out.println("The values entered do not match");
							continue;//Jump out of this while loop and execute the next while loop
						}
						if (temp != null) {
							break;
						} 
					}	
					//yesOrNo for save answer from user
					String yesOrNo = "t";
					//while yesOrNo is not y/n keep asking question
			        while (!yesOrNo.equalsIgnoreCase("y") && !yesOrNo.equalsIgnoreCase("n")) {
			        	
			        	System.out.println("Does the dragon spit fire? (y/n) ");			        	
			    		yesOrNo = scanner.nextLine();    		                      
			        }
			        //if answer "y" set spitFire to true
			        if (yesOrNo.equalsIgnoreCase("y")) {
			        	 spitFire = true;
			        	 //if not set spitFire to false
					} else {
						 spitFire =false;
					}
					System.out.println("Please enter behavior in love: ");
					String loveStatus = scanner.nextLine();
					//create new dragonObj to store all the answers
					Dragon dragonObj = new Dragon(id,name,gender,size,scales,spitFire,loveStatus);
					//calling the create method giving it the dragonObj
					//saving the answer into the boolean dragonfill
					Boolean dragonFill = QueryMethod.create(dragonObj);
					//if success to fill dragon
			        if(dragonFill) {
			        	System.out.println("dragon successfully inserted");
			        	//if unsuccessful
			        }else {
			        	System.out.println("dragon not inserted");
			        }
					
		}else if (answer.equals("3")) {
			System.out.println("Please provide the name of the dragon you want delete: ");
			String deleteDragonName = scanner.nextLine(); //to store the name of the dragon the user is looking for
//			ArrayList<Dragon> dragonResult = QueryMethod.read(deleteDragonName);	
			Boolean dragonDelete = QueryMethod.deleteByNamePrepared(deleteDragonName);
			if(dragonDelete) {
	        	System.out.println("dragon successfully deleted");
	        	//if unsuccessful
	        }else {
	        	System.out.println("dragon not deleted");
	        }
			
		}else if (answer.equals("4")) {
			System.out.println("Please provide the name of the dragon you want to change: ");
			String dragonName = scanner.nextLine(); //to store the name of the dragon the user is looking for
//			//array List for storing the result from the readAll method
			ArrayList<Dragon> dragonResult = new ArrayList<Dragon>();
			dragonResult = QueryMethod.read(dragonName);
			int id=0;
			String oldDragonName="";
			String oldDragonGender="";
			int oldDragonSize=0;
			int oldDragonScales=0;
			Boolean oldDrgonFire=true;
			String oldDragonLove="";
			String nameFromDB="";
			//checking each reseult with for loop
			for(int i =0; i < dragonResult.size(); i++) {
				//saving from dragonObj into string,int,boolean
				
				oldDragonName = dragonResult.get(i).getNom();
				nameFromDB = dragonResult.get(i).getNom();
				oldDragonGender = dragonResult.get(i).getGenre();
				oldDragonSize = dragonResult.get(i).getSize();
				oldDragonScales = dragonResult.get(i).getScales();
				oldDrgonFire = dragonResult.get(i).getFire();
				oldDragonLove = dragonResult.get(i).getLove();
				System.out.println("Name is: " +dragonResult.get(i).getNom());
				System.out.println("Genre is: "+dragonResult.get(i).getGenre());
				System.out.println("Size is: "+dragonResult.get(i).getSize());
				System.out.println("Scales is: "+dragonResult.get(i).getScales());
				System.out.println("Fire is: "+dragonResult.get(i).getFire());
				System.out.println("Love is: "+dragonResult.get(i).getLove());
	        }	
			System.out.println("Please enter which of dragon to change: ");
			System.out.println("1=Name / 2=Genre / 3=Size / 4=Scales / 5=Fire / 6=Love");
			String dragonUpdate = scanner.nextLine();
			boolean flag = dragonUpdate.matches("[0-9]+");
			int dragonCase =0;
			
			if (flag) {//If the match is successful, the input string is full of numbers
				dragonCase = Integer.parseInt(dragonUpdate);//change string temp to int and pass it to the age we want
			} else {//If the match is not successful, it goes to the next loop
				System.out.println("The values entered do not match");
				continue;//Jump out of this while loop and execute the next while loop
			}
			
			switch(dragonCase) {
			case 1:
				System.out.println("Please enter the new dragon name: ");
				String newDragonName = scanner.nextLine();
				oldDragonName = newDragonName;
				break;
			case 2:
				System.out.println("Please enter the new dragon Genre: ");
				String newDragonGenre = scanner.nextLine();
				oldDragonGender = newDragonGenre;
				break;
			case 3:
				System.out.println("Please enter the new dragon Size: ");
				int newDragonSize = scanner.nextInt();
				oldDragonSize = newDragonSize;
				break;
			case 4:
				System.out.println("Please enter the new dragon Scales: ");
				int newDragonScales = scanner.nextInt();
				oldDragonScales = newDragonScales;
				break;
			case 5:
				System.out.println("Please enter the new dragon Scales: ");
				Boolean newDrgonFire = scanner.nextBoolean();
				oldDrgonFire = newDrgonFire;
				break;
			case 6:
				System.out.println("Please enter the new dragon name: ");
				String newDragonLove = scanner.nextLine();
				oldDragonLove = newDragonLove;
				break;
			}
			Dragon updateObj = new Dragon(id, oldDragonName, oldDragonGender, oldDragonSize, oldDragonScales, oldDrgonFire, oldDragonLove);
//			//calling the create method giving it the dragonObj
			//saving the answer into the boolean dragonfill
			Boolean dragonAnswer = QueryMethod.update(updateObj,nameFromDB);
			//if success to fill dragon
	        if(dragonAnswer) {
	        	System.out.println("dragon successfully updated");
	        	//if unsuccessful
	        }else {
	        	System.out.println("dragon not updated");
	        }
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
