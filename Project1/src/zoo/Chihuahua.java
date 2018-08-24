package zoo;

public class Chihuahua extends Dog {

	public Chihuahua() {
		// TODO Auto-generated constructor stub
	}

	public Chihuahua(boolean hasTail, String faveFood) {
		super(hasTail, faveFood);
	}

	public Chihuahua(double weight, int age, char gender, boolean hasLegs, 
			boolean hasTail, String faveFood, String[] theTricks) {
		super(weight, age, gender, hasLegs, hasTail, faveFood, theTricks);
	}
	
	public Chihuahua(double weight, int age, char gender, boolean hasLegs, 
			boolean hasTail, String faveFood) {
		super(weight, age, gender, hasLegs, hasTail, faveFood);
	}

	public String toString() {
		return super.toString()+"\n\tTThis dog is a chihuahua";
	}
	
	@Override
	public void move() {
		System.out.println("I run fast!");
	}

	@Override
	public void eat() {
		System.out.println("Anything");
	}

	@Override
	public void speak() {
		System.out.print("Does a startle, ");
	}

	@Override
	public void speak(int numTimes) {
		for(int i = numTimes; i > 0; i--){
			speak();
		}
	}
}
