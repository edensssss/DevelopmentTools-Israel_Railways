package trainSchedule;

import java.util.ArrayList;
import java.util.Scanner;

import Model.Travel;

public class Main {

	public static <T> void main(String[] args) {

		
		final String MAIN_MENU_MESSAGE = "*Welcome to Israel Railways*\nMain Menu: (choose an option)\n" + "1. Enter travel details\n" + "2. Show travels list\n"
				+ "9. Exit\n";
		
	//	final static String FILTER_MENU_MESSAGE = "\nDisplay Menu: (choose an option)\n" + "1. Departures Only\n"
	//			+ "2. Arrivals Only\n"+"3. Company\n" + "4. Country\n" + "5. City\n"  + "6. Airport Name\n"  +"7. From Date\n" + "8. To Date\n" + "9. Days of Week\n"
	//			+ "0. Reset All Filters\n" + "Press any other key to go back";
		
		
	//	final static String FLIGHTS_FILE_NAME = "flights.obj";
	

		ArrayList<Travel> allTravels = new ArrayList<>();

		Scanner scanner = new Scanner(System.in);
		
		
		
		boolean stopMenu = false; 
		do {
			System.out.println(MAIN_MENU_MESSAGE);

			int option = scanner.nextInt();
			switch (option) {

			case 1: // add a new travel
			
				
				addNewTravel(scanner, allTravels);
				
				
				break;

			case 2: // sort and show travels list

		//		sortByLeavingTime(allTravels);
				showTavelsList(allTravels);
				break;
				
			default:
				stopMenu = true;
				break;
			}

		} while (!stopMenu);

	}
	

	private static void showTavelsList(ArrayList<Travel> allTravels) {

		System.out.println("Israel Railways Scheudule: ");
		for (Travel t : allTravels) {
			System.out.println(t);
		}
		
	}

	private static void addNewTravel(Scanner in, ArrayList<Travel> allTravels) {
	in.nextLine(); //clean buffer
		System.out.println("Enter starting station");
		String startingStation = in.nextLine();
		
		System.out.println("Enter leaving time (hours and minutes) in format xx:xx");
		String[] leavingTime = in.next().split(":"); 
		int hours = Integer.parseInt(leavingTime[0]); //Converting String into int using Integer.parseInt() 
		int minutes = Integer.parseInt(leavingTime[1]);
		
		in.nextLine(); //clean buffer
		
		System.out.println("Enter destination station");
		String destinationStation = in.nextLine();
	
		Travel newTravel = new Travel(startingStation, destinationStation, hours, minutes);
		
		allTravels.add(newTravel);
	

		//here need to add the newTravel to all travels

	}

}
