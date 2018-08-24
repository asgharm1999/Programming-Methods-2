package zoo;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Arrays;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import OOP1.Animal;

public class Unused_DogForm extends AnimalForm {
	private JLabel jlWeight, jlAge, jlGender, jlHasLegs, jlHasTail, jlFavFood, jlTricks;
	private JTextField jtfWeight, jtfAge, jtfGender, jtfHasLegs, jtfHasTail, jtfFavFood, jtfTricks;
	private final Dimension SIZE_OF_TEXTFIELDS = new Dimension(500, 50);

	public JPanel getAnimalForm() {
		JPanel jp = new JPanel();
		
		jp.setBounds(512, 512, 81, 140);
		jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
	
		AnimalForm.add(jp);
		jp.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		jlWeight = new JLabel("Weight: ", JLabel.TRAILING);
		jtfWeight = new JTextField(10);
		jtfWeight.setMaximumSize(SIZE_OF_TEXTFIELDS);
		
		jlAge = new JLabel("Age: ", JLabel.TRAILING);
		jtfAge = new JTextField(10);
		jtfAge.setMaximumSize(SIZE_OF_TEXTFIELDS);
		
		jlGender = new JLabel("Gender: ", JLabel.TRAILING);
		jtfGender = new JTextField(10);
		jtfGender.setMaximumSize(SIZE_OF_TEXTFIELDS);
		
		jlHasLegs = new JLabel("Has Legs: ", JLabel.TRAILING);
		jtfHasLegs = new JTextField(10);
		jtfHasLegs.setMaximumSize(SIZE_OF_TEXTFIELDS);
		
		jlHasTail = new JLabel("Has tail: ", JLabel.TRAILING);
		jtfHasTail = new JTextField(10);
		jtfHasTail.setMaximumSize(SIZE_OF_TEXTFIELDS);
		
		jlFavFood = new JLabel("Favorite food: ", JLabel.TRAILING);
		jtfFavFood = new JTextField(10);
		jtfFavFood.setMaximumSize(SIZE_OF_TEXTFIELDS);
		
		jlTricks = new JLabel("Tricks: ", JLabel.TRAILING);
		jtfTricks = new JTextField(10);
		jtfTricks.setMaximumSize(SIZE_OF_TEXTFIELDS);
		
		jp.add(jlWeight);
		jp.add(jtfWeight);
		
		jp.add(jlAge);
		jp.add(jtfAge);
		
		jp.add(jlGender);
		jp.add(jtfGender);
		
		jp.add(jlHasLegs);
		jp.add(jtfHasLegs);
		
		jp.add(jlHasTail);
		jp.add(jtfHasTail);
		
		jp.add(jlFavFood);
		jp.add(jtfFavFood);
		
		jp.add(jlTricks);
		jp.add(jtfTricks);
		
		return jp;
	}
	
	public boolean getHasTail() {
		String hasTail = new String();
		hasTail = jtfHasTail.getText();

		if(hasTail == "true") {
			boolean bHasTail = true;
			return bHasTail;
		} else {
			boolean bHasTail = false;
			return bHasTail;
		}
	}
	
	public String getFavFood() {
		String favFood = new String();
		favFood = jtfFavFood.getText();
		return favFood;	
	}
	
	public List<String> getTricks() {
		String tricks = new String();
		tricks = jtfTricks.getText();
		List<String> List = Arrays.asList(tricks.split(","));
		return List;
	}

	@Override
	public Animal getAnimalFromForm() {
		return null;
	}

	@Override
	public void modifyForm(Animal a) {
		// TODO Auto-generated method stub
		
	}


}
