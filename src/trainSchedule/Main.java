package trainSchedule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import Model.SortByTime;
import Model.Travel;

public class Main {

	public static <T> void main(String[] args) {

		final String MAIN_MENU_MESSAGE = "*Welcome to Israel Railways*\nMain Menu: (choose an option)\n"
				+ "1. Enter travel details\n" + "2. Show travels list\n" + "3. Search for travel\n" + "9. Exit\n";

		// final static String FILTER_MENU_MESSAGE = "\nDisplay Menu: (choose an
		// option)\n" + "1. Departures Only\n"
		// + "2. Arrivals Only\n"+"3. Company\n" + "4. Country\n" + "5. City\n" + "6.
		// Airport Name\n" +"7. From Date\n" + "8. To Date\n" + "9. Days of Week\n"
		// + "0. Reset All Filters\n" + "Press any other key to go back";

		// final static String FLIGHTS_FILE_NAME = "flights.obj";

		ArrayList<Travel> allTravels = new ArrayList<>();
		ArrayList<IntermediateStation> intermadiateStations = null;

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

				Collections.sort(allTravels, new SortByTime());
				showTavelsList(allTravels);
				break;

			case 3: // sort and show travels list

				// searchTravel();
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

	private static void addNewTravel(Scanner in, ArrayList<Travel> allTravels,
			ArrayList<IntermediateStation> intermadiateStations) {
		in.nextLine(); // clean buffer

		System.out.println("Enter starting station");
		String startingStation = in.nextLine();
		int flag = 1;

		// IntermediateStation newIntermediateStation;

		System.out.println("Enter leaving time (hours and minutes) in format xx:xx");
		String[] leavingTime = in.next().split(":");
		int hours = Integer.parseInt(leavingTime[0]); // Converting String into int using Integer.parseInt()
		int minutes = Integer.parseInt(leavingTime[1]);

		// params for newIntermediateStation
		IntermediateStation newIntermediateStation = new IntermediateStation();

		in.nextLine(); // clean buffer

		System.out.println("Enter destination station");
		String destinationStation = in.nextLine();
		int cnt = 0;

		// input intermediate station
		do {
			if (cnt == 0) {
				System.out.println("Do this travel have intermediate station? 1 for yes, 0 for no");
			} else if (cnt <= 3) {
				System.out.println("Do this travel have more intermediate station? 1 for yes, 0 for no");
			}
			flag = in.nextInt();

			if (flag == 0) {
				break;
			} else {
				cnt++;
				if (cnt <= 3) { // for avoiding travels that contain over then 3 intermediate stations.
					in.nextLine(); // clean buffer
					System.out.println("Enter intermediate station:");
					String intermediateStation = in.nextLine();

					System.out.println("Enter intermediate station leaving time (hours and minutes) in format xx:xx");
					String[] intermediateLeavingTime = in.next().split(":");
					int intermediateHours = Integer.parseInt(intermediateLeavingTime[0]); // Converting String into
																							// integer using
																							// Integer.parseInt()
					int intermediateMinutes = Integer.parseInt(intermediateLeavingTime[1]);

					LeavingTime newLeavingTime = new LeavingTime(intermediateHours, intermediateMinutes);

					newIntermediateStation.setIntermediateStation(intermediateStation);
					newIntermediateStation.setTime(newLeavingTime);
					// newIntermediateStation = new IntermediateStation(intermediateStation,
					// intermediateHours, intermediateMinutes);

					// intermadiateStations.add(newIntermediateStation); //why i cant add
					// newIntermediateStation

				}
			}

		} while ((flag == 0 || flag == 1) && (cnt <= 3));

		Travel newTravel = new Travel(startingStation, destinationStation, newIntermediateStation, hours, minutes);

		allTravels.add(newTravel);

	}

}
