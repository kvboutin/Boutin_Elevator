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

	public static void main(String[] args) {	//Store objects and call methods
		Control control = new Control();

		control.getUserStart();
		control.getUserVisits();

		Trip test = new Trip(control.start, control.visits);
		Elevator elevator1 = new Elevator();

		System.out.println("Time and floors visited: " + test.take_trip(elevator1) + ", " + Arrays.toString(control.visits));
	}

}
