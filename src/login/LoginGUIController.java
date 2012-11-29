package login;

import java.io.IOException;

import database.User;

/**
 * Indicate directory of username and password storage
 * @author KSLV
 * @version Oct 1, 2012
 */
public class LoginGUIController extends VerificationProcess{

	//private static String userListDir = "src//database//UsernameList.txt";
	//private static String passListDir = "src//database//PasswordList.txt";	
	
	public LoginGUIController() throws IOException {
		super();
	}
	
	public User submit(String username , String password) throws IOException
	{
		return verifyLogin(username, password);
	}
	
	public void invokeQuestionGUI(User user) throws IOException
	{
		new questionmenu.QuestionListMenuGUIController(user);
	}

}
