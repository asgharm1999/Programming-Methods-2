/**
 * 
 * @author Muhammad Asghar
 * CMP 326 HW 1
 * Chapter 2: 2, 3, 4, 5, 6
 * 
 */

package hw1;

import java.util.Scanner;

public class HW1Chapter2 {

	public static void main(String[] args) {

		// 2.2
		int die1 = (int)(Math.random()*6) + 1;
		int die2 = (int)(Math.random()*6) + 1;
		int roll = die1 + die2;

		System.out.println("The first die comes up " + die1);
		System.out.println("The second die comes up " + die2);
		System.out.println("Your total roll is " + roll);

		// 2.3
		Scanner keyboard = new Scanner(System.in);
		System.out.println("What is your name?");
		String name = keyboard.nextLine();
		String upperName = name.toUpperCase();

		System.out.println("Hello, " + upperName + ", nice to meet you!");      

		// 2.4
		System.out.println("How many quarters do you have?");
		int quarters = keyboard.nextInt();
		System.out.println("How many dimes do you have?");
		int dimes = keyboard.nextInt();
		System.out.println("How many nickles do you have?");
		int nickles = keyboard.nextInt();
		System.out.println("How many pennies do you have?");
		int pennies = keyboard.nextInt();

		double total = (quarters * 0.25) + (dimes * 0.10) + (nickles * 0.05) + (pennies * 0.01);
		System.out.println("Your total amount of change is: " + total + " dollars");

		// 2.5
		System.out.println("How many eggs do you have?");
		int numEggs = keyboard.nextInt();
		int dozen = numEggs / 12;
		int leftover = numEggs % 2;
		int gross = numEggs / 144;	
		int aboveGross = numEggs % 144;
		int dozens = aboveGross / 12;
		int extras = aboveGross % 12;   

		if(numEggs >= 144) {
			System.out.println("You number of eggs is " + gross + " gross, " + dozens
					+ " dozen, and " + extras + " extras");
		} else {
			System.out.println("Your number of eggs is " + numEggs + " which is " + dozen + 
					" dozens, " + leftover + " extra eggs");
		}

		// 2.6
		System.out.println("Enter your full name: ");
		String fullName = keyboard.nextLine();

		String [] arrOfStr = fullName.split(" ", 2);
				
		String firstName = arrOfStr[0];
		String lastName = arrOfStr[1];

		System.out.println("Your first name is: " + firstName + " which has " +
				firstName.length() + " characters.");
		System.out.println("Your last name is: " + lastName + " which has " +
				lastName.length() + " characters.");
		System.out.println("Your initials are: " + firstName.charAt(0) + lastName.charAt(0));

	}
}
