package zoo;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Zoo_JP extends JPanel {
	private JPanel jpHeading, jpInputPanel, jpBtnPanel;
		// jpGenericPanel, jpBirdPanel, jpDogPanel, jpBtnPanel;
	private JLabel jlHeadingResult;
	
	private Animal[] animals = new Animal[7];
	
	public Zoo_JP() {
		setLayout(new GridLayout(3,3));
		
		jpHeading = new JPanel();
		jpInputPanel = new InputPanel();
		jpBtnPanel = new BtnPanel();
//		jpGenericPanel = new GenericPanel();
//		jpBirdPanel = new BirdPanel();
//		jpDogPanel = new DogPanel();
		
		jlHeadingResult = new JLabel("Let's Create a Zoo");
		jlHeadingResult.setFont(new Font(Font.SERIF, Font.BOLD, 30));
		
		jpHeading.add(jlHeadingResult); // adds result label to panel
		add(jpHeading);
		add(jpInputPanel);
		add(jpBtnPanel);
//		add(jpGenericPanel);
//		add(jpBirdPanel);
//		add(jpDogPanel);
	}
	
	private class InputPanel extends JPanel {
		private JLabel jlAnimal, jlWeight, jlAge, jlGender, jlHasLegs, jlHasBeak, 
				jlBeakLength, jlCanFly, jlHasTail, jlFavFood, jlTricks;
		
		private JTextField jtfAnimal, jtfWeight, jtfAge, jtfGender, jtfHasLegs, 
				jtfHasBeak, jtfBeakLength, jtfCanFly, jtfHasTail, jtfFavFood, jtfTricks;

		public InputPanel() {
			setLayout(new GridLayout(11,5));
			
			jlAnimal = new JLabel("Animal name: ");
			jlWeight = new JLabel("Weight: ");
			jlAge = new JLabel("Age: ");
			jlGender = new JLabel("Gender: ");
			jlHasLegs = new JLabel("Has legs?: ");
			jlHasBeak = new JLabel("Has beak?: ");
			jlBeakLength = new JLabel("Beak length: ");
			jlCanFly = new JLabel("Can fly?: ");			
			jlHasTail = new JLabel("Has tail?: ");
			jlFavFood = new JLabel("Favorite food: ");
			jlTricks = new JLabel("Tricks?: ");
		
			
			jtfAnimal = new JTextField();
			jtfWeight = new JTextField();
			jtfAge = new JTextField();
			jtfGender = new JTextField();
			jtfHasLegs = new JTextField();
			jtfHasBeak = new JTextField();
			jtfBeakLength = new JTextField();
			jtfCanFly = new JTextField();
			jtfHasTail = new JTextField();
			jtfFavFood = new JTextField();
			jtfTricks = new JTextField();
			
			
			add(jlAnimal);
			add(jtfAnimal);
			
			add(jlWeight);
			add(jtfWeight);
			
			add(jlAge);
			add(jtfAge);
			
			add(jlGender);
			add(jtfGender);
			
			add(jlHasLegs);
			add(jtfHasLegs);
			
			add(jlHasBeak);
			add(jtfHasBeak);
			
			add(jlBeakLength);
			add(jtfBeakLength);
			
			add(jlCanFly);
			add(jtfCanFly);
			
			add(jlHasTail);
			add(jtfHasTail);

			add(jlFavFood);
			add(jtfFavFood);

			add(jlTricks);
			add(jtfTricks);
		}
		
		public String getAnimalName() {
			String animal = jtfAnimal.getText();
			return animal;
		}
		
		public double getWeight() {
			String weight = jtfWeight.getText();
			if(weight != null) {
				return Double.parseDouble(weight);
			} else {
				return 0;
			}
		}

		public int getAge() {
			String age = jtfAge.getText();
			if(age != null) {
				return Integer.parseInt(age);
			} else {
				return 0;
			}
		}

		public char getGender() {
			String gender = jtfGender.getText();
			if(gender != null) {
				return gender.charAt(0);
			} else {
				return 0;
			}
		}
		
		public boolean getHasLegs() {
			String hasLegs = jtfHasLegs.getText();
			if(hasLegs != null) {
				return Boolean.parseBoolean(hasLegs);
			} else {
				return false;
			}
		}
		
		public boolean getHasBeak() {
			String hasBeak = jtfHasBeak.getText();
			if(hasBeak != null) {
				return Boolean.parseBoolean(hasBeak);
			} else {
				return false;
			}
		}

		public double getBeakLength() {
			String beakLength = jtfBeakLength.getText();
			if(beakLength != null) {
				return Double.parseDouble(beakLength);
			} else {
				return 0;
			}
		}
		
		public boolean getCanFly() {
			String canFly = jtfCanFly.getText();
			if(canFly != null) {
				return Boolean.parseBoolean(canFly);
			} else {
				return false;
			}
		}
		
		public boolean getHasTail() {
			String hasTail = jtfHasTail.getText();
			if(hasTail != null) {
				return Boolean.parseBoolean(hasTail);
			} else {
				return false;
			}
		}

		public String getFavFood() {
			String favFood = jtfFavFood.getText();
			return favFood;
		}
	}
	
//	private class GenericPanel extends JPanel {
//		private JLabel jlAnimal, jlWeight, jlAge, jlGender, jlHasLegs;
//		private JTextField jtfAnimal, jtfWeight, jtfAge, jtfGender, jtfHasLegs; 
//
//		public GenericPanel() {
//			setLayout(new GridLayout(5,5));
//			
//			jlAnimal = new JLabel("Animal name: ");
//			jlWeight = new JLabel("Weight: ");
//			jlAge = new JLabel("Age: ");
//			jlGender = new JLabel("Gender: ");
//			jlHasLegs = new JLabel("Has legs?: ");
//			
//			jtfAnimal = new JTextField();
//			jtfWeight = new JTextField();
//			jtfAge = new JTextField();
//			jtfGender = new JTextField();
//			jtfHasLegs = new JTextField();
//			
//			add(jlAnimal);
//			add(jtfAnimal);
//			
//			add(jlWeight);
//			add(jtfWeight);
//			
//			add(jlAge);
//			add(jtfAge);
//			
//			add(jlGender);
//			add(jtfGender);
//			
//			add(jlHasLegs);
//			add(jtfHasLegs);
//		}
//		
//		public String getAnimalName() {
//			String animal = jtfAnimal.getText();
//			return animal;
//		}
//		
//		public double getWeight() {
//			String weight = jtfWeight.getText();
//			if(weight != null) {
//				return Double.parseDouble(weight);
//			} else {
//				return 0;
//			}
//		}
//
//		public int getAge() {
//			String age = jtfAge.getText();
//			if(age != null) {
//				return Integer.parseInt(age);
//			} else {
//				return 0;
//			}
//		}
//
//		public char getGender() {
//			String gender = jtfGender.getText();
//			if(gender != null) {
//				return gender.charAt(0);
//			} else {
//				return 0;
//			}
//		}
//		
//		public boolean getHasLegs() {
//			String hasLegs = jtfHasLegs.getText();
//			if(hasLegs != null) {
//				return Boolean.parseBoolean(hasLegs);
//			} else {
//				return false;
//			}
//		}
//	}
//	
//	private class BirdPanel extends JPanel {
//		private JLabel jlAnimal, jlWeight, jlAge, jlGender, jlHasLegs, jlHasBeak, jlBeakLength, jlCanFly; 
//		private JTextField jtfAnimal, jtfWeight, jtfAge, jtfGender, jtfHasLegs, 
//				jtfHasBeak, jtfBeakLength, jtfCanFly; 
//
//		public BirdPanel() {
//			setLayout(new GridLayout(5,5));
//			
//			jlAnimal = new JLabel("Animal name: ");
//			jlWeight = new JLabel("Weight: ");
//			jlAge = new JLabel("Age: ");
//			jlGender = new JLabel("Gender: ");
//			jlHasLegs = new JLabel("Has legs?: ");
//			jlHasBeak = new JLabel("Has beak?: ");
//			jlBeakLength = new JLabel("Beak length: ");
//			jlCanFly = new JLabel("Can fly?: ");
//			
//			jtfAnimal = new JTextField();
//			jtfWeight = new JTextField();
//			jtfAge = new JTextField();
//			jtfGender = new JTextField();
//			jtfHasLegs = new JTextField();
//			jtfHasBeak = new JTextField();
//			jtfBeakLength = new JTextField();
//			jtfCanFly = new JTextField();
//			
//			add(jlAnimal);
//			add(jtfAnimal);
//			
//			add(jlWeight);
//			add(jtfWeight);
//			
//			add(jlAge);
//			add(jtfAge);
//			
//			add(jlGender);
//			add(jtfGender);
//			
//			add(jlHasLegs);
//			add(jtfHasLegs);
//			
//			add(jlHasBeak);
//			add(jtfHasBeak);
//			
//			add(jlBeakLength);
//			add(jtfBeakLength);
//			
//			add(jlCanFly);
//			add(jtfCanFly);
//		}
//
//		public String getAnimalName() {
//			String animal = jtfAnimal.getText();
//			return animal;
//		}
//		
//		public double getWeight() {
//			String weight = jtfWeight.getText();
//			if(weight != null) {
//				return Double.parseDouble(weight);
//			} else {
//				return 0;
//			}
//		}
//
//		public int getAge() {
//			String age = jtfAge.getText();
//			if(age != null) {
//				return Integer.parseInt(age);
//			} else {
//				return 0;
//			}
//		}
//
//		public char getGender() {
//			String gender = jtfGender.getText();
//			if(gender != null) {
//				return gender.charAt(0);
//			} else {
//				return 0;
//			}
//		}
//		
//		public boolean getHasLegs() {
//			String hasLegs = jtfHasLegs.getText();
//			if(hasLegs != null) {
//				return Boolean.parseBoolean(hasLegs);
//			} else {
//				return false;
//			}
//		}
//		
//		public boolean getHasBeak() {
//			String hasBeak = jtfHasBeak.getText();
//			if(hasBeak != null) {
//				return Boolean.parseBoolean(hasBeak);
//			} else {
//				return false;
//			}
//		}
//
//		public double getBeakLength() {
//			String beakLength = jtfBeakLength.getText();
//			if(beakLength != null) {
//				return Double.parseDouble(beakLength);
//			} else {
//				return 0;
//			}
//		}
//		
//		public boolean getCanFly() {
//			String canFly = jtfCanFly.getText();
//			if(canFly != null) {
//				return Boolean.parseBoolean(canFly);
//			} else {
//				return false;
//			}
//		}
//	}
//
//	private class DogPanel extends JPanel {
//		private JLabel jlAnimal, jlWeight, jlAge, jlGender, jlHasLegs, jlHasTail, jlFavFood, jlTricks;
//		private JTextField jtfAnimal, jtfWeight, jtfAge, jtfGender, jtfHasLegs, jtfHasTail, 
//				jtfFavFood, jtfTricks;
//		
//		public DogPanel() {
//			setLayout(new GridLayout(5,5));
//		
//			jlAnimal = new JLabel("Animal name: ");
//			jlWeight = new JLabel("Weight: ");
//			jlAge = new JLabel("Age: ");
//			jlGender = new JLabel("Gender: ");
//			jlHasLegs = new JLabel("Has legs?: ");
//			jlHasTail = new JLabel("Has tail?: ");
//			jlFavFood = new JLabel("Favorite food: ");
//			jlTricks = new JLabel("Tricks?: ");
//
//			jtfAnimal = new JTextField();
//			jtfWeight = new JTextField();
//			jtfAge = new JTextField();
//			jtfGender = new JTextField();
//			jtfHasLegs = new JTextField();
//			jtfHasTail = new JTextField();
//			jtfFavFood = new JTextField();
//			jtfTricks = new JTextField();
//
//			add(jlAnimal);
//			add(jtfAnimal);
//
//			add(jlWeight);
//			add(jtfWeight);
//
//			add(jlAge);
//			add(jtfAge);
//
//			add(jlGender);
//			add(jtfGender);
//
//			add(jlHasLegs);
//			add(jtfHasLegs);
//
//			add(jlHasTail);
//			add(jtfHasTail);
//
//			add(jlFavFood);
//			add(jtfFavFood);
//
//			add(jlTricks);
//			add(jtfTricks);
//		}
//		
//		public String getAnimalName() {
//			String animal = jtfAnimal.getText();
//			return animal;
//		}
//		
//		public double getWeight() {
//			String weight = jtfWeight.getText();
//			if(weight != null) {
//				return Double.parseDouble(weight);
//			} else {
//				return 0;
//			}
//		}
//
//		public int getAge() {
//			String age = jtfAge.getText();
//			if(age != null) {
//				return Integer.parseInt(age);
//			} else {
//				return 0;
//			}
//		}
//
//		public char getGender() {
//			String gender = jtfGender.getText();
//			if(gender != null) {
//				return gender.charAt(0);
//			} else {
//				return 0;
//			}
//		}
//		
//		public boolean getHasLegs() {
//			String hasLegs = jtfHasLegs.getText();
//			if(hasLegs != null) {
//				return Boolean.parseBoolean(hasLegs);
//			} else {
//				return false;
//			}
//		}
//		
//		public boolean getHasTail() {
//			String hasTail = jtfHasTail.getText();
//			if(hasTail != null) {
//				return Boolean.parseBoolean(hasTail);
//			} else {
//				return false;
//			}
//		}
//
//		public String getFavFood() {
//			String favFood = jtfFavFood.getText();
//			return favFood;
//		}
//	}
	
	private class BtnPanel extends JPanel implements ActionListener {
		private String[] btnFaces = {"Create", "Display", "Update", "Remove"};
		private JButton[] jbtns;

		public BtnPanel() {
			setLayout(new GridLayout(1, btnFaces.length));
			jbtns = new JButton[btnFaces.length];
			populatePanelWithButton();
		}

		private void populatePanelWithButton() {
			for(int i = 0; i < jbtns.length; i++) {
				jbtns[i] = new JButton(btnFaces[i]);
				jbtns[i].addActionListener(this);
				add(jbtns[i]);
			}
		}
	
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btnClicked = (JButton)e.getSource();
			
			// from generic panel
			String animal = ((InputPanel)jpInputPanel).getAnimalName();			
			double weight = ((InputPanel)jpInputPanel).getWeight();
			int age = ((InputPanel)jpInputPanel).getAge();
			char gender = ((InputPanel)jpInputPanel).getGender();
			boolean hasLegs = ((InputPanel)jpInputPanel).getHasLegs();
			boolean hasBeak = ((InputPanel)jpInputPanel).getHasBeak();
			double beakLength = ((InputPanel)jpInputPanel).getBeakLength();
			boolean canFly = ((InputPanel)jpInputPanel).getCanFly();
			boolean hasTail = ((InputPanel)jpInputPanel).getHasTail();
			String FavFood = ((InputPanel)jpInputPanel).getFavFood();
			
			if(btnClicked.equals(jbtns[0])) {
				if(btnClicked.equals(jbtns[0])) { // create
					if("Animal".equalsIgnoreCase(animal)) {
						animals[0] = new Animal(weight, age, gender, hasLegs);
						System.out.println(animals[0]);
					} else if("Bird".equalsIgnoreCase(animal)){
						animals[1] = new Bird(weight, age, gender, hasLegs, hasBeak,
								beakLength, canFly);
						System.out.println(animals[1]);
					} else if("Penguin".equalsIgnoreCase(animal)) {
						animals[2] = new Penguin(weight, age, gender, hasLegs, hasBeak,
								beakLength, canFly);
						System.out.println(animals[2]);
					} else if("Pigeon".equalsIgnoreCase(animal)) {
						animals[3] = new Pigeon(weight, age, gender, hasLegs, hasBeak,
								beakLength, canFly);
						System.out.println(animals[3]); 
					} else if("Dog".equalsIgnoreCase(animal)) {
						animals[4] = new Dog(weight, age, gender, hasLegs, hasTail, FavFood);
						System.out.println(animals[4]);
					} else if("ShibaInu".equalsIgnoreCase(animal) ||
						"Shiba Inu".equalsIgnoreCase(animal)) {
						animals[5] = new ShibaInu(weight, age, gender, hasLegs, hasTail, FavFood);
						System.out.println(animals[5]);
					} else if("Chihuahua".equalsIgnoreCase(animal)) {
						animals[6]  = new Chihuahua(weight, age, gender, hasLegs, hasTail, FavFood);					
						System.out.println(animals[6]);
					}
				} // end of create button
			}

			animal = ((InputPanel)jpInputPanel).getAnimalName();

			if(btnClicked.equals(jbtns[1])) { // display button
				if("Animal".equalsIgnoreCase(animal)) {
					System.out.println(animals[0]);
					jlHeadingResult.setText(animals[0].toString());
				} else if("Bird".equalsIgnoreCase(animal)) {
					System.out.println(animals[1]);
					jlHeadingResult.setText(animals[1].toString());
				} else if("Penguin".equalsIgnoreCase(animal)){
					System.out.println(animals[2]);
					jlHeadingResult.setText(animals[2].toString());
				} else if("Pigeon".equalsIgnoreCase(animal)) {
					System.out.println(animals[3]);
					jlHeadingResult.setText(animals[3].toString());
				} else if("Dog".equalsIgnoreCase(animal)) {
					System.out.println(animals[4]);
					jlHeadingResult.setText(animals[4].toString());
				} else if("ShibaInu".equalsIgnoreCase(animal) || 
						"Shiba Inu".equalsIgnoreCase(animal)) {
					System.out.println(animals[5]);
					jlHeadingResult.setText(animals[5].toString());
				} else if("Chihuahua".equalsIgnoreCase(animal)) {
					System.out.println(animals[6]);
					jlHeadingResult.setText(animals[6].toString());
				}
			} // end of display button

			if(btnClicked.equals(jbtns[2])) { // update button
				if("Animal".equalsIgnoreCase(animal)) {
					animals[0] = new Animal(weight, age, gender, hasLegs);
					System.out.println(animals[0]);
				} else if("Bird".equalsIgnoreCase(animal)){
					animals[1] = new Bird(weight, age, gender, hasLegs, hasBeak,
							beakLength, canFly);
					System.out.println(animals[1]);
				} else if("Penguin".equalsIgnoreCase(animal)) {
					animals[2] = new Penguin(weight, age, gender, hasLegs, hasBeak,
							beakLength, canFly);
					System.out.println(animals[2]);
				} else if("Pigeon".equalsIgnoreCase(animal)) {
					animals[3] = new Pigeon(weight, age, gender, hasLegs, hasBeak,
							beakLength, canFly);
					System.out.println(animals[3]); 
				} else if("Dog".equalsIgnoreCase(animal)) {
					animals[4] = new Dog(weight, age, gender, hasLegs, hasTail, FavFood);
					System.out.println(animals[4]);
				} else if("ShibaInu".equalsIgnoreCase(animal) ||
						"Shiba Inu".equalsIgnoreCase(animal)) {
					animals[5] = new ShibaInu(weight, age, gender, hasLegs, hasTail, FavFood);
					System.out.println(animals[5]);
				} else if("Chihuahua".equalsIgnoreCase(animal)) {
					animals[6]  = new Chihuahua(weight, age, gender, hasLegs, hasTail, FavFood);					
					System.out.println(animals[6]);
				}
			} // end of update button
		
			if(btnClicked.equals(jbtns[3])) { // remove button	
				if("Animal".equalsIgnoreCase(animal)) {
						animals[0] = null;
						jlHeadingResult.setText("This animal has been deleted");
						System.out.println(animals[0]);
				} else if("Bird".equalsIgnoreCase(animal)) {
					animals[1] = null;
					jlHeadingResult.setText("Bird has been deleted");
					System.out.println(animals[1]);
				} else if("Penguin".equalsIgnoreCase(animal)) {
					animals[2] = null;
					jlHeadingResult.setText("Peguin has been deleted");
					System.out.println(animals[2]);
				} else if("Pigeon".equalsIgnoreCase(animal)) {
					animals[3] = null;
					jlHeadingResult.setText("Pigeon has been deleted");
					System.out.println(animals[3]);
				} else if("Dog".equalsIgnoreCase(animal)) {
					animals[4] = null;
					jlHeadingResult.setText("Dog has been deleted");
					System.out.println(animals[4]);
				} else if("ShibaInu".equalsIgnoreCase(animal) || 
						"Shiba Inu".equalsIgnoreCase(animal)) {
					animals[5] = null;
					jlHeadingResult.setText("Shiba Inu has been deleted");
					System.out.println(animals[5]);
				} else if("Chihuahua".equalsIgnoreCase(animal)) {
					animals[6] = null;
					jlHeadingResult.setText("Chihuahua has been deleted");
					System.out.println(animals[6]);
				}
			} // end of remove button
		} // end of actionPerformed
	} // end of btnPanel
}
