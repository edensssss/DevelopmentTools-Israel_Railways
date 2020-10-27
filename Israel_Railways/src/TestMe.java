package Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;

import org.junit.jupiter.api.Test;

import Model.AllTravels;
import Model.SortByTime;
import Model.Travel;
import trainSchedule.IntermediateStations;

class TestFlightClasses {

	//Many more tests can be produced, more possible cases leads to better testability!
			
	@Test
	public void testAddingNewTravel() {
		Model.Travel testNewTravel = new Model.Travel("Tiberias", "Jarusalem", 10, 50, new IntermediateStations());
		String expectedOutput = "Travel from Tiberias to Jarusalem, on 10:50";
		assertEquals(expectedOutput, testNewTravel.toString());
	}

	@Test
	public void testSortByTime() {

		Model.AllTravels allTravels = new AllTravels();
		Model.Travel travel1 = new Model.Travel("Tiberias", "Jarusalem", 15, 07, new IntermediateStations());
		Model.Travel travel2 = new Model.Travel("Tiberias", "Jarusalem", 10, 15, new IntermediateStations());
		allTravels.addTravel(travel1);
		allTravels.addTravel(travel2);
		Collections.sort(allTravels.getAllTravels(), new SortByTime());

		String expectedOutput = "The travel of 10:15 should show first";
		assertEquals(expectedOutput, allTravels.toString());
	}

	@Test
	public void testCompareTravelTime() {
		Model.Travel testTravel = new Travel("Kinneret", "Death-Sea", 20, 59);		
		Flight testCompareFlightTime = new IncomingFlight("Test Airline", "TST101", "London", "England", "Heathrow",
				
		assertFalse(testTravel.equals(testCompareTravelTime));
		assertTrue(testTravel.compareTo(testCompareTravelTime) < 0);
	}


}
