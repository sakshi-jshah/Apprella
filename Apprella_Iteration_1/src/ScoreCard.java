import java.awt.Font;
import java.awt.TrayIcon.MessageType;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;


/**
 * Class to represent and store comments
 * @author Apprella Dev Team: Benjamin Lovick, Bryson Tilford, Lucia Beckman, Pu Ji, Sakshi Shah
 *
 */
public class ScoreCard {
	
	//------------------------------
	private final static String DEFAULT_FILENAME = "comments.bin";
	private final static int DEFAULT_LISTSIZE = 10;
	
	private ArrayList<Comment> cs = new ArrayList<>();
	private String fileName;
	private int listSize;
	
	//------------------------------
	/**
	 * Constructor that sets variables to default values
	 */
	public ScoreCard() {
		this(DEFAULT_FILENAME, DEFAULT_LISTSIZE);
	}
	
	/**
	 * Constructor that takes in a filename
	 * @param fileName the name of the file
	 */
	public ScoreCard(String fileName) {
		this(fileName, DEFAULT_LISTSIZE);
	}
	
	/**
	 * Constructor that sets the size of the list
	 * @param listSize the list size
	 */
	public ScoreCard(int listSize) {
		this(DEFAULT_FILENAME, listSize);
	}
	
	/**
	 * Constructor that uses filename and list size
	 * @param fileName the inputed filename
	 * @param listSize the inputed list size
	 */
	public ScoreCard(String fileName, int listSize) {
		setFileName(fileName);
		setListSize(listSize);
		load();
	}
	
	//------------------------------
	/**
	 * Method to add a comment
	 * @param uid uid of application
	 * @param com the comment
	 */
	public void addComment(String uid, String com) {
		addComment(new Comment(uid, com));
	}
	
	/**
	 * Method to add a comment
	 * @param c comment to be added
	 */
	public void addComment(Comment c) {
		cs.add(c.clone());
		save();
	}
	
	/**
	 * Method to clear all comments
	 */
	public void clearComment() {
		cs.clear();
	}
	
	/**
	 * Method to delete the file
	 */
	public void deleteScoreFile() {
		(new File(fileName)).delete();
	}
	
	/**
	 * Method to save the comments
	 */
	public void save() {
		deleteScoreFile();
		RandomAccessFile raf = null;
		
		try {
			raf = new RandomAccessFile(fileName, "rw");
			for (Comment c : cs) c.save(raf);
		} catch (Exception e) {
			System.out.println("Error with raf");
		} finally {
			try {raf.close();} catch (Exception e) {}
		}
	}
	
	/**
	 * Method to save the comments
	 */
	public void load() {
		if (!(new File(fileName)).exists()) return;
		
		RandomAccessFile raf = null;
		clearComment();
		try {
			raf = new RandomAccessFile(fileName, "r");
			while(raf.getFilePointer() < raf.length())
				cs.add(new Comment(raf));
		} catch (Exception e) {
			System.out.println("Error with raf");
		} finally {
			try {raf.close();} catch (Exception e) {}
		}
	}
	
	/**
	 * Method that returns a string representation of the object
	 */
	@Override
	public String toString() {
		String ret = "";
		int i = 0;
		for (Comment c : cs) {
			if (++i > listSize) break;
			ret += String.format("%5d) %s\n", i, c); 
		}
		return ret;
	}
	
	
	//------------------------------
	/**
	 * Method to get the file name
	 * @return the filename
	 */
	public String getFileName() { return fileName; }
	
	/**
	 * Method to get the list size
	 * @return the list size
	 */
	public int getListSize()	{ return listSize; }
	
	/**
	 * Method to set the filename
	 * @param fileName the new filename
	 */
	public void setFileName(String fileName) {
		fileName = fileName.toLowerCase().trim();
		if (fileName.length() == 0) fileName = DEFAULT_FILENAME;
		if (!fileName.contains(".")) fileName += ".bin";
		if (fileName.startsWith(".")) fileName = "comments" + fileName;
		this.fileName = fileName;
	}
	
	/**
	 * Method to set the size
	 * @param listSize the new size
	 */
	public void setListSize(int listSize) {
		this.listSize = (listSize < 2 ? 2 : listSize);
	}
	
	
	//===================================================
	//===================================================
	
	/**
	 * Helper class to allow for commenting
	 * @author Apprella Dev Team: Benjamin Lovick, Bryson Tilford, Lucia Beckman, Pu Ji, Sakshi Shah
	 *
	 */
	private class Comment {
		
		//=========================
		private String uid;
		private String com;
		
		//=========================
		/**
		 * Constructor that creates a comment
		 * @param uid inputed uid
		 * @param com inputed comment
		 */
		public Comment(String uid, String com) {
			this.uid = uid;
			this.com = com;
		}
		
		/**
		 * Constructor that creates a comment from a raf
		 * @param raf inputed raf
		 * @throws Exception
		 */
		public Comment(RandomAccessFile raf) throws Exception {
			uid = raf.readUTF();
			com = raf.readUTF();
		}
		
		//=========================
		/**
		 * Method to save the comment to a RandomAccessFile
		 * @param raf the inputed raf
		 * @throws Exception
		 */
		public void save(RandomAccessFile raf) throws Exception {
			raf.writeUTF(uid);
			raf.writeUTF(com);
		}
		
		/**
		 * Method to clone a comment
		 */
		public Comment clone() {
			return new Comment(uid, com);
		}
		
		/**
		 * Method that returns a string representation of the object
		 */
		@Override
		public String toString() {
			return String.format("%-9s: %s", uid, com);
		}
		
	}
	
}
