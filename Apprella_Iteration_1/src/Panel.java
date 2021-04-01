import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;


public class Panel {
	
	public static void main(String args[]) throws IOException {
		String[] tempList = { "...", "temp1", "temp2", "temp3" };
		
		BufferedImage backgroundImage = ImageIO.read(new File("background_temp.jpeg"));
		
		JFrame f = new JFrame();
		
		f.setContentPane(new Background_Panel(backgroundImage));
		
		
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
		JComboBox genre = new JComboBox(tempList);
		genre.setBounds(640, 140, 220, 20);
		f.add(genre1Label);
		f.add(genre);
		
		JLabel genre2Label = new JLabel("Minimum Price:");
		genre2Label.setForeground(Color.white);
		genre2Label.setBounds(640, 180, 220, 20);
		JComboBox genre2 = new JComboBox(tempList);
		genre2.setBounds(640, 200, 220, 20);
		f.add(genre2Label);
		f.add(genre2);
		
		JLabel genre3Label = new JLabel("Minimum Rating:");
		genre3Label.setForeground(Color.white);
		genre3Label.setBounds(640, 240, 220, 20);
		JComboBox genre3 = new JComboBox(tempList);
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
		returnArea.setBounds(20, 100, 600, 540);
		f.add(returnLabel);
		
		f.add(returnArea);
		
		f.setSize(1000,680);
		f.setLayout(null);
		f.setVisible(true);
	}
}
