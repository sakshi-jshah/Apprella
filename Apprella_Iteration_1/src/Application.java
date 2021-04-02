import java.io.RandomAccessFile;
import java.util.ArrayList;

public abstract class Application {
	//=========================
	private String appName;
	private String appUID;
	private String category;
	private String version;
	private String language;
	private String publishDate;
	private int recommendAge;
	private double price;
	private double rating;
	private double size;
	private boolean Compatibility;  // Able to run on Android
	
	
	//=========================
	public Application(String appName, String appUID, String category, String version, String language,
			String publishDate, int recommendAge, double price, double rating, double size, boolean compatibility) {
		super();
		setAppName(appName);
		setAppUID(appUID);
		setCategory(category);
		setVersion(version);
		setLanguage(language);
		setPublishDate(publishDate);
		setRecommendAge(recommendAge);
		setPrice(price);
		setRating(rating);
		setSize(size);
		setCompatibility(compatibility);
	}

	public Application(Application app) {
		this(app.appName, app.appUID, app.category, app.version, app.language,
			 app.publishDate, app.recommendAge, app.price, app.rating, 
			 app.size, app.Compatibility);
	}
	
	public Application() {
		
	}
	
	public Application(RandomAccessFile raf) throws Exception {
		load(raf);
	}


	//=========================
	private void load(RandomAccessFile raf) {
		
	}
	
//	@Override
//	protected Object clone() {
//		return new Application(this);
//	}
	
	
	@Override
	public String toString() {
		return "Application [appName=" + appName + ", appUID=" + appUID + ", category=" + category + ", version="
				+ version + ", language=" + language + ", publishDate=" + publishDate + ", recommendAge=" + recommendAge
				+ ", price=" + price + ", rating=" + rating + ", size=" + size + ", Compatibility=" + Compatibility
				+ "]";
	}
	
	
	//=========================
	public String getAppName() {
		return appName;
	}



	public void setAppName(String appName) {
		this.appName = appName;
	}



	public String getAppUID() {
		return appUID;
	}



	public void setAppUID(String appUID) {
		this.appUID = appUID;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public String getVersion() {
		return version;
	}



	public void setVersion(String version) {
		this.version = version;
	}



	public String getLanguage() {
		return language;
	}



	public void setLanguage(String language) {
		this.language = language;
	}



	public String getPublishDate() {
		return publishDate;
	}



	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}



	public int getRecommendAge() {
		return recommendAge;
	}



	public void setRecommendAge(int recommendAge) {
		this.recommendAge = recommendAge;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public double getRating() {
		return rating;
	}



	public void setRating(double rating) {
		this.rating = rating;
	}



	public double getSize() {
		return size;
	}



	public void setSize(double size) {
		this.size = size;
	}



	public boolean isCompatibility() {
		return Compatibility;
	}



	public void setCompatibility(boolean compatibility) {
		Compatibility = compatibility;
	}
	
	
}
