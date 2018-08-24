package hw2;
import java.util.Scanner;

public class SimpleStats {

  public static void main(String[] args) {

     Scanner keyboard = new Scanner(System.in);

     StatCalc calc = new StatCalc();

     double item; 

     System.out.println("Enter your numbers. Enter 0 to end.");

     do {
        System.out.print("? ");
        item = keyboard.nextDouble();
        if(item != 0) {
           calc.enter(item);
        }
     } while (item != 0);

     System.out.println("\nStatistics about your calc:\n");
     System.out.println("   Count:              " + calc.getCount());
     System.out.println("   Sum:                " + calc.getSum());
     System.out.println("   Minimum:            " + calc.getMin());
     System.out.println("   Maximum:            " + calc.getMax());
     System.out.println("   Average:            " + calc.getMean());
     System.out.println("   Standard Deviation: "
            + calc.getStandardDeviation());
  }
}
