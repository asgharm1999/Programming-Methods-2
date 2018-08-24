/**
 * 
 * @author Muhammad Asghar
 * CMP 326 HW 1
 * Chapter 4: 1, 2, 3, 4, 7
 * 
 */

package hw1;

import java.util.Scanner;

public class HW1Chapter4 {

	// 4.4
	public static final int NUMBER_OF_EXPERIMENTS = 10000;

	public static void main(String[] args) {

		// 4.1
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter a line of text.");
		String line = keyboard.nextLine();
		System.out.print("The capitalized version is: ");
		printCapitalized(line);

		// 4.2
		long dec = 0; // for base-10        
		System.out.print("Enter a hexadecimal number: ");
		String hex = keyboard.nextLine();

		for(int i = 0; i < hex.length(); i++) {
			int digit = hexValue(hex.charAt(i));
			if(digit == -1) {
				System.out.println("Error:  Input is not a hexadecimal number.");
				return;
			}
			dec = 16 * dec + digit;
		}
		System.out.println("Base-10 value:  " + dec);

		// 4.3
		int numberOfRolls = rollFor3(2);  // number of rolls to get a 2
		System.out.println("It took " + numberOfRolls + " rolls to get snake eyes.");

		// 4.4
		double average;  // the average number of rolls to get a given total
		System.out.println("Total On Dice     Average Number of Rolls");
		System.out.println("-------------     -----------------------");

		for(int dice = 2; dice <= 12; dice++) {
			average = getAverageRollCount(dice);
			System.out.printf("%10d%22.4f\n", dice, average);
			// use 10 spaces to output dice, and use 22 spaces to output
			// average, with 4 digits after the decimal
		}

		// 4.7
		int[] firstNums = new int[10];  // the first numbers in the ten problems
		int[] secondNums = new int[10]; // the second numbers in the ten problems
		int[] answers = new int[10];    // the user's answers

		System.out.println("Welcome to the addition quiz!");

		createQuiz(firstNums,secondNums);
		administerQuiz(firstNums,secondNums,answers);
		gradeQuiz(firstNums,secondNums,answers);
	}    

	// 4.1
	static void printCapitalized(String s1) {

		char prevCh;         
		prevCh = '.'; // if user enters a period at end, there is no way to capitalize it

		for(int i = 0; i < s1.length(); i++) {
			char ch = s1.charAt(i);
			if(Character.isLetter(ch) && !Character.isLetter(prevCh)) {
				System.out.print(Character.toUpperCase(ch));
			} else {
				System.out.print(ch);
				prevCh = ch;
			}
		}
		System.out.println();
	}

	// 4.2
	public static int hexValue(char ch) {
		switch (ch) {
		case '0':
			return 0;
		case '1':
			return 1;
		case '2':
			return 2;
		case '3':
			return 3;
		case '4':
			return 4;
		case '5':
			return 5;
		case '6':
			return 6;
		case '7':
			return 7;
		case '8':
			return 8;
		case '9':
			return 9;
		case 'a':     
		case 'A':
			return 10;
		case 'b':
		case 'B':
			return 11;
		case 'c':
		case 'C':
			return 12;
		case 'd':
		case 'D':
			return 13;
		case 'e':
		case 'E':
			return 14;
		case 'f':
		case 'F':
			return 15;
		default:
			return -1;
		}
	}  

	// 4.3
	public static int rollFor3(int n) {
		if(n < 2 || n > 12) {
			throw new IllegalArgumentException("Impossible total for a pair of dice.");
		}

		int die1;
		int die2;
		int roll;    
		int rollCount = 0;  

		do {
			die1 = (int)(Math.random()*6) + 1;
			die2 = (int)(Math.random()*6) + 1;
			roll = die1 + die2;
			rollCount++;
		} while(roll != n);
		return rollCount;
	}

	// 4.4
	public static double getAverageRollCount(int roll) {
		int rollCountThisExperiment;  // number of rolls in one experiment
		int rollTotal = 0;  // total number of rolls in all the experiments
		double averageRollCount;  // average number of rolls per experiment

		for(int i = 0; i < NUMBER_OF_EXPERIMENTS; i++) {
			rollCountThisExperiment = rollFor4(roll);
			rollTotal += rollCountThisExperiment;
		}
		averageRollCount = ((double)rollTotal) / NUMBER_OF_EXPERIMENTS;
		return averageRollCount;
	}

	public static int rollFor4(int n) {
		if (n < 2 || n > 12) {
			throw new IllegalArgumentException("Impossible total for a pair of dice.");
		}

		int die1;
		int die2; 
		int roll;        
		int rollCount = 0;	 // number of rolls made

		do {
			die1 = (int)(Math.random()*6) + 1;
			die2 = (int)(Math.random()*6) + 1;
			roll = die1 + die2;
			rollCount++;
		} while(roll != n);
		return rollCount;
	}

	// 4.7
	private static void createQuiz(int[] firstNumbers, int[] secondNumbers) {
		for(int i = 0; i < 10; i++) {
			firstNumbers[i] = (int)(Math.random() * 50 + 1);  // in the range 1 to 50
			secondNumbers[i] = (int)(Math.random() * 50); // in the range 0 to 49
		}
	}

	private static void administerQuiz(int[] firstNumbers, int[] secondNumbers, int[] userAnswers) {

		Scanner keyboard = new Scanner(System.in);

		for(int i = 0; i < 10; i++) {
			int questionNum = i + 1;
			System.out.printf("Question %2d:  What is %2d + %2d  ? ",
					questionNum, firstNumbers[i], secondNumbers[i]);
			userAnswers[i] = keyboard.nextInt();	
		}
	}	

	private static void gradeQuiz(int[] firstNumbers, int[] secondNumbers, int[] userAnswers) {

		System.out.println("Here are the correct answers: ");
		int numberCorrect = 0;
		int grade;

		for(int i = 0; i < 10; i++) {
			int questionNum = i + 1;
			int correctAnswer = firstNumbers[i] + secondNumbers[i];
			System.out.printf("   Question %2d:  %2d + %2d  =  %2d.  ",
					questionNum, firstNumbers[i], secondNumbers[i], correctAnswer);
			if(userAnswers[i] == correctAnswer) {
				System.out.println("You were CORRECT.");
				numberCorrect++;
			}
			else {
				System.out.println("You said " + userAnswers[i] + ", which is INCORRECT.");
			}
		}

		grade = numberCorrect * 10;
		System.out.println("You got " + numberCorrect + " questions correct.");
		System.out.println("Your grade on the quiz is " + grade);
	}
}