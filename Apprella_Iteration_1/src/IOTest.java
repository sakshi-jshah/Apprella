import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

public class IOTest {
	
	
	@Test
	void testLogin() {
		inputOutputGUI IO = new inputOutputGUI();
		System.out.println("running");
		assertEquals(true, IO.checkUser("trello_1", "0123456789"));
		assertEquals(false, IO.checkUser("trello", "0123456789"));
		assertEquals(false, IO.checkUser("trello_1", "012356789"));
	}
}
