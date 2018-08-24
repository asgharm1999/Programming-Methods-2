package zoo;

public class ShibaInu extends Dog {

	public ShibaInu() {
		// TODO Auto-generated constructor stub
	}

	public ShibaInu(boolean hasTail, String faveFood) {
		super(hasTail, faveFood);
		// TODO Auto-generated constructor stub
	}

	public ShibaInu(double weight, int age, char gender, boolean hasLegs, boolean hasTail, 
			String faveFood) {
		super(weight, age, gender, hasLegs, hasTail, faveFood);
		// TODO Auto-generated constructor stub
	}
	
	public ShibaInu(double weight, int age, char gender, boolean hasLegs, boolean hasTail, 
			String faveFood, String[] theTricks) {
		super(weight, age, gender, hasLegs, hasTail, faveFood, theTricks);
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return super.toString()+"\n\tTThis is a Shiba Inu";
	}
	
	@Override
	public void move() {
		System.out.println("I run slow!");
	}

	@Override
	public void eat() {
		System.out.println("This shiba inu likes to run at its food");	
	}

	@Override
	public void speak() {
		System.out.println("Bork");
	}

	@Override
	public void speak(int numTimes) {
		for(int i=numTimes; i > 0; i--){
			speak();
		}
	}
}
