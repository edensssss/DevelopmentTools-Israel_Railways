package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;



public class AllTravels implements Comparator<Travel> {

	private ArrayList<Travel> allTravels = new ArrayList<>();

	public AllTravels() {
		super();
	
	}
	
	public void addTravel(Travel newTravel) {
		if (newTravel == null)
			return;
		else
			allTravels.add(newTravel);
			return;
	}
	
	
	public void sortTravelsByTime() {
		Collections.sort(allTravels, new SortByTime());
	}



	public ArrayList<Travel> getAllTravels() {
		return allTravels;
	}

	@Override
	public int compare(Travel o1, Travel o2) {
		return ((Travel) o1).getLeavingTime().compareTo(((Travel) o2).getLeavingTime());
	}

	@Override
	public String toString() {
			for (Travel t : allTravels) {
				System.out.println(t);
			}
		return " ";
	}

}
