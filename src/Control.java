/**
 * Control contains main, manages I/O and stores the elevator and trip objects.
 */

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Control {
	public Scanner input = new Scanner(System.in); //variables needed for I/O
	public boolean checkIn;						   //used to check for correct input type	
	public int start;
	public int size;
	public int visits[];

	public void getUserStart() {				   //Get a start floor from the user
		System.out.print("Please enter the floor you are starting on: ");			

		while(!checkIn) {
			try {
				start = input.nextInt();
				checkIn = true;
			} catch (InputMismatchException e) {
				System.out.print("Enter an integer: ");
				input.next();
			}
		}
		checkIn = false;
	}

	public void getUserVisits() {				  //Populate the list of floors that will be visited
		System.out.print("Please enter how many floors will this trip will have: "); //Need the size for the array

		while(!checkIn) {
			try {
				this.size = input.nextInt();
				checkIn = true;
			} catch (InputMismatchException e) {
				System.out.print("Enter an integer: ");
				input.next();
			}
		}

		System.out.println("Please enter the numbers of the floors you will be visiting in order: ");

		this.visits = new int[this.size + 1];			//Initialize and populate the visits array
		visits[0] = start;
		checkIn = false;
		int floor = 0;
		for(int i = 1; i < this.size + 1; i++) {
			while(!checkIn) {
				try {
					floor = input.nextInt();
					checkIn = true;
				} catch (Exception e) {
					System.out.print("Enter an integer: ");
					input.next();
				}
			}
			visits[i] = floor;	
			checkIn = false;
		}
	}
	
	public void tests() {
		Elevator testElevator = new Elevator();
		Trip test = new Trip();
		
		System.out.println("Running Tests");
		//Test 1: No change
		test.setStart_floor(1);
		test.setStops(new int[] {1, 1});
		System.out.println("Expected value: 0, Result: " + test.take_trip(testElevator));
		
		//Test 2: Simple
		test.setStart_floor(1);
		test.setStops(new int[] {1, 2, 3, 4});
		System.out.println("Expected value: 30, Result: " + test.take_trip(testElevator));
		
		//Test 3: Different starting floor
		test.setStart_floor(5);
		test.setStops(new int [] {5, 2, 3, 4});
		System.out.println("Expected value: 50, Result: " + test.take_trip(testElevator));
		
		//Test 4: Long Trip
		test.setStart_floor(3);
		test.setStops(new int [] {3, 5, 24, 5, 7, 18, 1});
		System.out.println("Expected value: 700, Result: " + test.take_trip(testElevator));
		
	}

	public static void main(String[] args) {	//Store objects and call methods
		Control control = new Control();

		control.getUserStart();
		control.getUserVisits();

		Trip trip = new Trip(control.start, control.visits);
		Elevator elevator = new Elevator();

		System.out.println("Time and floors visited: " + trip.take_trip(elevator) + ", " + Arrays.toString(control.visits));
		
		control.tests();
	}

}
