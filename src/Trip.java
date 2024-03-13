import java.util.ArrayList;

public class Trip {
	public int start_floor;
	public ArrayList<Integer> stops = new ArrayList<Integer>();
	
	public Trip() {
		super();
		this.start_floor = 0;
	}	
	
	public Trip(int start_floor, ArrayList<Integer> stops) {
		super();
		this.start_floor = start_floor;
		this.stops = stops;
	}
	
	public int take_trip() {
		return 0;
	}
	
}
