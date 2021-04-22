import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class ReadFileTester {

	static ArrayList<Application> app = new ArrayList<Application>();
	
	static Scanner in = new Scanner(System.in);
	
	public static void main(final String[] args) {
		//------------------ Load Database
		loadApp();		
		
		//------------------ Menu
		menu: {
			while(true) {
				switch(getMenuChoice()) {
				case"1": sortByType();			break;
				case"2": sortByLanguage();		break;
				case"3": sortByAge();			break;
				case"4": sortByPrice();			break;
				case"5":						break menu;
				}
			}
		}
		System.out.println("Good bye!");
		System.out.println("Thank you for using Apprella!");
	}


	private static void sortByPrice() {
		System.out.println("Enter the maximun price of application: ");
		String input = in.nextLine();
		double readin = Double.parseDouble(input);
		double ret;
		String readout;
		
		HashMap<String, String> result = new HashMap<String, String>();
		
		for (Application a : app) {
			if (readin >= a.getPrice()) {
				ret = a.getPrice();
				readout = String.valueOf(ret);
				result.put(readout, a.getAppName());
			}
		}
		System.out.println(result);
		System.out.println("    ");
	}


	private static void sortByAge() {
		System.out.println("Enter the recommand age of application: ");
		String input = in.nextLine();
		int readin = Integer.parseInt(input);
		int ret;
		String readout;
		
		HashMap<String, String> result = new HashMap<String, String>();
		
		for (Application a : app) {
			if (readin >= a.getRecommendAge()) {
				ret = a.getRecommendAge();
				readout = String.valueOf(ret);
				result.put(readout, a.getAppName());
			}
		}
		System.out.println(result);
		System.out.println("    ");
	}


	private static void sortByLanguage() {
		System.out.println("Enter the language of application: ");
		String input = in.nextLine();
		String ret;
		
		HashMap<String, String> result = new HashMap<String, String>();
		
		for (Application a : app) {
			if (input.equals(a.getLanguage())) {
				ret = a.getLanguage();
				result.put(ret, a.getAppName());
				System.out.println(result);
			}
		}
		System.out.println("    ");
	}


	private static String getMenuChoice() {
		while(true) {
			System.out.println("==================================");
			System.out.println("1.  Filtering application by type");
			System.out.println("2.  Filtering application by language");
			System.out.println("3.  Filtering application by recommand age");
			System.out.println("4.  Filtering application by price");
			System.out.println("5.  Exit");
			System.out.println(">>  ");
			String ret = in.nextLine();
			if(ret.charAt(0) >= '1' && ret.charAt(0) <= '5')
				return ret.substring(0, 1);
			else 
				System.out.println("\n======== Input Error ========");
		}
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
		System.out.println("    ");
		
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
			
//			for (Application a : app)
//				System.out.println(a);
			
		} catch (Exception e) {
			System.out.println("Error with raf");
		} finally {
			try { raf.close(); } catch (Exception e) {}
		}
	}
	
	
}