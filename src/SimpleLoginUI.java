import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

public class SimpleLoginUI extends VerificationProcess{

	private Scanner scanner;
	private static String userListDir = "src//UsernameList.txt";
	private static String passListDir = "src//PasswordList.txt";	
	
	private Logger logger = Logger.getLogger(this.toString());
	
	public SimpleLoginUI() throws IOException
	{
		super(userListDir , passListDir);
		scanner = new Scanner(System.in);
		basicLogin();
	}
	
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
	
	private void callSimpleVoterUI(int idCounter,String UserName) throws IOException
	{
		//////////////// log4j /////////////
		logger.info(UserName+" Login");
		////////////////////////////////////
		System.out.println("Login Success! with ID : "+ idCounter);
		new SimpleUI(idCounter);
	}
	
}
