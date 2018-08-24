package zoo;

public class Dog extends Animal {
    private boolean hasTail;
    private String faveFood;
    private String[] tricks;
	private int totalNumOfTricks = 5;

    public Dog() {
    	super();
        hasTail = true;
        faveFood = " bones ";
    }

    public Dog(boolean hasTail, String faveFood) {
        super(); 
        this.hasTail = hasTail;
        this.faveFood = faveFood;
        this.tricks = new String[totalNumOfTricks];
    }
    
    public Dog(double weight, int age, char gender, boolean hasLegs, 
    		boolean hasTail, String faveFood) { 
		super(weight, age, gender, hasLegs); 
		this.hasTail = hasTail;
		this.faveFood = faveFood;
	}
    
    public Dog(double weight, int age, char gender, boolean hasLegs, 
    		boolean hasTail, String faveFood, String [] theTricks) { 
		super(weight, age, gender, hasLegs); 
		this.hasTail = hasLegs;
		this.faveFood = faveFood;
		this.tricks = theTricks;
		totalNumOfTricks = theTricks.length;
	}
   
    public String getTricks() { 
		String s = "";
		int i = 0;
		while(i < tricks.length - 1 && tricks[i] != null) {
			s += tricks[i] +", ";
			i++;
		}
		
		if(tricks[tricks.length - 1] != null) {
			s += tricks[i];
		}
		return s;
    }
    
    @Override
	public String toString() {
		String s = super.toString();
		if(hasTail) {
			s += "\n\tDog: has a tail";
		} else{
			s += "\n\tDog: does not have a tail";
		} 
		s += ", favorite food: " + faveFood;
		return s;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Dog) {
			Dog otherDog = (Dog)o;
			if(super.equals(otherDog)) {
				if(this.hasTail == otherDog.hasTail) {
					if(this.faveFood.equalsIgnoreCase(otherDog.faveFood)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	@Override
	public void move() {
		System.out.println("Dogs run away!");
	}

	@Override
	public void eat() {
		System.out.println("Dogs like food");
	}

	@Override
	public void speak() {
		System.out.println("Bark bark");
	}

	@Override
	public void speak(int numTimes) {
		for(int i = numTimes; i > 0; i--){
			speak();
		}
	}
}
