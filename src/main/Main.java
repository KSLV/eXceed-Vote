package main;
import java.io.IOException;
import login.LoginGUI;
import login.VerificationProcess;

import servicelocator.ServiceLocator;
import admin.CommissionerView;
import admin.CommissionerController;
import exceed.dao.DaoFactory;




public class Main {

	public static void main(String [] args) throws IOException
	{		
		ServiceLocator.getServiceLocator();	
		DaoFactory.getInstance();
		new login.LoginGUIController(new VerificationProcess(),new LoginGUI());
		new CommissionerController(new CommissionerView());
	}
	
	
}
