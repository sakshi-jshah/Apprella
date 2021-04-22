import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

import org.w3c.dom.events.Event;


public class Panel {
	private static int loggedIn;
	
	public static void main(String args[]) throws IOException {
		String[] genreList = { "...", "Art & Design", "Beauty", "Books", "Business", "Communication", "Education"};
		String[] priceList = { "...", "Free", "$0.99+", "$1.99+", "$2.99+", "$3.99+"};
		String[] ratingList = { "...", "Highet Rating", "Lowest Rating"};
		
		// Temp list of elements to test printing
		ArrayList<String> resultTestList = new ArrayList<>();
		resultTestList.add("Among Us");
		resultTestList.add("Minecraft");
		resultTestList.add("TikTok");
		resultTestList.add("Instagram");
		resultTestList.add("Procreate");
		resultTestList.add("Gmail");
		resultTestList.add("Aprella");
		resultTestList.add("Twitter");
		resultTestList.add("Netflix");
		
		BufferedImage backgroundImage = ImageIO.read(new File("background_temp.jpeg"));
		
		JFrame f = new JFrame();
		
		f.setContentPane(new Background_Panel(backgroundImage));
		
		inputOutputGUI IandO = new inputOutputGUI();
		
		// Creating Search Bar GUI
		JLabel searchLabel = new JLabel("Search Bar:");
		searchLabel.setForeground(Color.white);
		searchLabel.setBounds(20, 20, 600, 20);
		JTextField search = new JTextField();
		search.setBounds(20, 40, 600, 20);
		f.add(searchLabel);
		f.add(search);
		
		// Creating Search Button GUI
		JButton searchButton = new JButton("Search");
		searchButton.setBounds(640, 40, 100, 20);
		f.add(searchButton);
		
		// Creating Login Button GUI
		JButton loginButton = new JButton("Login");
		loginButton.setBounds(760, 40, 100, 20);
		f.add(loginButton);
		
		// Creating Field Shrinking Ability
		JLabel genre1Label = new JLabel("Sort Genre:");
		genre1Label.setForeground(Color.white);
		genre1Label.setBounds(640, 120, 220, 20);
		JComboBox genre = new JComboBox(genreList);
		genre.setBounds(640, 140, 220, 20);
		f.add(genre1Label);
		f.add(genre);
		
		JLabel genre2Label = new JLabel("Minimum Price:");
		genre2Label.setForeground(Color.white);
		genre2Label.setBounds(640, 180, 220, 20);
		JComboBox genre2 = new JComboBox(priceList);
		genre2.setBounds(640, 200, 220, 20);
		f.add(genre2Label);
		f.add(genre2);
		
		JLabel genre3Label = new JLabel("Minimum Rating:");
		genre3Label.setForeground(Color.white);
		genre3Label.setBounds(640, 240, 220, 20);
		JComboBox genre3 = new JComboBox(ratingList);
		genre3.setBounds(640, 260, 220, 20);
		f.add(genre3Label);
		f.add(genre3);
		
		// Creating button to enable sorting
		JButton sortButton = new JButton("Enter");
		sortButton.setBounds(640, 300, 100, 20);
		f.add(sortButton);
		
		// Creating area data will be returned
		JLabel returnLabel = new JLabel("Results:");
		returnLabel.setForeground(Color.white);
		returnLabel.setBounds(20, 80, 600, 20);
		JTextArea returnArea = new JTextArea();
		returnArea.setBounds(20, 100, 600, 500);
		//IandO.printToResults(resultTestList, returnArea);
		f.add(returnLabel);
		
		f.add(returnArea);
		
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = search.getText();
				IandO.searchResults(resultTestList, returnArea, text);
			}
		});
		
		/*
		 * Adding the ability to login
		 */
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel tempPanel = new JPanel();
				JTextField usernameField = new JTextField(10);
			    JTextField passwordField = new JTextField(10);
				tempPanel.add(new JLabel("Username:"));
			    tempPanel.add(usernameField);
			    tempPanel.add(Box.createHorizontalStrut(15)); // a spacer
			    tempPanel.add(new JLabel("Password:"));
			    tempPanel.add(passwordField);
				int good = JOptionPane.showConfirmDialog(null, tempPanel, "Enter username: ", JOptionPane.OK_CANCEL_OPTION);
				String username = usernameField.getText();
				String password = passwordField.getText();
				System.out.println(username);
				System.out.println(password);

				if (IandO.checkUser(username, password) == 0) {
					JOptionPane.showMessageDialog(f, "Successful Login");
					loggedIn = 0;
				} else if (IandO.checkUser(username, password) == 1){
					JOptionPane.showMessageDialog(f, "In-Successful Login");
					loggedIn = 1;
				} else {
					JOptionPane.showMessageDialog(f, "Administrative Login Successful");
					loggedIn = 2;
				}
			}
		});
		
		
		f.setSize(1000,680);
		f.setLayout(null);
		f.setVisible(true);
	}
	
	
}
