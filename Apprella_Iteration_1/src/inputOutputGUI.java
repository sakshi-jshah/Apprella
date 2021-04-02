import java.util.ArrayList;

import javax.swing.JTextArea;

public class inputOutputGUI {

	public void printToResults(ArrayList<String> list, JTextArea textArea) {
		for (String element : list) {
			// Will eventually be the element's toString() method
			textArea.append(element + "\n");
		}
	}
	
	
	/**
	 * Takes a list and searches and returns words containing it or are equal to it
	 * @param list
	 * @param textArea
	 * @param str
	 */
	public void searchResults(ArrayList<String>list, JTextArea textArea, String str)
	{
		for (String element : list)
		{
			if(element.contains(str) || str.equals(element))
			{
				textArea.append(element + "\n");
			}
		}
	}
}
