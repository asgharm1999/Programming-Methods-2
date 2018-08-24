package zoo;

public class Driver {
	public static void main(String[] args) {
		String [] funTricks = {"sit", "sing"};
		String [] funTricks2 = {"jump", "attack", "sit", "paw", "sing"};
		
		Dog dog1 = new Dog(12.3, 12, 'f', true, true, "coffee", funTricks);
		Bird bird1 = new Bird(0.2, 3, 'f', true, true, 12, true);
		Penguin penguin1 = new Penguin(150, 7, 'u', true, true, 3, true);
		Pigeon pigeon1 = new Pigeon(2, 7, 'f', true, true, 1, true); 
		ShibaInu shibaInu1 = new ShibaInu(50.6, 2, 'f', true, true, "bones", funTricks);
		Chihuahua chihuahua1 = new Chihuahua(20, 5, 'f', true, true, "steak", funTricks);	
	}
}
