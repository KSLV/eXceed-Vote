package login;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties; 
import org.apache.log4j.Logger; 
import org.apache.log4j.PropertyConfigurator;

import database.User;

import exceed.dao.DaoFactory;

import servicelocator.ServiceLocator;


/**
 * Handles Vote Processes
 * @author KSLV
 * @version Oct 1, 2012
 */
public abstract class VerificationProcess {

	private String tmpUsername;
	private String tmpPassword;
	private final Logger logger = Logger.getLogger(getClass());	
	protected static Properties properties = new Properties();

	/**
	 * Constructor for this class
	 * @param userListDir receive directory of UsernameList.txt
	 * @param passListDir receive directory of PasswordList.txt
	 * @throws IOException
	 */
	public VerificationProcess() throws IOException
	{
		ServiceLocator sl = ServiceLocator.getServiceLocator();
		PropertyConfigurator.configure(sl.getLog4jPath());
		
//		this.userListDir = sl.getUserListPath();
//		this.passListDir = sl.getPassListPath();
	}
	
	/**
	 * Check if are there any pair of username and password that match, return it's Line number as userId, else return 0
	 * @param username User input username
	 * @param password User input Password
	 * @return userID if input is valid, else return 0
	 * @throws IOException
	 */
	public User verifyLogin(String username , String password) throws IOException
	{
		User user = DaoFactory.getInstance().getExceedUserDao().find(username);
		if(user == null)
		{
			logger.error("Invalid UserName or Password");
			return null;
		}
		if(password.equals(user.getPassword()))
		{
			logger.info(username +" Login");
			return user;
		}else
		{
			logger.error("Invalid UserName or Password");
			return null;
		}
			

	}
	
	/**
	 * Return username the user input as String
	 * @return Username user has input
	 */
	public String getTmpUserName()
	{
		return tmpUsername;
	}
	
	/**
	 * Return password the user input as String
	 * @return Password user has input
	 */
	public String getTmpPassword()
	{
		return tmpPassword;
	}
	
}
