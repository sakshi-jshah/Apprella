import javax.swing.*;


public class Panel {
	
	public static void main(String args[]) {
		String[] tempList = { "temp1", "temp2", "temp3" };
		
		JFrame f = new JFrame();
		
		JLabel searchLabel = new JLabel("Search Bar:");
		searchLabel.setBounds(20, 20, 600, 20);
		JTextField search = new JTextField();
		search.setBounds(20, 40, 600, 20);
		f.add(searchLabel);
		f.add(search);
		
		
		JButton searchButton = new JButton("Submit");
		searchButton.setBounds(640, 40, 100, 20);
		f.add(searchButton);
		
		
		JButton loginButton = new JButton("Login");
		loginButton.setBounds(760, 40, 100, 20);
		f.add(loginButton);
		
		JLabel genre1Label = new JLabel("Sort Genre:");
		genre1Label.setBounds(640, 120, 220, 20);
		JComboBox genre = new JComboBox(tempList);
		genre.setBounds(640, 140, 220, 20);
		f.add(genre1Label);
		f.add(genre);
		
		JLabel genre2Label = new JLabel("Minimum Price:");
		genre2Label.setBounds(640, 180, 220, 20);
		JComboBox genre2 = new JComboBox(tempList);
		genre2.setBounds(640, 200, 220, 20);
		f.add(genre2Label);
		f.add(genre2);
		
		JLabel genre3Label = new JLabel("Minimum Rating:");
		genre3Label.setBounds(640, 240, 220, 20);
		JComboBox genre3 = new JComboBox(tempList);
		genre3.setBounds(640, 260, 220, 20);
		f.add(genre3Label);
		f.add(genre3);
		
		JLabel returnLabel = new JLabel("Results:");
		returnLabel.setBounds(20, 80, 600, 20);
		JTextArea returnArea = new JTextArea();
		returnArea.setBounds(20, 100, 600, 540);
		f.add(returnLabel);
		
		f.add(returnArea);
		
		f.setSize(1000,700);
		f.setLayout(null);
		f.setVisible(true);
	}
}
