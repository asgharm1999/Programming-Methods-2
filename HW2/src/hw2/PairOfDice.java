package hw2;

public class PairOfDice {
    
    private int die1;   
    private int die2;   

    public PairOfDice() {
        roll();  
    }
    
    public void roll() {
        die1 = (int)(Math.random()*6) + 1; // not inclusive, so have to add + 1; from 1-6, no zero
        die2 = (int)(Math.random()*6) + 1;
    }
    
    public int getDie1() {
       return die1;
    }
    
    public void setDie1(int value) {
       if(value < 1 || value > 6) {
          throw new IllegalArgumentException("Illegal dice value " + value);
       }
       die1 = value;
    }
    
    public int getDie2() {
       return die2;
    }
    
    public void setDie2(int value) {
       if(value < 1 || value > 6) {
          throw new IllegalArgumentException("Illegal dice value " + value);
       }
       die2 = value;
    }
    
    public int getTotal() {
       return die1 + die2;
    }
    
    public String toString() {
       if(die1 == die2) {
          return "double " + die1;
       } else {
          return die1 + " and " + die2;
       }
    }    
}  