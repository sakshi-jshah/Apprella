import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class ApplicationTest {

	private static Application app1 = new Application(
			"Apprella", "APRT1", "Search", "Eng", "04/08/2021",
			1, 10, 0.00, 5.00, 2.89, true
			);
	
	private static Application app2 = new Application(app1);
	private static Application app3 = new Application(app1);
	
	@Test
	void testApplication() {
		assertEquals("Apprella", 	app1.getAppName());
		assertEquals("APRT1", 	    app1.getAppUID());
		assertEquals("Search", 	    app1.getCategory());
		assertEquals("Eng", 	    app1.getLanguage());
		assertEquals("04/08/2021",  app1.getPublishDate());
		assertEquals(1, 	app1.getVersion());
		assertEquals(10, 	app1.getRecommendAge());
		assertEquals(0.00,  app1.getPrice());
		assertEquals(5.00,  app1.getRating());
		assertEquals(2.89,  app1.getSize());
		assertTrue(app1.isCompatibility());
	}

	@Test
	void testUpdateVersion() {
		app2.updateVersion();
		assertEquals(2, 	app2.getVersion());
	}
	
	@Test
	void testCheckVersion() {
		assertEquals(2, 	app2.getVersion());
	}
	
	@Test
	void testPrice() {
		// Add Price
		app2.addPrice(8.88);
		assertEquals(8.88,  app2.getPrice());
		// Reduce Price
		app2.reducePrice(2.22);
		assertEquals(6.66,  app2.getPrice());
	}
	
	@Test
	void testSetAppName() {
		app3.setAppName("CANVAS");
		assertEquals("CANVAS",  app3.getAppName());
	}
	
	@Test
	void testSetAppUID() {
		app3.setAppUID("JUNIT");
		assertEquals("JUNIT",  app3.getAppUID());
	}
	
	@Test
	void testSetCategory() {
		app3.setCategory("Media");
		assertEquals("Media",  app3.getCategory());
	}
	
	@Test
	void testSetLanguage() {
		app3.setLanguage("Chinese");
		assertEquals("Chinese",  app3.getLanguage());
	}
	
	@Test
	void testSetPublishDate() {
		app3.setPublishDate("01/01/1111");
		assertEquals("01/01/1111",  app3.getPublishDate());
	}
	
	@Test
	void testSetVersion() {
		app3.setVersion(6);
		assertEquals(6,  app3.getVersion());
	}
	
	@Test
	void testSetRecAge() {
		app3.setRecommendAge(18);
		assertEquals(18,  app3.getRecommendAge());
	}
	
	@Test
	void testSetPrice() {
		app3.setPrice(4.56);
		assertEquals(4.56,  app3.getPrice());
	}
	
	@Test
	void testSetRating() {
		app3.setRating(3);
		assertEquals(3,  app3.getRating());
	}
	
	@Test
	void testSetSize() {
		app3.setSize(7.34);
		assertEquals(7.34,  app3.getSize());
	}
	
	@Test
	void testSetCompatibility() {
		app3.setCompatibility(false);
		assertFalse(app3.isCompatibility());
	}
	
//	@Test
//	void testSetDiscountPrice() {
//		
//	}
//	
//	@Test
//	void testCheckDiscountPrice() {
//		
//	}
	
}

// "Apprella", "APRT1", "Search", "Eng", "04/08/2021",
// 1, 10, 0.00, 5.00, 2.89, true


