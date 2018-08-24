package zoo;

public class Animal implements Behaviors, Comparable <Animal> {
	private static int animalCounter = 0;
	private int animalNumber; // assign the animalCounter as an id for this specific Animal
	private char gender;
	private double weight;
	private int age;
	private boolean hasLegs;
	
	public Animal() { // the default constructor
		animalCounter++;
		animalNumber = animalCounter;
		
		gender = 'U';
		weight = 0;
		age = 0;
		hasLegs = true;
	}

	public Animal(double weight, int age, char gender, boolean hasLegs) {
		//this is the OL constructor for all Animal Attributes
		animalCounter++;
		animalNumber = animalCounter;
		
		setGender(gender);
		this.weight = weight;
		this.age = age;
		this.hasLegs = hasLegs;
	}

	// getters
	public static int getTotalAnimalCount(){// static... no object needed to call the method
		return animalCounter;
	}
	
	public int getAnimalNumber() {// non-static.. belongs to individual object
		return animalNumber;
	}
	
	public char getGender() {
		return gender;
	}

	public double getWeight() {
		return weight;
	}

	public int getAge() {
		return age;
	}

	public boolean getHasLegs() {
		return hasLegs;
	}

	// setters
	public void setWeight(double weight) {
		if(weight < 0) {
			System.out.println("Invalid Weight: "+ weight);
		} else {
			this.weight = weight;
		}
	}

	public void setAge(int age) {
		if(age < 0) {
			System.out.println("Invalid Age: "+ age);
		} else {
			this.age = age;
		}
	}
	
	public void setGender(char gender) {
		switch(gender){
		case 'U':
		case 'F':
		case 'M':
			this.gender = gender;
			break;
		case 'u':
		case 'f':
		case 'm':
			this.gender = Character.toUpperCase(gender);
			break;
		default:
			System.out.println("Invalid Gender: " + gender);
			this.gender = 'U';
		}
	}

	public void setHasLegs(boolean hasLegs) {
		this.hasLegs = hasLegs;
	}

	public String toString() {
		String s= "Animal: gender " + gender + ", weight " + weight	+ ", age "+ age;
		if(hasLegs){
			s += ", has legs";
		} else{
			s += ", does not have legs";
			return s;
		}
		return s;
	}

	@Override
	public boolean equals(Object o) {       
		if(o instanceof Animal) {           
			Animal otherAnimal = (Animal)o;
			if((this.gender == otherAnimal.gender)
					&& (this.age == otherAnimal.age)
					&& (this.weight == otherAnimal.weight
					&& (this.hasLegs == otherAnimal.hasLegs))) {
				return true;
			}
		}
		return false;
	}

	/* Uses the weight variable to compare 2 Animal objects
	 * return -1 when calling is less than passed in object
	 * return 1 when calling object is greater than passed in object
	 * return 0 when equal
	 */

	@Override
	public int compareTo(Animal otherAnimal) {
		if(this.weight > otherAnimal.weight) {
			return 1;
		} else if(this.weight == otherAnimal.weight) {
			return 0;
		} else {
			return -1;
		}
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void speak() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void speak(int numTimes) {
		// TODO Auto-generated method stub
		
	}
}
