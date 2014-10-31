package Configuration;

abstract public class DefaultConfigurationSettings {
	public static String getDefaultUrl(){
		return "http://www.google.com";
	}
	
	public static String getDefaultEmail() throws Exception{
		throw new Exception("It should be filled");
	}
	
	public static String getDefaultPassword() throws Exception{
		throw new Exception("It should be filled");
	}
	
	
}
