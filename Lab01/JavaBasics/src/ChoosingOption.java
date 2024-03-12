// Exercise 6.1: ChoosingOption.java

import javax.swing.JOptionPane;
public class ChoosingOption {
	public static void main(String[] args) {
		int option = JOptionPane.showConfirmDialog(null,
				"Do you want to change to the first class ticket?",
				"Confirm Dialog", JOptionPane.YES_NO_OPTION);
		
		JOptionPane.showMessageDialog(null, "You've chosen: "
				+ (option == JOptionPane.YES_OPTION ? "Yes" : "No"));
		
		Object[] options = { "I do", "I don't" };
		JOptionPane.showOptionDialog(null, "Do you want to change to the economy class ticket?",
				"Option Dialog", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
		             null, options, options[0]);
		System.exit(0);
	}
}
