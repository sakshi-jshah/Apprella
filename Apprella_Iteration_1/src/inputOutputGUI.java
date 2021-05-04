import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JTextArea;

public class inputOutputGUI {

	private HashMap<String, String> users;
	private HashMap<String, String> moderators;
	private HashMap<String, String> administrators;

	public inputOutputGUI() {
		users = new HashMap<String, String>();
		users.put("trello_1", "0123456789");
		administrators = new HashMap<String, String>();
		administrators.put("admin", "password");
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
	
	
	public int checkUser(String username, String password) {
		
		System.out.println(administrators.containsKey(username));
		System.out.println(administrators.get(username));

		if (!administrators.isEmpty()) {
			if (administrators.containsKey(username)) {
				String tempPassword = administrators.get(username);
				// System.out.println(tempPassword.contentEquals(password));
				if (tempPassword.equals(password)) {
					return 3;
				}
			}
		}
		if (!moderators.isEmpty()) {
			if (moderators.containsKey(username)) {
				String tempPassword = moderators.get(username);
				System.out.println(tempPassword == password);
				if (tempPassword.equals(password)) {
					return 2;
				}
			}
		}
		if (!users.isEmpty()) {
			if (users.containsKey(username)) {
				String tempPassword = users.get(username);
				System.out.println(tempPassword == password);
				if (tempPassword.equals(password)) {
					return 1;
				}
			}
		}
		return 0;
	}
}
