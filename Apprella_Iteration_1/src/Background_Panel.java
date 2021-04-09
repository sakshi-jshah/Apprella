import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JTextArea;

public class Background_Panel extends JComponent {
	private Image image;
	
	public Background_Panel(Image image) {
		this.image = image;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
	

}
