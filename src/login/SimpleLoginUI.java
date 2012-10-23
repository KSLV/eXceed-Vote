package login;

import java.io.IOException;
import java.util.Scanner;

/**
 * Console-based Login UI class
 * @author KSLV
 * @version Oct 1, 2012
 */
public class SimpleLoginUI extends VerificationProcess{

	private Scanner scanner;
	private static String userListDir = "src//database//UsernameList.txt";
	private static String passListDir = "src//database//PasswordList.txt";	
	
	//private Logger logger = Logger.getLogger(this.toString());
	
	/**
	 * Constructor for this class
	 * @throws IOException
	 */
	public SimpleLoginUI() throws IOException
	{
		super(userListDir , passListDir);
		scanner = new Scanner(System.in);
		basicLogin();
	}
	
	/**
	 * Receive username and password and call Verification method
	 * @throws IOException
	 */
	public void basicLogin() throws IOException
	{
		String inputUsername = new String();
		String inputPassword = new String();
		int idCounter = 0;
		do{
			System.out.print("Enter Username : ");
			inputUsername = scanner.nextLine();
			System.out.print("Enter Password : ");
			inputPassword = scanner.nextLine();
			idCounter = verifyLogin(inputUsername , inputPassword);
			if(idCounter == 0) 
			{
				System.out.println("Invalid Username/Password");
				System.out.print("Do you want to try login again (Y/N)? : ");
				if(scanner.nextLine().equalsIgnoreCase("n")) break;
			}
		}while(idCounter == 0);
		
		if(idCounter != 0) callSimpleVoterUI(idCounter,inputUsername);
		
	}
	
	/**
	 * Tell user which userID they logged into and call Question UI
	 * @param idCounter Indicate userID that user has logged in
	 * @param UserName Username of that user
	 * @throws IOException
	 */
	private void callSimpleVoterUI(int idCounter,String UserName) throws IOException
	{
		//////////////// log4j /////////////
		//logger.info(UserName+" Login");
		////////////////////////////////////
		System.out.println("Login Success! with ID : "+ idCounter);
		new questionmenu.SimpleUI(idCounter);
	}
	
}
