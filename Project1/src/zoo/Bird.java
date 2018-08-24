package zoo;

public class Bird extends Animal {

	private boolean hasBeak;
	private double beakLength;
	private boolean canFly;
	
	public Bird() {
		super();
		canFly = true;
		beakLength = 0;
	}
	
	public Bird(boolean hasBeak, double beakLength, boolean canFly) {
		super();
		this.beakLength = beakLength;
		this.beakLength = beakLength;
		this.canFly = canFly;
	}

	public Bird(double weight, int age, char gender, boolean hasLegs, boolean hasBeak, 
			double beakLength, boolean canFly) {
		super(weight, age, gender, hasLegs);
		this.beakLength = beakLength;
		this.beakLength = beakLength;
		this.canFly = canFly;
	}
	
	// getters
	public boolean getHasBeak() {
		return hasBeak;
	}
	
	public double getBeakLength() {
		return beakLength;
	}
	
	public boolean getCanFly() {
		return canFly;
	}
		
	// setters
	public void setHasBeak(boolean hasBeak) {
		this.hasBeak = hasBeak;
	}
	
	public void setBeakLength(double beakLength) {
		this.beakLength = beakLength;
	}
	
	public void setCanFly(boolean canFlyOrNot) {
		canFly = canFlyOrNot;
	}
	
	public String toString() {
		String s = super.toString();
		if(hasBeak) {
			s += "\n\tBird: has a beak";
		} else {
			s += "\n\tBird: does not have a beak";
		}
		s += ", Beak Length = " + beakLength;
	
		if(canFly) {
			s += "\n\tBird: can fly";
		} else {
			s += "\n\tBird: cannot fly";
		}
		return s;
	}
	
	public boolean equals(Object o) {
		if(o instanceof Bird) {
			Bird otherBird = (Bird)o;
			if(super.equals(otherBird)) {
				if(this.canFly == otherBird.canFly) {
					if(this.beakLength == otherBird.beakLength) {
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public void move() {
		System.out.println("birds fly away!");
	}

	@Override
	public void eat() {
		System.out.println("birds like food");
	}

	@Override
	public void speak() {
		System.out.println("cheep cheep");
	}

	@Override
	public void speak(int numTimes) {
		for(int i = numTimes; i > 0; i--){
			speak();
		}
	}
}
