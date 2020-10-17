package trainSchedule;

import java.util.Collections;
import java.util.Scanner;

import Model.AllTravels;
import Model.SortByTime;
import Model.Travel;

public class Main {

	public static <T> void main(String[] args) {

		final String MAIN_MENU_MESSAGE = "\n*Welcome to Israel Railways*\nMain Menu: (choose an option)\n"
				+ "1. Enter travel details\n" + "2. Show travels list\n" + "3. Search for travel\n" + "9. Exit\n";


		AllTravels allTravels = new AllTravels();
		IntermediateStations intermadiateStations = new IntermediateStations();
		

		Scanner scanner = new Scanner(System.in);

		boolean stopMenu = false;
		do {
			System.out.println(MAIN_MENU_MESSAGE);

			int option = scanner.nextInt();
			switch (option) {

			case 1: // add a new travel
				addNewTravel(scanner, allTravels, intermadiateStations);
				break;

			case 2: // sort and show travels list
				Collections.sort(allTravels.getAllTravels(), new SortByTime());
				System.out.println("\nIsrael Railways Scheudule: ");
				System.out.print(allTravels);
				break;

			case 3: // sort and show travels list
				 searchTravel(scanner, allTravels);
				break;

			default:
				stopMenu = true;
				break;
			}

		} while (!stopMenu);

	}



	private static void searchTravel(Scanner in, AllTravels allTravels) {
		in.nextLine(); // clean buffer
		
		System.out.println("Enter starting station");
		String startingStation = in.nextLine();
		int flag = 1;

		System.out.println("Enter leaving time (hours and minutes) in format xx:xx");
		String[] leavingTime = in.next().split(":");
		int hours = Integer.parseInt(leavingTime[0]); // Converting String into int using Integer.parseInt()
		int minutes = Integer.parseInt(leavingTime[1]);
		
		in.nextLine(); // clean buffer

		System.out.println("Enter destination station");
		String destinationStation = in.nextLine();
		
		int flagTravels = 0; //Displays up to 3 trips
		for (Travel t : allTravels.getAllTravels()) {
			if(flagTravels > 2) {
				return;
			}
			if (t.getStartingStation().equals(startingStation)  && t.getDestinationStatin().equals(destinationStation)) {
				if(t.getTime().gethour() > hours) {
					break;
				}
				if(t.getTime().gethour() == hours) {
					if(t.getTime().getminute() >= minutes) {
						System.out.println(t);
						flagTravels +=1 ;
					}
				}
			}
		}
		if(flagTravels == 0) {
			System.out.println("No travels found");
		}
	}



	private static void addNewTravel(Scanner in, AllTravels allTravels, IntermediateStations intermadiateStations) {
		in.nextLine(); // clean buffer

		System.out.println("Enter starting station");
		String startingStation = in.nextLine();
		int flag = 1;
		int firstIntermediateStation=0;


		System.out.println("Enter leaving time (hours and minutes) in format xx:xx");
		String[] leavingTime = in.next().split(":");
		int hours = Integer.parseInt(leavingTime[0]); // Converting String into int using Integer.parseInt()
		int minutes = Integer.parseInt(leavingTime[1]);
		
		in.nextLine(); // clean buffer

		System.out.println("Enter destination station");
		String destinationStation = in.nextLine();
		int cnt = 0;
		

		// input intermediate station
		do {
			if (cnt == 0) {
				System.out.println("Do this travel have intermediate station? 1 for yes, 0 for no");
				firstIntermediateStation = 1;
			} else if (cnt <= 3) {
				System.out.println("Do this travel have more intermediate station? 1 for yes, 0 for no");
			}
			flag = in.nextInt();
			IntermediateStation newIntermediateStation = new IntermediateStation();
			if(flag == 0 && firstIntermediateStation ==1) {
				intermadiateStations.setNumOfStations(0);
				break;
			}
			firstIntermediateStation = 0;
			if (flag == 0) {
				break;
			} else {
				cnt++;
				if (cnt <= 3) { // for avoiding travels that contain over then 3 intermediate stations.
					in.nextLine(); // clean buffer
					System.out.println("Enter intermediate station:");
					String intermediateStationName = in.nextLine();

					System.out.println("Enter intermediate station leaving time (hours and minutes) in format xx:xx");
					String[] intermediateLeavingTime = in.next().split(":");
					int intermediateHours = Integer.parseInt(intermediateLeavingTime[0]); // Converting String into
																							// integer using
																							// Integer.parseInt()
					int intermediateMinutes = Integer.parseInt(intermediateLeavingTime[1]);

					LeavingTime newLeavingTime = new LeavingTime(intermediateHours, intermediateMinutes);

					newIntermediateStation.setIntermediateStation(intermediateStationName);
					newIntermediateStation.setTime(newLeavingTime);
					intermadiateStations.add(newIntermediateStation); 

				
						
				}
			}

		} while ((flag == 0 || flag == 1) && (cnt <= 3));
		
		
		Travel newTravel = new Travel(startingStation, destinationStation, hours, minutes, intermadiateStations);
		allTravels.addTravel(newTravel);
	}

}
