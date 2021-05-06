import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * A class that is the main section of the Apprella application
 * @author Apprella Dev Team: Benjamin Lovick, Bryson Tilford, Lucia Beckman, Pu Ji, Sakshi Shah
 *
 */
public class Panel {
	private static int loggedIn;
	
	private static ArrayList<Application> app;
	private static ArrayList<Application> outstandingList;
	private static ArrayList<Application> tempAdded;
	
	/**
	 * Main method that will run the main application
	 * @param args
	 * @throws IOException
	 */
	public static void main(String args[]) throws IOException {
		String[] genreList = { "...", "Art & Design", "Beauty", "Books", "Business", "Communication", "Education", "Music", "Networking"};
		String[] priceList = { "...", "Free", "$0.99+", "$1.99+", "$2.99+", "$3.99+"};
		String[] ratingList = { "...", "Highet Rating", "Lowest Rating"};
		outstandingList = new ArrayList<Application>();
		ArrayList<Application> tempAdded = new ArrayList<Application>();
		
		// Load the database in
		loadApp();
		
		// Load the oustanding list in
		loadOutstanding();

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
		
		// Creating sorting ability
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
		
		// Creating upload request button
		JLabel addLabel = new JLabel("Submit Upload Request");
		addLabel.setForeground(Color.white);
		addLabel.setBounds(640, 330, 200, 20);
		
		JButton addButton = new JButton("Add");
		addButton.setBounds(640, 360, 100, 20);
		f.add(addButton);
		f.add(addLabel);
		
		
		// Action listener that allows for entry of data into upload request
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel tempPanel = new JPanel();
				JTextField appnameField = new JTextField(10);
			    JTextField appuidField = new JTextField(10);
				tempPanel.add(new JLabel("App Name:"));
			    tempPanel.add(appnameField);
			    tempPanel.add(Box.createHorizontalStrut(15));
			    tempPanel.add(new JLabel("App UID:"));
			    tempPanel.add(appuidField);
			    
			    JTextField categoryField = new JTextField(10);
			    JTextField languageField = new JTextField(10);
				tempPanel.add(new JLabel("Category:"));
			    tempPanel.add(categoryField);
			    tempPanel.add(Box.createHorizontalStrut(15));
			    tempPanel.add(new JLabel("Language:"));
			    tempPanel.add(languageField);
			    
			    JTextField publishField = new JTextField(10);
			    JTextField versionField = new JTextField(10);
				tempPanel.add(new JLabel("Publish:"));
			    tempPanel.add(publishField);
			    tempPanel.add(Box.createHorizontalStrut(15));
			    tempPanel.add(new JLabel("Version:"));
			    tempPanel.add(versionField);
			    
			    JTextField ageField = new JTextField(10);
			    JTextField priceField = new JTextField(10);
				tempPanel.add(new JLabel("Recommended Age:"));
			    tempPanel.add(ageField);
			    tempPanel.add(Box.createHorizontalStrut(15));
			    tempPanel.add(new JLabel("Price:"));
			    tempPanel.add(priceField);
			    
			    JTextField ratingField = new JTextField(10);
			    JTextField sizeField = new JTextField(10);
				tempPanel.add(new JLabel("Rating"));
			    tempPanel.add(ratingField);
			    tempPanel.add(Box.createHorizontalStrut(15));
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
				
				System.out.println("" + appName + appUID + appCategory+ appLanguage+ appPublish+ Integer.parseInt(appVersion) + Integer.parseInt(appAge) + Double.parseDouble(appPrice) + Double.parseDouble(ratingName) + 
						Double.parseDouble(appSize) + Boolean.parseBoolean(appCompatability));
				
				try {
				outstandingList.add(new Application(appName, appUID, appCategory, appLanguage, appPublish, Integer.parseInt(appVersion), Integer.parseInt(appAge), Double.parseDouble(appPrice), Double.parseDouble(ratingName), 
						Double.parseDouble(appSize), Boolean.parseBoolean(appCompatability)));
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
		});
		
		// Action Listener to allow for ability to sort
		sortButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> results = null;
				if (genre.getSelectedItem().toString() != "...") {
					results = sortByType(genre);
				}
				IandO.printToResults(results, returnArea);
			}
		});
		
		// Action Listener that allows for searching function
		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = search.getText();
				int temp = loggedIn;
				IandO.searchResults(resultTestList, returnArea, text, f, app, temp);
			}
		});
		JButton outStandingList = new JButton("Oustanding Requests");
		outStandingList.setBounds(640, 450, 200, 20);
		
		/*
		 * Adding the ability to login
		 */
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel tempPanel = new JPanel();
				JTextField usernameField = new JTextField(10);
			    JTextField passwordField = new JTextField(10);
				tempPanel.add(new JLabel("Username:"));
			    tempPanel.add(usernameField);
			    tempPanel.add(Box.createHorizontalStrut(15)); // a spacer
			    tempPanel.add(new JLabel("Password:"));
			    tempPanel.add(passwordField);
				int good = JOptionPane.showConfirmDialog(null, tempPanel, "Enter Login Credentials: ", JOptionPane.OK_CANCEL_OPTION);
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
		
		// Action Listener that allows for the ability for Admins to see the outstanding list
		outStandingList.addActionListener(new ActionListener() {
			@Override
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

				// Action listener that allows for requests to be approved
				approveButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JPanel tempPanel = new JPanel();
						JTextField appnameField = new JTextField(10);
						tempPanel.add(new JLabel("App Name"));
					    tempPanel.add(appnameField);

						int good = JOptionPane.showConfirmDialog(null, tempPanel, "Enter appname: ", JOptionPane.OK_CANCEL_OPTION);
						String appname = appnameField.getText();

						if (nameList.contains(appname)) {
							JOptionPane.showMessageDialog(tempPanel, "Successful Addition");
							for (Application a : outstandingList) {
								if (a.getAppName().equals(appname)) {
									app.add(a);
									tempAdded.add(a);
								}
							}
						} else {
							JOptionPane.showMessageDialog(tempPanel, "Unsuccessful Addition");
						}
						outstandingFrame.setVisible(false);
						IandO.printToResults(tempList, outstandingArea);
						outstandingFrame.setVisible(true);

					}
					
				});
				
				JButton removeButton = new JButton("Remove");
				removeButton.setBounds(140, 440, 100, 20);
				outstandingFrame.add(removeButton);

				// Action listener that allows for requests to be removed
				removeButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JPanel tempPanel = new JPanel();
						JTextField appnameField = new JTextField(10);
						tempPanel.add(new JLabel("App Name"));
					    tempPanel.add(appnameField);

						int good = JOptionPane.showConfirmDialog(null, tempPanel, "Enter appname: ", JOptionPane.OK_CANCEL_OPTION);
						String appname = appnameField.getText();


						if (nameList.contains(appname)) {
							JOptionPane.showMessageDialog(tempPanel, "Successful Deletion");
							// remove app from outstanding list
							int loc = nameList.indexOf(appname);
							tempList.remove(loc);
							nameList.remove(loc);
							outstandingList.remove(loc);
							outstandingArea.setText("");
							
						} else {
							JOptionPane.showMessageDialog(tempPanel, "Unsuccessful Deletion");
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
		
		for (Application a : app) {
			System.out.println(a.toString());
		}
		f.setSize(1000,680);
		f.setLayout(null);
		f.setVisible(true);
		
		// Action listener to confirm exit of program
		f.addWindowListener(new WindowListener() {

	        @Override
	        public void windowClosed(WindowEvent e) {
	            if (JOptionPane.showConfirmDialog(f, "Are you sure you want to quit?", "Confirm exit.", JOptionPane.OK_OPTION, 0, new ImageIcon("")) != 0) {
	            	return;
	            }
	            saveApp();
	            System.exit(-1);
	        }

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				 if (JOptionPane.showConfirmDialog(f, "Are you sure you want to quit?", "Confirm exit.", JOptionPane.OK_OPTION, 0, new ImageIcon("")) != 0) {
		            	return;
		            }
				 saveApp();
		         System.exit(-1);
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

	    });
		
	}
	
	/**
	 * Method that loads the database into the application
	 */
	private static void loadApp() {
		
		RandomAccessFile raf = null;
		
		try {
			app = new ArrayList<Application>();
			raf = new RandomAccessFile("appIO", "r");
			raf.readLine();
			while (raf.getFilePointer() < raf.length()) {
				Application a = new Application(raf);
				app.add(a);
			}
			raf.close();
			
//			for (Application a : app)
//				System.out.println(a);
			
		} catch (Exception e) {
			System.out.println("Error with raf " + e);
		} finally {
			try { raf.close(); } catch (Exception e) {}
		}
	}
	
	/**
	 * Method that loads the outstanding list into the application
	 */
	private static void loadOutstanding() {
		
		RandomAccessFile raf = null;
		
		try {
			outstandingList = new ArrayList<Application>();
			raf = new RandomAccessFile("outstandingIO", "r");
			raf.readLine();
			while (raf.getFilePointer() < raf.length()) {
				Application a = new Application(raf);
				outstandingList.add(a);
			}
			raf.close();
			
//			for (Application a : app)
//				System.out.println(a);
			
		} catch (Exception e) {
			System.out.println("Error with raf " + e);
		} finally {
			try { raf.close(); } catch (Exception e) {}
		}
	}
	
	/**
	 * Method to sort by genre
	 * @param genre the genre
	 * @return strings that are the sorted apps
	 */
	private ArrayList<String> sortByPrice(JComboBox genre) {
		double readin = Double.parseDouble(genre.getSelectedItem().toString());
		String readout;
		
		ArrayList<String> result = new ArrayList<String>();
		
		for (Application a : app) {
			if (readin >= a.getPrice()) {
				result.add(a.getAppName());
			}
		}
		return result;
	}

	/**
	 * Method to sort by type
	 * @param genre the genre type
	 * @return strings that are the sorted apps
	 */
	private static ArrayList<String> sortByType(JComboBox genre) {
		String ret = genre.getSelectedItem().toString();
		
		ArrayList<String> result = new ArrayList<String>();
		
		for (Application a : app) {
			if (ret.equals(a.getCategory())) {
				result.add(a.getAppName());
			}
		}
		return result;
	}
	

	/**
	 * Method to save the data back into the database (NOT WORKING AT CURRENT VERSION)
	 */
	private static void saveApp() {
		
		//(new File("appIO")).delete();
		//RandomAccessFile raf = null;
	
		try {
			//raf = new RandomAccessFile("appIO", "rw");
			//raf.writeUTF("appName\tappUID\tcategory\tlanguage\tpublishDate\tversion\trecommendAge\tprice\trating\tsize\tcompatibility\n");
			for (Application a : app) {
				System.out.println(a.toString());
				//raf.writeUTF(a.getAppName() + "\t" + a.getAppUID() + "\t" + a.getCategory() + "\t" + a.getLanguage() + "\t" + a.getPublishDate() + "\t" + a.getVersion() + "\t" + a.getRecommendAge() + "\t" + a.getPrice() + "\t" + a.getRating() + "\t" + a.getSize() + "\t" + a.isCompatibility() + "\n");
			}
		} catch (Exception e) {
			System.out.println("Error with raf");
		} finally {
			//try {raf.close();} catch (Exception e) {}
		}
	
}
}
