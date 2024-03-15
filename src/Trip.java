/**
 * Stores information and methods needed for taking a trip on an elevator.
 */


public class Trip {
	public int start_floor;			//the start floor
	public int[] stops;				//list of floors
	
	public Trip() {					//default constructor starts on the first floor
		super();
		this.start_floor = 1;
	}	
	
	public Trip(int start_floor, int[] stops) {  	//constructor to set instance variables
		super();
		this.start_floor = start_floor;
		this.stops = stops;
	}
	
	public int take_trip(Elevator elevator) {		//returns the time it took to take a trip for a given elevator
		int total = 0;
		
		if(elevator.getFloor() != start_floor) {	//check that the elevator starts on the correct floor
			elevator.setFloor(start_floor);
		}
		
		for(int stop : stops) {						//for each stop, add to the total time and return
			total = total + elevator.change_floor(stop);
		}
		return total;
	}
	
	//getters and setters
	public void setStops(int[] stops) {
		this.stops = stops;
	}

	public void setStart_floor(int start_floor) {
		this.start_floor = start_floor;
	}
}
