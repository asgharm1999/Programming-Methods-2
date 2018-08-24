package zoo;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Zoo_JFrame extends JFrame {
	
	private String title = "ZooBuilder";
	
	public Zoo_JFrame() {
		JPanel mainJP = new JPanel();
		mainJP.setLayout(new BorderLayout());
		
		Zoo_JP zooJP = new Zoo_JP();
		mainJP.add(zooJP);
		add(mainJP);
		
		setTitle(title);
		setSize(800,800);
		setLocation(660, 240);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
