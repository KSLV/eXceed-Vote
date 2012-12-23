package main;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import login.LoginGUI;
import login.VerificationProcess;

import servicelocator.ServiceLocator;
import admin.CommissionerView;
import admin.CommissionerController;
import com.avaje.ebean.Ebean;

import database.NBallot;
import database.QuestionDescription;
import database.User;
import exceed.dao.DaoFactory;
import exceed.dao.ExceedUserDao;
import exceed.dao.QuestionDao;




public class Main {

	public static void main(String [] args) throws IOException
	{		
		ServiceLocator.getServiceLocator();	
		DaoFactory.getInstance();
		new login.LoginGUIController(new VerificationProcess(),new LoginGUI());
		new CommissionerController(new CommissionerView());
		
		
	}
	
	
}
