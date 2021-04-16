import java.io.RandomAccessFile;
import java.security.InvalidParameterException;
import java.math.RoundingMode;
import java.text.DecimalFormat;

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

	public Application(Application app) {
		this(app.appName, 		app.appUID, 		app.category, 
			 app.language, 		app.publishDate,    app.version,
			 app.recommendAge,  app.price, 			app.rating, 
			 app.size, 			app.Compatibility);
	}
	
	
	public Application(RandomAccessFile raf) throws Exception {
		this(raf.readLine());
	}
	

	public Application(String row) {
		this(row.split("\t"));
	}
	
	public Application(String[] p) {
		this(p[0], p[1], p[2], p[3], p[4],
			 Integer.parseInt(p[5]), Integer.parseInt(p[6]),
			 Double.parseDouble(p[7]), Double.parseDouble(p[8]), Double.parseDouble(p[9]),
			 Boolean.parseBoolean(p[10]));
	}
	


	//=========================
	@Override
	protected Object clone() {
		return new Application(this);
	}

	
	public void updateVersion() {
		version += 1;
	}
	
	
	public String checkVersion() {
		return "Current Version: " + version;
	}
	
	
	public void addPrice(double ap) {
		if(ap > (100 - price)) {
			throw new InvalidParameterException("Invalid number to Add!");
		}
		price = price + ap;
	}
	
	
	public void reducePrice(double ap) {
		if(ap > price) {
			throw new InvalidParameterException("Invalid number to reduce!");
		}
		price = price - ap;
	}
	
	
	public void checkCompatibility() {
		if (Compatibility == true) {
			System.out.print("Avalible on Android!");
		} else {
			System.out.print("Not avalible on Android!");
		}
	}
	
	
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
	public String getAppName() 			{ return appName;		}

	public String getAppUID() 			{ return appUID; 		}
	
	public String getCategory() 		{ return category; 		}
	
	public String getLanguage() 		{ return language; 		}
	
	public String getPublishDate() 		{ return publishDate;	}
	
	public int getVersion() 			{ return version; 		}
	
	public int getRecommendAge() 		{ return recommendAge; 	}
	
	public double getPrice() 			{ return price; 		}
	
	public double getRating() 			{ return rating; 		}
	
	public double getSize() 			{ return size; 			}
	
	public boolean isCompatibility() 	{ return Compatibility; }
	

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public void setAppUID(String appUID) {
		this.appUID = appUID;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	
	public void setVersion(int version) {
		this.version = version;
	}
	
	public void setRecommendAge(int recommendAge) {
		if(recommendAge < 0 || recommendAge > 18) {
			throw new InvalidParameterException("Recommand age must be between 0 and 21");
		}
		this.recommendAge = recommendAge;
	}

	public void setPrice(double price) {
		if(price < 0 || price > 100) {
			throw new InvalidParameterException("Avaliable price must be between 0 $ and 100 $");
		}
		this.price = price;
	}

	public void setRating(double rating) {
		if(rating < 0 || rating > 5) {
			throw new InvalidParameterException("Application can only be rated from 0 to 5");
		}
		this.rating = rating;
	}

	public void setSize(double size) {
		if(size < 0 || size > 10) {
			throw new InvalidParameterException("Application can only have minimum size of 0 GB and maximum of 10 GB");
		}
		this.size = size;
	}

	public void setCompatibility(boolean compatibility) {
		Compatibility = compatibility;
	}
	
}
