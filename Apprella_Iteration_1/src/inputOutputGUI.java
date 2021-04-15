import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JTextArea;

public class inputOutputGUI {

	HashMap<String, String> users;
	public inputOutputGUI() {
		users.put("trello_1", "0123456789");
	}
	/**
	 * Will eventually be the element's toString() method
	 * @param list
	 * @param textArea
	 * @throws Exception 
	 */
	public void printToResults(ArrayList<String> list, JTextArea textArea) {
		for (String element : list) {
			textArea.append(element + "\n");
		}
	}
	
	
	/**
	 * Takes a list and searches and returns words containing it or are equal to it
	 * @param list
	 * @param textArea
	 * @param str
	 * @throws Exception 
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
	
	
	public boolean checkUser(String username, String password) {
		
		System.out.println(users.get(username));
		if (users.containsKey(username)) {
			if (users.get(username) == password) {
				return true;
			}
		}
		
		return false;
	}
}
