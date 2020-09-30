package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;



public class AllTravels implements Comparator<Travel> {

	private ArrayList<Travel> allTravels;

	public AllTravels() {
		super();
	
	}
	
	public boolean addTravel(Travel newTravel) {
		if (newTravel == null)
			return false;
		else
			allTravels.add(newTravel);
		return true;
	}
	
	
	public void sortTravelsByTime() {
		Collections.sort(allTravels, new SortByTime());
	}



	@Override
	public int compare(Travel o1, Travel o2) {
		return ((Travel) o1).getLeavingTime().compareTo(((Travel) o2).getLeavingTime());
	}

}
