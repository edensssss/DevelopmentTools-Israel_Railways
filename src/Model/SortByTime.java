package Model;

import java.util.Comparator;

public class SortByTime implements Comparator<Travel> {


	@Override
	public int compare(Travel o1, Travel o2) {
		// TODO Auto-generated method stub
		return ((Travel) o1).getLeavingTime().compareTo(((Travel) o2).getLeavingTime());
	}

}
