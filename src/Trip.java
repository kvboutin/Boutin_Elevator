import java.util.ArrayList;

public class Trip {
	public int start_floor;
	public int[] stops;
	
	public Trip() {
		super();
		this.start_floor = 0;
	}	
	
	public Trip(int start_floor, int[] stops) {
		super();
		this.start_floor = start_floor;
		this.stops = stops;
	}
	
	public void setStops(int[] stops) {
		this.stops = stops;
	}

	public int take_trip(Elevator elevator) {
		return 0;
	}
	
}
