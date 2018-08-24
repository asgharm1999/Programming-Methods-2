/**
 * 
 * @author Muhammad Asghar
 * CMP 326 HW 1
 * Chapter 3: 1, 2, 3, 4, 6
 * 
 */

package hw1;

import java.util.Scanner;

public class HW1Chapter3 {

	public static void main(String[] args) {

		// 3.1
		int die1, die2; 
		int countRolls = 0;

		do {
			die1 = (int)(Math.random()*6) + 1;
			die2 = (int)(Math.random()*6) + 1;
			countRolls++;                      
		} while(die1 != 1 || die2 != 1);

		System.out.println("It took " + countRolls + " rolls to get snake eyes");

		// 3.2
		int n;            
		int maxDivisors = 1;  
		int numWithMax = 1;

		for(n = 2; n <= 10000; n++) {
			int d;  // a number to be tested to see if it's a divisor of n
			int divisorCount = 0;  // number of divisors of n

			for(d = 1; d <= n; d++) {  // count the divisors of n
				if(n % d == 0) {
					divisorCount++;
				}
				if(divisorCount > maxDivisors) {
					maxDivisors = divisorCount;
					numWithMax = n;
				}
			}
		}

		System.out.println("Among integers between 1 and 10000, the maximum "
				+ "number of divisors is " + maxDivisors + " a number with " 
				+ maxDivisors + " divisors is " + numWithMax);

		// 3.3
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Enter an expression you would like solved. To exit, type 0");
		String expression = keyboard.nextLine();
		String[] words = expression.split("\\s+");

		for(int i = 0; i < words.length; i++) {  // split up into array by words 
			words[i] = words[i].replaceAll("[^\\w]", "");
		}

		int first = Integer.parseInt(words[0]);  // converts string into int
		int second = Integer.parseInt(words[2]);

		if(expression.charAt(0) == 0) {
			System.exit(0);
		} else if(words[1] == "+") {
			System.out.println(first + second);
		} else if(words[1] == "-") {
			System.out.println(first - second);
		} else if(words[1] == "/") {
			System.out.println(first / second);
		} else if(words[1] == "*") {
			System.out.println(first * second);
		}

		// 3.4
		System.out.println("Enter a sentence");
		String sent = keyboard.nextLine();
		String[] wordSent = expression.split("\\s+");

		for (int i = 0; i < wordSent.length; i++) {   	// split up into array by words
			wordSent[i] = wordSent[i].replaceAll("[^\\w]", "");
			System.out.print(wordSent[i]);
		}

		// 3.6
		int x; // numerator
		int maxDivisorsNew = 1;
		int[] saveCount;  // store the number of divisors for each number
		saveCount = new int[10001];
		maxDivisors = 1;  // start with the fact that 1 has 1 divisor
		saveCount[1] = 1;

		for (x = 2; x <= 10000; x++) {
			int y; // denominator
			int divisorCountNew = 0;
			for(y = 1; y <= x; y++) {  // count the divisors of x
				if(x % y == 0)
					divisorCountNew++;
			}

			saveCount[x] = divisorCountNew;  // record the count for x in the array

			if(divisorCountNew > maxDivisorsNew) {
				maxDivisorsNew = divisorCountNew;
			}
		}

		System.out.println("Among integers between 1 and 10000, the maximum "
				+ "number of divisors was " + maxDivisorsNew + "numbers with "
				+ "that many divisors include: ");
		for(x = 1; x <= 10000; x++ ) {
			if(saveCount[x] == maxDivisorsNew) {
				System.out.println("   " + x);
			}
		}
	}
}