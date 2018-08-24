package hw2;

import hw2.GeneralQuiz.IntQuestion;

public class GeneralQuizDriver {

	private static IntQuestion[] questions;  // The questions for the quiz
    private static int[] userAnswers;   // The user's answers to the ten questions.
    
    public static void main(String[] args) {
        System.out.println("Welcome to the quiz. There are some math questions "
        		+ "and a few non-math questions, but the answer to every question is"
        		+ "an integer.");
        createQuiz();
        administerQuiz();
        gradeQuiz();
    }
    
    private static void createQuiz() {
    	questions = new IntQuestion[10];
        for(int i = 0; i < 7; i++) {
            if (Math.random() < 0.5) {
	            questions[i] = new AdditionQuestion();
            } else {
	            questions[i] = new SubtractionQuestion();
            }
        }
        questions[7] = new IntQuestion() {
              public String getQuestion() {
                  return "How many states are there in the United States?";
              }
              public int getCorrectAnswer() {
                  return 50;
              }
        };
        questions[8] = new IntQuestion() {
              public String getQuestion() {
                  return "In what year did the First World War begin?";
              }
              public int getCorrectAnswer() {
                  return 1914;
              }
        };
        questions[9] = new IntQuestion() {
              public String getQuestion() {
                  return "What is the answer to the ultimate question " +
                                "of life, the universe, and everything?";
              }
              public int getCorrectAnswer() {
                  return 42;
              }
        };
   }        
    
    
    private static void administerQuiz() {
        userAnswers = new int[10];
        for(int i = 0; i < 10; i++) {
            int questionNum = i + 1;
            System.out.printf("Question %2d:  %s ",
                                  questionNum, questions[i].getQuestion());
            userAnswers[i] = TextIO.getlnInt();
        }
    }
    
    
    private static void gradeQuiz() {
    	System.out.println("Here are the correct answers:");
        int numberCorrect = 0;
        int grade;
        for(int i = 0; i < 10; i++) {
            System.out.println("Question number " + (i+1) + ":");
            System.out.println("    " + questions[i].getQuestion());
            System.out.println("    Correct answer:  " + questions[i].getCorrectAnswer());
            if ( userAnswers[i] == questions[i].getCorrectAnswer() ) {
                System.out.println("    You were CORRECT.");
                numberCorrect++;
            } else {
                System.out.println("    You said " + userAnswers[i] + ", which is INCORRECT.");
            }
            System.out.println();
        }
        grade = numberCorrect * 10;
        System.out.println();
        System.out.println("You got " + numberCorrect + " questions correct.");
        System.out.println("Your grade on the quiz is " + grade);
        System.out.println();
    }
} 
