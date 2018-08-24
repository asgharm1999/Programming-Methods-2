package zoo;

import javax.swing.JFrame;

public class Zoo_GUI extends JFrame {
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				Zoo_JFrame my_gui = new Zoo_JFrame();
			}
		});
	}
}



