package Model;

import trainSchedule.IntermediateStations;
import trainSchedule.LeavingTime;

public class Travel {

	private String startingStation;
	private String destinationStatin;
	private LeavingTime time;
	private IntermediateStations intermediateStations;
	
	
	public Travel(String startingStation, String destinationStatin, int hour, int minute, IntermediateStations intermadiateStations) {
		super();
		this.startingStation = startingStation;
		this.destinationStatin = destinationStatin;
		this.time = new LeavingTime(hour, minute);
		this.intermediateStations = intermadiateStations;
	}
	
	


	public void setIntermadiateStations(IntermediateStations intermadiateStations) {
		this.intermediateStations = intermadiateStations;
	}
	


	
	

	
	
//	public Travel(String startingStation, String destinationStatin, ArrayList<IntermediateStation> intermediateStations, int hour, int minute) {
//		super();
//		this.startingStation = startingStation;
//		this.destinationStatin = destinationStatin;
//		this.time = new LeavingTime(hour, minute);
//		this.intermadiateStations = intermediateStations;
//	}

	public String getStartingStation() {
		return startingStation;
	}




	public void setStartingStation(String startingStation) {
		this.startingStation = startingStation;
	}




	public String getDestinationStatin() {
		return destinationStatin;
	}




	public void setDestinationStatin(String destinationStatin) {
		this.destinationStatin = destinationStatin;
	}




	public LeavingTime getTime() {
		return time;
	}




	public void setTime(LeavingTime time) {
		this.time = time;
	}




	public IntermediateStations getIntermediateStations() {
		return intermediateStations;
	}




	public void setIntermediateStations(IntermediateStations intermediateStations) {
		this.intermediateStations = intermediateStations;
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
		if(intermediateStations.getNumOfStations() == 0) {
			return "Travel from " + startingStation + " to " + destinationStatin
					 +", on " + time.toString() + "\n" ;
		}
		else {
			System.out.print("Travel from " + startingStation + " to " + destinationStatin
					 +", on " + time.toString() + " through ");
			System.out.println(intermediateStations);
			
		}
		return "";
		
	}
	
	
}
