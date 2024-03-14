
public class Elevator {
	public int floor;				//current floor the elevator is on
	public final int RATE = 10;		//constant time it takes to change 1 floor
	
	public Elevator() {				//default elevator starts on the first floor
		super();
		this.floor = 1;
	}
	
	public Elevator(int floor) {	//constructor that sets floor
		super();
		this.floor = floor;
	}
	
	public int change_floor(int destination) { //returns the time it took to get to the given floor and updates floor
		int time = (Math.abs(floor - destination))*RATE;
		floor = destination;
		return time;
	}

	//getters and setters
	public int getFloor() {
		return floor;
	}
	
	public void setFloor(int floor) {
		this.floor = floor;
	}
}
