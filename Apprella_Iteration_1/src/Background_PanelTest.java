import static org.junit.jupiter.api.Assertions.*;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import org.junit.jupiter.api.Test;

class Background_PanelTest {

	@Test
	void testBackground_Panel() {
		Background_Panel b = new Background_Panel(null);
		assertEquals(null, b.getImage());
	}

	@Test
	void testGetImage() {
		BufferedImage bImage = null;
		Background_Panel b = new Background_Panel(bImage);
		assertEquals(null, b.getImage());
	}

	@Test
	void testSetImage() throws IOException {
		BufferedImage bImage = null;
		BufferedImage cImage = ImageIO.read(new File("background_temp.jpeg"));
		Background_Panel b = new Background_Panel(bImage);
		b.setImage(cImage);
		assertEquals(cImage, b.getImage());
	}

}
