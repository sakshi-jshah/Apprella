import java.awt.Font;
import java.awt.TrayIcon.MessageType;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;



public class ScoreCard {
	
	//------------------------------
	private final static String DEFAULT_FILENAME = "comments.bin";
	private final static int DEFAULT_LISTSIZE = 10;
	
	private ArrayList<Comment> cs = new ArrayList<>();
	private String fileName;
	private int listSize;
	
	//------------------------------
	public ScoreCard() {
		this(DEFAULT_FILENAME, DEFAULT_LISTSIZE);
	}
	
	public ScoreCard(String fileName) {
		this(fileName, DEFAULT_LISTSIZE);
	}
	
	public ScoreCard(int listSize) {
		this(DEFAULT_FILENAME, listSize);
	}
	
	public ScoreCard(String fileName, int listSize) {
		setFileName(fileName);
		setListSize(listSize);
		load();
	}
	
	//------------------------------
	public void addComment(String uid, String com) {
		addComment(new Comment(uid, com));
	}
	
	public void addComment(Comment c) {
		cs.add(c.clone());
		save();
	}
	
	public void clearComment() {
		cs.clear();
	}
	
	public void deleteScoreFile() {
		(new File(fileName)).delete();
	}
	
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
	
	
	
	
	//------------------------------
	public String getFileName() { return fileName; }
	public int getListSize()	{ return listSize; }
	
	public void setFileName(String fileName) {
		fileName = fileName.toLowerCase().trim();
		if (fileName.length() == 0) fileName = DEFAULT_FILENAME;
		if (!fileName.contains(".")) fileName += ".bin";
		if (fileName.startsWith(".")) fileName = "comments" + fileName;
		this.fileName = fileName;
	}
	
	public void setListSize(int listSize) {
		this.listSize = (listSize < 2 ? 2 : listSize);
	}
	
	
	//===================================================
	//===================================================
	
	private class Comment {
		
		//=========================
		private String uid;
		private String com;
		
		//=========================
		public Comment(String uid, String com) {
			this.uid = uid;
			this.com = com;
		}
		
		public Comment(RandomAccessFile raf) throws Exception {
			uid = raf.readUTF();
			com = raf.readUTF();
		}
		
		//=========================
		public void save(RandomAccessFile raf) throws Exception {
			raf.writeUTF(uid);
			raf.writeUTF(com);
		}
		
		public Comment clone() {
			return new Comment(uid, com);
		}
		
		@Override
		public String toString() {
			return String.format("%-9s: %s", uid, com);
		}
		
	}
	
}
