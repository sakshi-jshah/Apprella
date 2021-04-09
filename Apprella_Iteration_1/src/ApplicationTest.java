import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ApplicationTest {

	@Test
	void testApplicationStringStringStringStringStringStringIntDoubleDoubleDoubleBoolean() {
		Application a = new Application("Among Us", "1234", "Game", "1.0", "English", "May 15, 2021", 12, 0.0, 5.0, 3.1, false) {
		};
		assertEquals("Among Us", a.getAppName());
		assertEquals("1234", a.getAppUID());
		assertEquals("Game", a.getCategory());
		assertEquals("1.0", a.getVersion());
		assertEquals("English", a.getLanguage());
		assertEquals("May 15, 2021", a.getPublishDate());
		assertEquals(12, a.getRecommendAge());
		assertEquals(0.0, a.getPrice());
		assertEquals(5.0, a.getRating());
		assertEquals(3.1, a.getSize());
		assertFalse(a.isCompatibility());
	}

	@Test
	void testApplicationApplication() {
		Application a = new Application("Among Us", "1234", "Game", "1.0", "English", "May 15, 2021", 12, 0.0, 5.0, 3.1, false) {};
		Application b = new Application(a) {};
		assertEquals("Among Us", b.getAppName());
		assertEquals("1234", b.getAppUID());
		assertEquals("Game", b.getCategory());
		assertEquals("1.0", b.getVersion());
		assertEquals("English", b.getLanguage());
		assertEquals("May 15, 2021", b.getPublishDate());
		assertEquals(12, b.getRecommendAge());
		assertEquals(0.0, b.getPrice());
		assertEquals(5.0, b.getRating());
		assertEquals(3.1, b.getSize());
		assertFalse(b.isCompatibility());
	}


	@Test
	void testToString() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAppName() {
		Application a = new Application("Among Us", "1234", "Game", "1.0", "English", "May 15, 2021", 12, 0.0, 5.0, 3.1, false) {};
		assertEquals("Among Us", a.getAppName());
	}

	@Test
	void testSetAppName() {
		Application a = new Application("Among Us", "1234", "Game", "1.0", "English", "May 15, 2021", 12, 0.0, 5.0, 3.1, false) {};
		a.setAppName("Minecraft");
		assertEquals("Minecraft", a.getAppName());
	}

	@Test
	void testGetAppUID() {
		Application a = new Application("Among Us", "1234", "Game", "1.0", "English", "May 15, 2021", 12, 0.0, 5.0, 3.1, false) {};
		assertEquals("1234", a.getAppUID());
	}

	@Test
	void testSetAppUID() {
		Application a = new Application("Among Us", "1234", "Game", "1.0", "English", "May 15, 2021", 12, 0.0, 5.0, 3.1, false) {};
		a.setAppUID("12345");
		assertEquals("12345", a.getAppUID());
	}

	@Test
	void testGetCategory() {
		Application a = new Application("Among Us", "1234", "Game", "1.0", "English", "May 15, 2021", 12, 0.0, 5.0, 3.1, false) {};
		assertEquals("Game", a.getCategory());
	}

	@Test
	void testSetCategory() {
		Application a = new Application("Among Us", "1234", "Game", "1.0", "English", "May 15, 2021", 12, 0.0, 5.0, 3.1, false) {};
		a.setCategory("Action");
		assertEquals("Action", a.getCategory());
	}

	@Test
	void testGetVersion() {
		Application a = new Application("Among Us", "1234", "Game", "1.0", "English", "May 15, 2021", 12, 0.0, 5.0, 3.1, false) {};
		assertEquals("1.0", a.getVersion());
	}

	@Test
	void testSetVersion() {
		Application a = new Application("Among Us", "1234", "Game", "1.0", "English", "May 15, 2021", 12, 0.0, 5.0, 3.1, false) {};
		a.setVersion("2.5");
		assertEquals("2.5", a.getVersion());
	}

	@Test
	void testGetLanguage() {
		Application a = new Application("Among Us", "1234", "Game", "1.0", "English", "May 15, 2021", 12, 0.0, 5.0, 3.1, false) {};
		assertEquals("English", a.getLanguage());
	}

	@Test
	void testSetLanguage() {
		Application a = new Application("Among Us", "1234", "Game", "1.0", "English", "May 15, 2021", 12, 0.0, 5.0, 3.1, false) {};
		a.setLanguage("French");
		assertEquals("French", a.getLanguage());
	}

	@Test
	void testGetPublishDate() {
		Application a = new Application("Among Us", "1234", "Game", "1.0", "English", "May 15, 2021", 12, 0.0, 5.0, 3.1, false) {};
		assertEquals("May 15, 2021", a.getPublishDate());
	}

	@Test
	void testSetPublishDate() {
		Application a = new Application("Among Us", "1234", "Game", "1.0", "English", "May 15, 2021", 12, 0.0, 5.0, 3.1, false) {};
		a.setPublishDate("April 1, 2021");
		assertEquals("April 1, 2021", a.getPublishDate());
	}

	@Test
	void testGetRecommendAge() {
		Application a = new Application("Among Us", "1234", "Game", "1.0", "English", "May 15, 2021", 12, 0.0, 5.0, 3.1, false) {};
		assertEquals(12, a.getRecommendAge());
	}

	@Test
	void testSetRecommendAge() {
		Application a = new Application("Among Us", "1234", "Game", "1.0", "English", "May 15, 2021", 12, 0.0, 5.0, 3.1, false) {};
		a.setRecommendAge(5);
		assertEquals(5, a.getRecommendAge());
	}

	@Test
	void testGetPrice() {
		Application a = new Application("Among Us", "1234", "Game", "1.0", "English", "May 15, 2021", 12, 0.0, 5.0, 3.1, false) {};
		assertEquals(0.0, a.getPrice());
	}

	@Test
	void testSetPrice() {
		Application a = new Application("Among Us", "1234", "Game", "1.0", "English", "May 15, 2021", 12, 0.0, 5.0, 3.1, false) {};
		a.setPrice(2.99);
		assertEquals(2.99, a.getPrice());
	}

	@Test
	void testGetRating() {
		Application a = new Application("Among Us", "1234", "Game", "1.0", "English", "May 15, 2021", 12, 0.0, 5.0, 3.1, false) {};
		assertEquals(5.0, a.getRating());
	}

	@Test
	void testSetRating() {
		Application a = new Application("Among Us", "1234", "Game", "1.0", "English", "May 15, 2021", 12, 0.0, 5.0, 3.1, false) {};
		a.setRating(0.0);
		assertEquals(0.0, a.getRating());
	}

	@Test
	void testGetSize() {
		Application a = new Application("Among Us", "1234", "Game", "1.0", "English", "May 15, 2021", 12, 0.0, 5.0, 3.1, false) {};
		assertEquals(3.1, a.getSize());
	}

	@Test
	void testSetSize() {
		Application a = new Application("Among Us", "1234", "Game", "1.0", "English", "May 15, 2021", 12, 0.0, 5.0, 3.1, false) {};
		a.setSize(5.9);
		assertEquals(5.9, a.getSize());
	}

	@Test
	void testIsCompatibility() {
		Application a = new Application("Among Us", "1234", "Game", "1.0", "English", "May 15, 2021", 12, 0.0, 5.0, 3.1, false) {};
		assertFalse(a.isCompatibility());
	}

	@Test
	void testSetCompatibility() {
		Application a = new Application("Among Us", "1234", "Game", "1.0", "English", "May 15, 2021", 12, 0.0, 5.0, 3.1, false) {};
		a.setCompatibility(true);
		assertTrue(a.isCompatibility());
	}

}
