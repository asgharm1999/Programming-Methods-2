package hw2;

public class AdditionQuizDriver {

	public static void main(String[] args) {
		
		int[] firstNums = new int[10];  // the first numbers in the ten problems
		int[] secondNums = new int[10]; // the second numbers in the ten problems
		int[] answers = new int[10];    // the user's answers

		System.out.println("Welcome to the addition quiz!");

		createQuiz(firstNums,secondNums);
		administerQuiz(firstNums,secondNums,answers);
		gradeQuiz(firstNums,secondNums,answers);
	}
}
