package hw2;

public class RollFor2 {
    
    public static void main(String[] args) {
       
       PairOfDice dice;  
       int rollCount = 0;    
 
       dice = new PairOfDice();  // create the PairOfDice object
       
       do {
           dice.roll();
           System.out.println("The dice come up " + dice );
           rollCount++;
       } while(dice.getTotal() != 2);
       
       System.out.println("\nIt took " + rollCount + " rolls to get a 2.");
    }
}