import java.io.IOException;

import servicelocator.ServiceLocator;




public class Main {

	public static void main(String [] args) throws IOException
	{
		//new SimpleLoginUI();
		ServiceLocator sl = ServiceLocator.getServiceLocator();
		new login.LoginGUIController();
		//new QuestionListMenuGUIController();
	}
	
}
