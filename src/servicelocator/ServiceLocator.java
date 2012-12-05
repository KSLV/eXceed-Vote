package servicelocator;

public class ServiceLocator {

	private static String log4j = "src//log4j//log4j.properties";	
	
	
	public static ServiceLocator sl = new ServiceLocator();
	
	private ServiceLocator(){				
	}
	public static ServiceLocator getServiceLocator(){
		return sl;
	}
	public String getLog4jPath(){
		return log4j;
	}

}
