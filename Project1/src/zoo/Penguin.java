package zoo;

public class Penguin extends Bird {

	public Penguin() {
		super();
		super.setCanFly(false); //make sure the special Penguin Bird cannot fly
	}
	
	public Penguin(boolean hasBeak, double beakLength, boolean canFly) {
		super(hasBeak, beakLength, false); //cannot fly!!!! 
	}
	
	public Penguin(double weight, int age, char gender, boolean hasLegs, boolean hasBeak,
			double beakLength, boolean canFly) {
		super(weight, age, gender, hasLegs, hasBeak, beakLength, false); //cannot fly!!!! 
	}
	
	@Override
	public void setCanFly(boolean canFlyOrNot) {
		if(canFlyOrNot) {
			System.out.println("Penguins don't fly come on!");
		}
	}
	
	public String toString() {
		return super.toString()+"\n\tThis penguin is a bird";
	}
	
	@Override
	public void move() {
		System.out.println("I only wobble");
	}

	@Override
	public void eat() {
		System.out.println("I love fish!");
	}

	@Override
	public void speak() {
		System.out.print("Brr, Heeh, ");
	}

	@Override
	public void speak(int numTimes) {
		for(int i = numTimes; i > 0; i--){
			speak();
		}
	}
}