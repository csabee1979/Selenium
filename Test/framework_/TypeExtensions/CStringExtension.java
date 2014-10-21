package selenium.framework;

abstract public class CStringExtension {
	public static boolean isNullOrEmpty(String s){
		return s == null || s.length() == 0;
	}
}
