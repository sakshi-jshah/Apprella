import java.io.RandomAccessFile;
import java.security.InvalidParameterException;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Class that represents the different Applications
 * @author Apprella Dev Team: Benjamin Lovick, Bryson Tilford, Lucia Beckman, Pu Ji, Sakshi Shah
 *
 */
public class Application {
	//=========================
	private String appName;
	private String appUID;
	private String category;
	private String language;
	private String publishDate;
	private int version;
	private int recommendAge;
	private double price;
	private double rating;
	private double size;
	private boolean Compatibility;  // Able to run on Android
	
	private static DecimalFormat df2 = new DecimalFormat("#.##");
	
	//=========================
	/**
	 * Main constructor
	 * @param appName app name
	 * @param appUID app UID 
	 * @param category app category
	 * @param language app language
	 * @param publishDate app publish date
	 * @param version app version
	 * @param recommendAge app recommeneded age
	 * @param price app price
	 * @param rating app rating
	 * @param size app size
	 * @param compatibility app compatability
	 */
	public Application(String appName, String appUID, String category, String language, String publishDate,
			int version, int recommendAge, double price, double rating, double size, boolean compatibility) {
		super();
		setAppName(appName);
		setAppUID(appUID);
		setCategory(category);
		setLanguage(language);
		setPublishDate(publishDate);
		setVersion(version);
		setRecommendAge(recommendAge);
		setPrice(price);
		setRating(rating);
		setSize(size);
		setCompatibility(compatibility);
	}

	/**
	 * Constructor that takes in a application
	 * @param app inputed application
	 */
	public Application(Application app) {
		this(app.appName, 		app.appUID, 		app.category, 
			 app.language, 		app.publishDate,    app.version,
			 app.recommendAge,  app.price, 			app.rating, 
			 app.size, 			app.Compatibility);
	}
	
	/**
	 * Constructor that takes in a RandomAccessFile that will be read from
	 * @param raf the RandomAccessFile
	 * @throws Exception
	 */
	public Application(RandomAccessFile raf) throws Exception {
		this(raf.readLine());
	}
	
	/**
	 * Constructor that will take in a string
	 * @param row the inputted string
	 */
	public Application(String row) {
		this(row.split("\t"));
	}
	
	/**
	 * Constructor that takes in a array of strings
	 * @param p the array of strings
	 */
	public Application(String[] p) {
		this(p[0], p[1], p[2], p[3], p[4],
			 Integer.parseInt(p[5]), Integer.parseInt(p[6]),
			 Double.parseDouble(p[7]), Double.parseDouble(p[8]), Double.parseDouble(p[9]),
			 Boolean.parseBoolean(p[10]));
	}
	


	//=========================
	/**
	 * Method to clone the current object
	 */
	@Override
	protected Object clone() {
		return new Application(this);
	}

	/**
	 * Method to update the version
	 */
	public void updateVersion() {
		version += 1;
	}
	
	/**
	 * Method to check the version
	 * @return the current version
	 */
	public String checkVersion() {
		return "Current Version: " + version;
	}
	
	/**
	 * Method to change the price
	 * @param ap the added amount to the price
	 */
	public void addPrice(double ap) {
		if(ap > (100 - price)) {
			throw new InvalidParameterException("Invalid number to Add!");
		}
		price = price + ap;
	}
	
	/**
	 * Method to change the price
	 * @param ap the subtracted amount to the price
	 */
	public void reducePrice(double ap) {
		if(ap > price) {
			throw new InvalidParameterException("Invalid number to reduce!");
		}
		price = price - ap;
	}
	
	/**
	 * Method to check the compatability with Android
	 */
	public void checkCompatibility() {
		if (Compatibility == true) {
			System.out.print("Avalible on Android!");
		} else {
			System.out.print("Not avalible on Android!");
		}
	}
	
	/**
	 * Method to return a string representation of the application
	 */
	@Override
	public String toString() {
		return "Application:" + appName 
				+ "; Category=" + category 
				+ "; version=" + version 
				+ "; language=" + language 
				+ "; recommendAge=" + recommendAge
				+ "; price=" + price 
				+ "; rating=" + rating 
				+ "; Compatibility=" + Compatibility;
	}
	
	
	//=========================
	/**
	 * Method to get the app name
	 * @return the app name
	 */
	public String getAppName() 			{ return appName;		}

	/**
	 * Method to get the app uid
	 * @return the app uid
	 */
	public String getAppUID() 			{ return appUID; 		}
	
	/**
	 * Method to get the category
	 * @return the category
	 */
	public String getCategory() 		{ return category; 		}
	
	/**
	 * Method to get the language
	 * @return the language
	 */
	public String getLanguage() 		{ return language; 		}
	
	/**
	 * Method to get the publish date
	 * @return the publish date
	 */
	public String getPublishDate() 		{ return publishDate;	}
	
	/**
	 * Method to get the version
	 * @return the version
	 */
	public int getVersion() 			{ return version; 		}
	
	/**
	 * Method to get the recommended age
	 * @return the recommened age
	 */
	public int getRecommendAge() 		{ return recommendAge; 	}
	
	/**
	 * Method to get the price
	 * @return the price
	 */
	public double getPrice() 			{ return price; 		}
	
	/**
	 * Method to get the rating
	 * @return the rating
	 */
	public double getRating() 			{ return rating; 		}
	
	/**
	 * Method to get the size
	 * @return the size
	 */
	public double getSize() 			{ return size; 			}
	
	/**
	 * Method to get the compatibility
	 * @return the compatibility
	 */
	public boolean isCompatibility() 	{ return Compatibility; }
	
	/**
	 * Method to set the appname
	 * @param appName the new name
	 */
	public void setAppName(String appName) {
		this.appName = appName;
	}

	/**
	 * Method to set the uid
	 * @param appUID what to set the new uid to
	 */
	public void setAppUID(String appUID) {
		this.appUID = appUID;
	}

	/**
	 * Method to reset the category
	 * @param category what to set the new category to
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Method to set the language
	 * @param language to be set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * Method to set the publish date
	 * @param publishDate the new publish date
	 */
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	
	/**
	 * Method set the version
	 * @param version version to be set to
	 */
	public void setVersion(int version) {
		this.version = version;
	}
	
	/**
	 * Method to set the recommended age
	 * @param recommendAge age to be set to
	 */
	public void setRecommendAge(int recommendAge) {
		if(recommendAge < 0 || recommendAge > 18) {
			throw new InvalidParameterException("Recommand age must be between 0 and 21");
		}
		this.recommendAge = recommendAge;
	}

	/**
	 * Method to set the price
	 * @param price price to be set to
	 */
	public void setPrice(double price) {
		if(price < 0 || price > 100) {
			throw new InvalidParameterException("Avaliable price must be between 0 $ and 100 $");
		}
		this.price = price;
	}

	/**
	 * Method to set the rating to
	 * @param rating the rating to be set to
	 */
	public void setRating(double rating) {
		if(rating < 0 || rating > 5) {
			throw new InvalidParameterException("Application can only be rated from 0 to 5");
		}
		this.rating = rating;
	}

	/**
	 * Method to set the size
	 * @param size the size to be set to
	 */
	public void setSize(double size) {
		if(size < 0 || size > 500) {
			throw new InvalidParameterException("Application can only have minimum size of 0 GB and maximum of 10 GB");
		}
		this.size = size;
	}

	/**
	 * Method to set the compatibility
	 * @param compatibility the compatibility to be set to
	 */
	public void setCompatibility(boolean compatibility) {
		Compatibility = compatibility;
	}
	
}
