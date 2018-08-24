package zoo;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import OOP1.Animal;

public class Unused_BirdForm extends AnimalForm {
	private JLabel jlWeight, jlAge, jlGender, jlHasLegs, jlHasBeak, jlBeakLength, jlCanFly;  
	private JTextField jtfWeight, jtfAge, jtfGender, jtfHasLegs, jtfHasBeak, jtfBeakLength, jtfCanFly; 
	private final Dimension SIZE_OF_TEXTFIELDS = new Dimension(500, 50);
	
	public JPanel getBirdForm() {
		JPanel jp = new JPanel();
		
		jp.setBounds(61, 11, 81, 140);
		jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
		Unused_BirdForm.add(jp);
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
		
		jlHasBeak = new JLabel("Has beak: ", JLabel.TRAILING);
		jtfHasBeak = new JTextField(10);
		jtfHasBeak.setMaximumSize(SIZE_OF_TEXTFIELDS);

		jlBeakLength = new JLabel("Beak length: ", JLabel.TRAILING);
		jtfBeakLength = new JTextField(10);
		jtfBeakLength.setMaximumSize(SIZE_OF_TEXTFIELDS);
		
		jlCanFly = new JLabel("Can fly: ", JLabel.TRAILING);
		jtfCanFly = new JTextField(10);
		jtfCanFly.setMaximumSize(SIZE_OF_TEXTFIELDS);
		
		jp.add(jlWeight);
		jp.add(jtfWeight);
		
		jp.add(jlAge);
		jp.add(jtfAge);
		
		jp.add(jlGender);
		jp.add(jtfGender);
		
		jp.add(jlHasLegs);
		jp.add(jtfHasLegs);
		
		jp.add(jlHasBeak);
		jp.add(jtfHasBeak);
		
		jp.add(jlBeakLength);
		jp.add(jtfBeakLength);
		
		jp.add(jlCanFly);
		jp.add(jtfCanFly);
		
		return jp;
	}
	
	public boolean getHasBeak() {
		String hasBeak = new String();
		hasBeak = jtfHasLegs.getText();

		if(hasBeak == "true") {
			boolean bHasBeak = true;
			return bHasBeak;
		} else {
			boolean bHasBeak = false;
			return bHasBeak;
		}
	}

	public double getBeakLength() {
		double beakLength = Double.parseDouble(jtfBeakLength.getText());
		return beakLength;
	}
	
	public boolean getCanFly() {
		String canFly = new String();
		canFly = jtfHasLegs.getText();

		if(canFly == "true") {
			boolean bCanFly = true;
			return bCanFly;
		} else {
			boolean bCanFly = false;
			return bCanFly;
		}
	}
	
	@Override
	public Animal getAnimalFromForm() {
		return null;
	}

	@Override
	public JPanel getAnimalForm() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyForm(Animal a) {
		// TODO Auto-generated method stub
		
	}
}

