package hw2;

import java.util.Scanner;

public class AdditionQuizWithObjects {
    
    private static AdditionQuizDriver[] questions;  
    private static int[] userAnswers;   
    
    public static void main(String[] args) {
        System.out.println("Welcome to the addition quiz!");
        createQuiz();
        administerQuiz();
        gradeQuiz();
    }
    
    private static void createQuiz() {
        questions = new AdditionQuizDriver[10];
        for(int i = 0; i < 10; i++) {
            questions[i] = new AdditionQuizDriver();
        }
    }
      
    private static void administerQuiz() {
    	
    	Scanner keyboard = new Scanner(System.in);
    	
        userAnswers = new int[10];
        for(int i = 0; i < 10; i++) {
            int questionNum = i + 1;
            System.out.printf("Question %2d:  %s ",
                                  questionNum, questions[i].getQuestion());
            userAnswers[i] = keyboard.nextInt();
        }
    }
    
    private static void gradeQuiz() {
    	System.out.println();
        System.out.println("Here are the correct answers:");
        int numberCorrect = 0;
        int grade;
        for(int i = 0; i < 10; i++) {
            int questionNum = i + 1;
            System.out.printf("   Question %2d:  %s  Correct answer is %d  ",
                questionNum, questions[i].getQuestion(), questions[i].getCorrectAnswer());
            if ( userAnswers[i] == questions[i].getCorrectAnswer() ) {
                System.out.println("You were CORRECT.");
                numberCorrect++;
            } else {
                System.out.println("You said " + userAnswers[i] + ", which is INCORRECT.");
            }
        }
        
        grade = numberCorrect * 10;
        System.out.println();
        System.out.println("You got " + numberCorrect + " questions correct.");
        System.out.println("Your grade on the quiz is " + grade);
        System.out.println();
    }

}
