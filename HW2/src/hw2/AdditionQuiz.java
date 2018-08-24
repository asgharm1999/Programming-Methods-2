package hw2;

import java.util.Scanner;

public class AdditionQuiz {
	
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
