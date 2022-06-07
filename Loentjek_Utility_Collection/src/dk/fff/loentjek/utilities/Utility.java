package dk.fff.loentjek.utilities;

public class Utility {
	
	public static String stringToLowerCase(String s) {
		String lower = s.toLowerCase();
		return lower;
	}
	
	public static String stringToUpperCase(String s) {
		String upper = s.toUpperCase();
		return upper;
	}
	
	public static String stringTrim (String s) {
		String result = s.trim(); 
		return result;
	}
	
	public Double checkValueForNull(Double val) {
		if (val == null) {
			return 0.0;
		} else {
			return val;
		}
	}
}
