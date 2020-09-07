package trainSchedule;

import java.util.Comparator;

import Model.Travel;

public class SortByTime implements Comparator<Object> {

	@Override
	public int compare(Object o1, Object o2) {
		return ((Travel) o1).getLeavingTime().compareTo(((Travel) o2).getLeavingTime());
	}

}


