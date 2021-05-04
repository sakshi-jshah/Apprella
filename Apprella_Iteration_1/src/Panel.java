import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

import org.w3c.dom.events.Event;


public class Panel {
	private static int loggedIn;
	
	private ArrayList<Application> app;
	
	public static void main(String args[]) throws IOException {
		String[] genreList = { "...", "Art & Design", "Beauty", "Books", "Business", "Communication", "Education"};
		String[] priceList = { "...", "Free", "$0.99+", "$1.99+", "$2.99+", "$3.99+"};
		String[] ratingList = { "...", "Highet Rating", "Lowest Rating"};
		ArrayList<Application> outstandingList = new ArrayList<Application>();
		
		
		
		Application app1 = new Application("fun1", "000232", "Tech", "English", "08-21-2020", 1, 10, 0.99, 4.3, 2.99, true);
		outstandingList.add(app1);
		
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
		
		JLabel addLabel = new JLabel("Submit Upload Request");
		addLabel.setForeground(Color.white);
		addLabel.setBounds(640, 330, 200, 20);
		
		JButton addButton = new JButton("Add");
		addButton.setBounds(640, 360, 100, 20);
		f.add(addButton);
		f.add(addLabel);
		
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel tempPanel = new JPanel();
				JTextField appnameField = new JTextField(10);
			    JTextField appuidField = new JTextField(10);
				tempPanel.add(new JLabel("App Name:"));
			    tempPanel.add(appnameField);
			    tempPanel.add(Box.createHorizontalStrut(15)); // a spacer
			    tempPanel.add(new JLabel("App UID:"));
			    tempPanel.add(appuidField);
			    
			    JTextField categoryField = new JTextField(10);
			    JTextField languageField = new JTextField(10);
				tempPanel.add(new JLabel("Category:"));
			    tempPanel.add(categoryField);
			    tempPanel.add(Box.createHorizontalStrut(15)); // a spacer
			    tempPanel.add(new JLabel("Language:"));
			    tempPanel.add(languageField);
			    
			    JTextField publishField = new JTextField(10);
			    JTextField versionField = new JTextField(10);
				tempPanel.add(new JLabel("Publish:"));
			    tempPanel.add(publishField);
			    tempPanel.add(Box.createHorizontalStrut(15)); // a spacer
			    tempPanel.add(new JLabel("Version:"));
			    tempPanel.add(versionField);
			    
			    JTextField ageField = new JTextField(10);
			    JTextField priceField = new JTextField(10);
				tempPanel.add(new JLabel("Recommended Age:"));
			    tempPanel.add(ageField);
			    tempPanel.add(Box.createHorizontalStrut(15)); // a spacer
			    tempPanel.add(new JLabel("Price:"));
			    tempPanel.add(priceField);
			    
			    JTextField ratingField = new JTextField(10);
			    JTextField sizeField = new JTextField(10);
				tempPanel.add(new JLabel("Rating"));
			    tempPanel.add(ratingField);
			    tempPanel.add(Box.createHorizontalStrut(15)); // a spacer
			    tempPanel.add(new JLabel("Size:"));
			    tempPanel.add(sizeField);
			    
			    JTextField compatabilityField = new JTextField(10);
				tempPanel.add(new JLabel("Compatibile with Andriod:"));
			    tempPanel.add(compatabilityField);

			    
				int good = JOptionPane.showConfirmDialog(null, tempPanel, "Enter App Data: ", JOptionPane.OK_CANCEL_OPTION);
				
				String appName = appnameField.getText();
				String appUID = appuidField.getText();
				String appCategory = categoryField.getText();
				String appLanguage = languageField.getText();
				String appPublish = publishField.getText();
				String appVersion = versionField.getText();
				String appAge = ageField.getText();
				String appPrice = priceField.getText();
				String ratingName = ratingField.getText();
				String appSize = sizeField.getText();
				String appCompatability = compatabilityField.getText();
				
				try {
				outstandingList.add(new Application(appName, appUID, appCategory, appLanguage, appPublish, Integer.parseInt(appVersion), Integer.parseInt(appAge), Double.parseDouble(appPrice), Double.parseDouble(ratingName), 
						Double.parseDouble(appSize), Boolean.parseBoolean(appCompatability)));
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
		});
		
		
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = search.getText();
				IandO.searchResults(resultTestList, returnArea, text);
			}
		});
		JButton outStandingList = new JButton("Oustanding Requests");
		outStandingList.setBounds(640, 450, 200, 20);
		
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
					JOptionPane.showMessageDialog(f, "unsuccessful Login");
					loggedIn = 0;
				} else if (IandO.checkUser(username, password) == 1){
					JOptionPane.showMessageDialog(f, "Successful Login");
					loggedIn = 1;
				} else if (IandO.checkUser(username, password) == 2){
					JOptionPane.showMessageDialog(f, "Moderator Login Successful");
					loggedIn = 2;
				} else {
					JOptionPane.showMessageDialog(f, "Administrator Login Successful");
					loggedIn = 3;
					f.setVisible(false);
					f.add(outStandingList);
					f.setVisible(true);
				}
			}
		});
		
		outStandingList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame outstandingFrame = new JFrame();
				outstandingFrame.setContentPane(new Background_Panel(backgroundImage));

				ArrayList<String> tempList = new ArrayList<String>();
				
				for (Application app : outstandingList) {
					tempList.add(app.toString());
				}
				
				ArrayList<String> nameList = new ArrayList<String>();
				
				for (Application app : outstandingList) {
					nameList.add(app.getAppName());
				}
				
				
				JLabel outstandingLabel = new JLabel("List of Applications:");
				outstandingLabel.setForeground(Color.white);
				outstandingLabel.setBounds(20, 20, 600, 20);
				
				JTextArea outstandingArea = new JTextArea();
				outstandingArea.setBounds(20, 50, 750, 300);
				IandO.printToResults(tempList, outstandingArea);
				
				JButton approveButton = new JButton("Approve");
				approveButton.setBounds(20, 440, 100, 20);
				outstandingFrame.add(approveButton);

				approveButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JPanel tempPanel = new JPanel();
						JTextField appnameField = new JTextField(10);
						tempPanel.add(new JLabel("App Name"));
					    tempPanel.add(appnameField);

						int good = JOptionPane.showConfirmDialog(null, tempPanel, "Enter appname: ", JOptionPane.OK_CANCEL_OPTION);
						String appname = appnameField.getText();


						if (nameList.contains(appname)) {
							JOptionPane.showMessageDialog(f, "Successful Addition");
							// Add app to list
						} else {
							JOptionPane.showMessageDialog(f, "Unsuccessful Addition");
						}
						outstandingFrame.setVisible(false);
						IandO.printToResults(tempList, outstandingArea);
						outstandingFrame.setVisible(true);

					}
					
				});
				
				JButton removeButton = new JButton("Remove");
				removeButton.setBounds(140, 440, 100, 20);
				outstandingFrame.add(removeButton);

				removeButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JPanel tempPanel = new JPanel();
						JTextField appnameField = new JTextField(10);
						tempPanel.add(new JLabel("App Name"));
					    tempPanel.add(appnameField);

						int good = JOptionPane.showConfirmDialog(null, tempPanel, "Enter appname: ", JOptionPane.OK_CANCEL_OPTION);
						String appname = appnameField.getText();


						if (nameList.contains(appname)) {
							JOptionPane.showMessageDialog(f, "Successful Deletion");
							// remove app from outstanding list
							int loc = nameList.indexOf(appname);
							tempList.remove(loc);
							nameList.remove(loc);
							outstandingList.remove(loc);
							outstandingArea.setText("");
							
						} else {
							JOptionPane.showMessageDialog(f, "Unsuccessful Deletion");
						}
						
						outstandingFrame.setVisible(false);
						IandO.printToResults(tempList, outstandingArea);
						outstandingFrame.setVisible(true);
					}
					
				});
				
				
				outstandingFrame.add(outstandingLabel);
				outstandingFrame.add(outstandingArea);
				outstandingFrame.setSize(800,520);
				outstandingFrame.setLayout(null);
				outstandingFrame.setVisible(true);
			}
		});
		
		System.out.println(loggedIn);
		f.setSize(1000,680);
		f.setLayout(null);
		f.setVisible(true);
		
		
	}
	
	private void loadApp() {
		
		RandomAccessFile raf = null;
		
		try {
			app = new ArrayList<Application>();
			raf = new RandomAccessFile("AppSample.txt", "r");
			raf.readLine();
			while (raf.getFilePointer() < raf.length()) {
				Application a = new Application(raf);
				app.add(a);
			}
			raf.close();
			
//			for (Application a : app)
//				System.out.println(a);
			
		} catch (Exception e) {
			System.out.println("Error with raf");
		} finally {
			try { raf.close(); } catch (Exception e) {}
		}
	}
	
}
