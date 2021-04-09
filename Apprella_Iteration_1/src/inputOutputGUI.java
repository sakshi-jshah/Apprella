import java.util.ArrayList;

import javax.swing.JTextArea;

public class inputOutputGUI {

	/**
	 * Will eventually be the element's toString() method
	 * @param list
	 * @param textArea
	 * @throws Exception 
	 */
	public void printToResults(ArrayList<String> list, JTextArea textArea) throws Exception {
		if(!list.isEmpty()) {
			for (String element : list) {
				textArea.append(element + "\n");
			}
		} else {
			throw new Exception("List is empty");
		}
	}
	
	
	/**
	 * Takes a list and searches and returns words containing it or are equal to it
	 * @param list
	 * @param textArea
	 * @param str
	 * @throws Exception 
	 */
	public void searchResults(ArrayList<String>list, JTextArea textArea, String str) throws Exception
	{
		if(!list.isEmpty()) {
			for (String element : list)
			{
				if(element.contains(str) || str.equals(element))
				{
					textArea.append(element + "\n");
				}
			}
		} else {
			throw new Exception("List is empty");
		}
	}
}
