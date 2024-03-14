import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Control {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please enter the floor you are starting on: ");
		int start = 0;
		try {
			start = input.nextInt();
		} catch (InputMismatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.print("Please enter how many floors will this trip will have: ");
		//add error catching
		int size = 0;
		size = input.nextInt();
		
		System.out.println("Please enter the numbers of the floors you will be visiting in order: ");
		
		int visits[] = new int[size + 1];
		visits[0] = start;
		int floor = 0;
		for(int i = 0; i < size; i++) {
			floor = input.nextInt();
			visits[i+1] = floor;	
		}
		
		Trip test = new Trip(start, visits);
		Elevator elevator1 = new Elevator();
		
		System.out.println("The time the trip took is: " + test.take_trip(elevator1));
		System.out.println("The floors vistied in order are: " + Arrays.toString(visits));
	}

}
