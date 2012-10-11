import java.io.IOException;

/**
 * Indicate directory of username and password storage
 * @author KSLV
 * @version Oct 1, 2012
 */
public class LoginGUI extends VerificationProcess{

	private static String userListDir = "src//database//UsernameList.txt";
	private static String passListDir = "src//database//PasswordList.txt";	
	
	public LoginGUI() throws IOException {
		super(userListDir, passListDir);
	}

}
