package zoo;

public class Pigeon extends Bird {

	public Pigeon() {
		super();
	}

	public Pigeon(boolean hasBeak, double beakLength, boolean canFly) {
		super(hasBeak, beakLength, canFly);
		
	}

	public Pigeon(double weight, int age, char gender, boolean hasLegs, boolean hasBeak,
			double beakLength, boolean canFly) {
		super(weight, age, gender, hasLegs, hasBeak, beakLength, canFly);
	}
	
	public String toString(){
		return super.toString()+"\n\tTThis bird is a pigeon";
	}
	
	@Override
	public void move() {
		System.out.println("I only act pretentious in urban areas");
	}

	@Override
	public void eat() {
		System.out.println("You");
	}

	@Override
	public void speak() {
		System.out.print("Coo roo, ");
	}

	@Override
	public void speak(int numTimes) {
		for(int i = numTimes; i > 0; i--){
			speak();
		}
	}
}
