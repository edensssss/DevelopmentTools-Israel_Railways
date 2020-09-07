package Model;

import trainSchedule.LeavingTime;

public class Travel {

	private String startingStation;
	private String destinationStatin;
	private LeavingTime time;
	
	public Travel(String startingStation, String destinationStatin, int hour, int minute) {
		super();
		this.startingStation = startingStation;
		this.destinationStatin = destinationStatin;
		this.time = new LeavingTime(hour, minute);
	}

	public String getLeavingTime() {
		return time.toString();
	}

	public String toStartingStationString() {
		return startingStation;
	}
	
	public String toDestinationStatinString() {
		return destinationStatin;
	}
	
	@Override
	public String toString() {
		return "Travel from " + startingStation + " to " + destinationStatin
				+ ", on " + time.toString() + "\n" ;
	}
	
	
}
