import java.io.IOException;

/**
 * Indicate directory of username and password storage
 * @author KSLV
 * @version Oct 1, 2012
 */
public class LoginGUI extends VerificationProcess{

	private static String userListDir = "src//UsernameList.txt";
	private static String passListDir = "src//PasswordList.txt";	
	
	public LoginGUI(String username, String password) throws IOException {
		super(userListDir, passListDir);
	}

}
