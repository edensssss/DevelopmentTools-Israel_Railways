package Model;

import java.util.ArrayList;

import trainSchedule.IntermediateStation;
import trainSchedule.LeavingTime;

public class Travel {

	private String startingStation;
	private String destinationStatin;
	private LeavingTime time;
	private ArrayList<IntermediateStation> intermadiateStations = null;
	private IntermediateStation intermadiateStation;
	
	
	public Travel(String startingStation, String destinationStatin, IntermediateStation intermediateStation, int hour, int minute) {
		super();
		this.startingStation = startingStation;
		this.destinationStatin = destinationStatin;
		this.time = new LeavingTime(hour, minute);
		this.intermadiateStation = intermediateStation;
	}
	
	
//	public Travel(String startingStation, String destinationStatin, ArrayList<IntermediateStation> intermediateStations, int hour, int minute) {
//		super();
//		this.startingStation = startingStation;
//		this.destinationStatin = destinationStatin;
//		this.time = new LeavingTime(hour, minute);
//		this.intermadiateStations = intermediateStations;
//	}

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
		if(intermadiateStations == null) {
			return "Travel from " + startingStation + " to " + destinationStatin
					 +", on " + time.toString() + "\n" ;
		}
		else {
			return "Travel from " + startingStation + " to " + destinationStatin
				 +", on " + time.toString() + " through " + intermadiateStations + "\n" ;
		}
		
	}
	
	
}
