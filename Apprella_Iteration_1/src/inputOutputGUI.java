import java.util.ArrayList;

import javax.swing.JTextArea;

public class inputOutputGUI {

	public void printToResults(ArrayList<String> list, JTextArea textArea) {
		for (String element : list) {
			// Will eventually be the element's toString() method
			textArea.append(element + "\n");
		}
	}
}
