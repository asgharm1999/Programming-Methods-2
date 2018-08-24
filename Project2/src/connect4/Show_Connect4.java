package connect4;

public class Show_Connect4 {
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				GUI_Connect4_Me gui = new GUI_Connect4_Me();
			}
		});
	}
}
