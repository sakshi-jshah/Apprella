import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ReadFileTester {

	static ArrayList<Application> app = new ArrayList<Application>();
	
	static Scanner in = new Scanner(System.in);
	
	public static void main(final String[] args) {
		//---------------- load database
		loadApp();
		System.out.println("==============================");
		System.out.println(" ");
		
		//sortByType();
	}

	private static void sortByType() {
		System.out.println("Enter the category of application: ");
		String input = in.nextLine();
		String ret;
		
		HashMap<String, String> result = new HashMap<String, String>();
		
		for (Application a : app) {
			if (input.equals(a.getCategory())) {
				ret = a.getCategory();
				result.put(ret, a.getAppName());
				System.out.println(result);
			}
		}
		
	}

	private static void loadApp() {
		
		RandomAccessFile raf = null;
		
		try {
			raf = new RandomAccessFile("AppSample.txt", "r");
			raf.readLine();
			while (raf.getFilePointer() < raf.length()) {
				Application a = new Application(raf);
				app.add(a);
			}
			raf.close();
			
			for (Application a : app)
				System.out.println(a);
			
		} catch (Exception e) {
			System.out.println("Error with raf");
		} finally {
			try { raf.close(); } catch (Exception e) {}
		}
	}
	
	
}
