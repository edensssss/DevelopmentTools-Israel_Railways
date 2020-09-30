package trainSchedule;

import java.io.Serializable;
import java.util.InputMismatchException;

//Immutable objects, checking input while constructing
public class LeavingTime implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	public static final LeavingTime MAX_TIME =
//			new LeavingTime(23,59,Integer.MAX_VALUE,6,23,59);
	
//	public static final LeavingTime MIN_DATE =
//			new LeavingTime(1,1,Integer.MIN_VALUE,0,0,0);
	
//	private int day;
//	private int month;
//	private int year;
//	private int dayOfWeek; // 0 = Sunday
	
	private int hour; //00 to 23
	private int minute;
	
	public LeavingTime(int hour, int minute) throws InputMismatchException {
		super();
		if(hour<0 || hour > 23)
			throw new InputMismatchException("Invalid hour");
		this.hour = hour;
		if(minute<0 || minute > 59)
			throw new InputMismatchException("Invalid minute");
		this.minute = minute;
	}
	
	public int gethour() {
		return hour;
	}
	public int getminute() {
		return minute;
	}

	
	public boolean before(LeavingTime other) {
		if(this.hour<other.hour)
			return true;
		if(this.hour==other.hour) {
			if(this.minute<other.minute)
				return true;
			if(this.minute == other.minute) {
					return true;
			}
		}
		return false;
	}
	
	public boolean after(LeavingTime other) {
		if(this.hour>other.hour)
			return true;
		if(this.hour==other.hour) {
			if(this.minute>other.minute)
				return true;
			if(this.minute == other.minute) {
					return true;
			}
		}
		return false;
	}
	
	/*
	 * public String toDateString() { return day + "/" + month + "/" + year; }
	 */
	
	public String toHourString() {
		StringBuilder s = new StringBuilder();
		if(hour < 10)
			s.append(0);
		s.append(this.hour);
		s.append(":");
		if(minute < 10)
			s.append(0);
		s.append(this.minute);
		return s.toString();
	}
	
	public String toString() {
		return toHourString();
	}
	
	/*
	 * public String toDayOfWeekString() { switch(dayOfWeek) { case 0: return
	 * "Sunday"; case 1: return "Monday"; case 2: return "Tuesday"; case 3: return
	 * "Wednesday"; case 4: return "Thursday"; case 5: return "Friday"; case 6:
	 * return "Saturday"; } return "Sunday"; }
	 */	
	public int compareTo(LeavingTime other) {
		return ((other.hour-this.hour)*60) + ((other.minute-this.minute)*60) + other.minute - this.minute; 
	}
	
}
