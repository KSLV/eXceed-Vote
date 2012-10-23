package login;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties; 
import org.apache.log4j.Logger; 
import org.apache.log4j.PropertyConfigurator;


/**
 * Handles Vote Processes
 * @author KSLV
 * @version Oct 1, 2012
 */
public abstract class VerificationProcess {

	private InputStream uis,pis; //FileInputStream for UsernameList.txt and PasswordList.txt , respectively
	private InputStreamReader uin,pin;
	private BufferedReader ubr,pbr;
	private String tmpUsername;
	private String tmpPassword;
	private String userListDir; //Store directory of UsernameList.txt
	private String passListDir;	//Store directory of PasswordList.txt
	

	private final Logger logger = Logger.getLogger(getClass());	
	protected static Properties properties = new Properties();

	/**
	 * Constructor for this class
	 * @param userListDir receive directory of UsernameList.txt
	 * @param passListDir receive directory of PasswordList.txt
	 * @throws IOException
	 */
	public VerificationProcess(String userListDir , String passListDir) throws IOException
	{
		PropertyConfigurator.configure("src//log4j//log4j.properties");
		
		this.userListDir = userListDir;
		this.passListDir = passListDir;
	}
	
	/**
	 * Check if are there any pair of username and password that match, return it's Line number as userId, else return 0
	 * @param username User input username
	 * @param password User input Password
	 * @return userID if input is valid, else return 0
	 * @throws IOException
	 */
	public int verifyLogin(String username , String password) throws IOException
	{
		uis = new FileInputStream(userListDir);
		uin = new InputStreamReader(uis);
		ubr = new BufferedReader(uin);
		pis = new FileInputStream(passListDir);
		pin = new InputStreamReader(pis);
		pbr = new BufferedReader(pin);
		int idCounter = 1;
		tmpUsername = ubr.readLine();
		tmpPassword = pbr.readLine();
		while(tmpUsername != null)
		{
			if(tmpUsername.equals(username) && tmpPassword.equals(password)) 
			{
				
				logger.info(username +" Login");
				
				uis.close();
				uin.close();
				ubr.close();
				pis.close();
				pin.close();
				pbr.close();
				return idCounter;
			}			
			idCounter++;
			tmpUsername = ubr.readLine();
			tmpPassword = pbr.readLine();
		}
		uis.close();
		uin.close();
		ubr.close();
		pis.close();
		pin.close();
		pbr.close();		
		logger.error("Invalid UserName or Password");
		return 0;
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
