import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class inputOutputGUI {

	private HashMap<String, String> users;
	private HashMap<String, String> moderators;
	private HashMap<String, String> administrators;

	public inputOutputGUI() {
		users = new HashMap<String, String>();
		users.put("trello_1", "0123456789");
		moderators = new HashMap<String, String>();
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
	public void searchResults(ArrayList<String> list, JTextArea textArea, String str, JFrame j, ArrayList<Application> app, int num) 
	{
		for (Application element : app)
		{
			if(element.getAppName().contains(str) || str.equals(element.getAppName()))
			{
				JFrame frameSearch = new JFrame();
				
				BufferedImage backgroundImage = null;
				try {
					backgroundImage = ImageIO.read(new File("background_temp.jpeg"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				frameSearch.setContentPane(new Background_Panel(backgroundImage));

				JLabel initLabel = new JLabel("App Searched for:");
				initLabel.setForeground(Color.white);
				initLabel.setBounds(20, 20, 200, 20);
				
				
				JLabel nameLabel = new JLabel("App Name:");
				nameLabel.setForeground(Color.white);
				nameLabel.setBounds(20, 40, 100, 20);
				JLabel appNameLabel = new JLabel(element.getAppName());
				appNameLabel.setForeground(Color.white);
				appNameLabel.setBounds(120, 40, 100, 20);
				JLabel uidLabel = new JLabel("App UID:");
				uidLabel.setForeground(Color.white);
				uidLabel.setBounds(20, 80, 100, 20);
				JLabel appUidLabel = new JLabel(element.getAppUID());
				appUidLabel.setForeground(Color.white);
				appUidLabel.setBounds(120, 80, 100, 20);
				JLabel categoryLabel = new JLabel("Category");
				categoryLabel.setForeground(Color.white);
				categoryLabel.setBounds(20, 120, 100, 20);
				JLabel appCategoryLabel = new JLabel(element.getCategory());
				appCategoryLabel.setForeground(Color.white);
				appCategoryLabel.setBounds(120, 120, 100, 20);
				JLabel languageLabel = new JLabel("Language:");
				languageLabel.setForeground(Color.white);
				languageLabel.setBounds(20, 160, 100, 20);
				JLabel appLanguageLabel = new JLabel(element.getLanguage());
				appLanguageLabel.setForeground(Color.white);
				appLanguageLabel.setBounds(120, 160, 100, 20);
				JLabel publishLabel = new JLabel("Publish Date:");
				publishLabel.setForeground(Color.white);
				publishLabel.setBounds(20, 200, 100, 20);
				JLabel appPublishLabel = new JLabel(element.getPublishDate());
				appPublishLabel.setForeground(Color.white);
				appPublishLabel.setBounds(120, 200, 100, 20);
				JLabel versionLabel = new JLabel("Version:");
				versionLabel.setForeground(Color.white);
				versionLabel.setBounds(20, 240, 100, 20);
				JLabel appVersionLabel = new JLabel("" + element.getVersion());
				appVersionLabel.setForeground(Color.white);
				appVersionLabel.setBounds(120, 240, 100, 20);
				JLabel ageLabel = new JLabel("Recommended Age:");
				ageLabel.setForeground(Color.white);
				ageLabel.setBounds(20, 280, 100, 20);
				JLabel appAgeLabel = new JLabel("" + element.getRecommendAge());
				appAgeLabel.setForeground(Color.white);
				appAgeLabel.setBounds(120, 280, 100, 20);
				JLabel priceLabel = new JLabel("Price:");
				priceLabel.setForeground(Color.white);
				priceLabel.setBounds(20, 320, 100, 20);
				JLabel appPriceLabel = new JLabel("" + element.getPrice());
				appPriceLabel.setForeground(Color.white);
				appPriceLabel.setBounds(120, 320, 100, 20);
				JLabel ratingLabel = new JLabel("Rating:");
				ratingLabel.setForeground(Color.white);
				ratingLabel.setBounds(20, 360, 100, 20);
				JLabel appRatingLabel = new JLabel("" + element.getRating());
				appRatingLabel.setForeground(Color.white);
				appRatingLabel.setBounds(120, 360, 100, 20);
				JLabel sizeLabel = new JLabel("Size:");
				sizeLabel.setForeground(Color.white);
				sizeLabel.setBounds(20, 400, 100, 20);
				JLabel appSizeLabel = new JLabel("" + element.getSize());
				appSizeLabel.setForeground(Color.white);
				appSizeLabel.setBounds(120, 400, 100, 20);
				JLabel compatLabel = new JLabel("Android Compatable:");
				compatLabel.setForeground(Color.white);
				compatLabel.setBounds(20, 440, 120, 20);
				JLabel appCompatLabel = new JLabel("" + element.isCompatibility());
				appCompatLabel.setForeground(Color.white);
				appCompatLabel.setBounds(140, 440, 100, 20);
				if (num > 0) {
				JButton comment = new JButton("Comment");
				comment.setBounds(20, 480, 100, 20);
				
				frameSearch.add(comment);

				comment.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JFrame frame = new JFrame("Comments");
						frame.setSize(400, 400);

						JMenuBar menuB = new JMenuBar();
						JMenu menuB1 = new JMenu("Go back");
						JMenu menuB2 = new JMenu("Help");
						menuB.add(menuB1);
						menuB.add(menuB2);
						JMenuItem menuB11 = new JMenuItem("Yes");
						JMenuItem menuB22 = new JMenuItem("Open");
						menuB1.add(menuB11);
						menuB2.add(menuB22);

						JPanel panel = new JPanel();
						
						
						JLabel label = new JLabel("Leave Comment");
						
						JTextField textF = new JTextField(10);
						JButton send = new JButton("Send");
						JButton reset = new JButton("Delete");
						panel.add(label);
						panel.add(textF);
						panel.add(send);
						if (num > 1) {
							panel.add(reset);
						}
						JTextArea textA = new JTextArea();

						Vector<String> store = new Vector<String>();
						
						
						
						String fileName = element.getAppUID() + "-comments.bin";
						ScoreCard sc = new ScoreCard(fileName);
						
						store.add(sc.toString());
						textA.append(sc.toString());
						frame.setVisible(true);
						frame.setVisible(false);

						
						send.addActionListener((ActionListener) new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								if (!textF.getText().isEmpty()) {
									// store.add(textF.getText());
									sc.addComment(element.getAppUID(), textF.getText());
								}
								textA.selectAll();
								textA.replaceSelection("");
								textA.append(sc.toString());
								textF.setText("");}});
						reset.addActionListener((ActionListener) new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								if (store.size() > 0) {
									store.remove(store.size() - 1);
								}
								sc.clearComment();
								textA.selectAll();
								textA.replaceSelection("");
								Iterator<String> value = store.iterator();
								while (value.hasNext()) {
									textA.append(value.next() + "\n");}}});

						frame.getContentPane().add(BorderLayout.SOUTH, panel);
						frame.getContentPane().add(BorderLayout.NORTH, menuB);
						frame.getContentPane().add(BorderLayout.CENTER, textA);
						frame.setVisible(true);
						
					}
					
				});
				
				} else {
					JLabel comment = new JLabel("Login to Comment");
					comment.setBounds(20, 480, 150, 20);
					comment.setForeground(Color.white);
					frameSearch.add(comment);
				}
				frameSearch.add(initLabel);
				frameSearch.add(nameLabel);
				frameSearch.add(appNameLabel);
				frameSearch.add(uidLabel);
				frameSearch.add(appUidLabel);
				frameSearch.add(categoryLabel);
				frameSearch.add(appCategoryLabel);
				frameSearch.add(languageLabel);
				frameSearch.add(appLanguageLabel);
				frameSearch.add(publishLabel);
				frameSearch.add(appPublishLabel);
				frameSearch.add(versionLabel);
				frameSearch.add(appVersionLabel);
				frameSearch.add(ageLabel);
				frameSearch.add(appAgeLabel);
				frameSearch.add(priceLabel);
				frameSearch.add(appPriceLabel);
				frameSearch.add(ratingLabel);
				frameSearch.add(appRatingLabel);
				frameSearch.add(sizeLabel);
				frameSearch.add(appSizeLabel);
				frameSearch.add(compatLabel);
				frameSearch.add(appCompatLabel);
				
				
				frameSearch.setSize(1000,680);
				frameSearch.setLayout(null);
				frameSearch.setVisible(true);
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
