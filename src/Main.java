import java.io.IOException;

import com.avaje.ebean.Ebean;

import database.NBallot;
import database.QuestionDescription;
import database.TeamDiscription;
import database.User;

import servicelocator.ServiceLocator;




public class Main {

	public static void main(String [] args) throws IOException
	{
		/*
		String name = "test";
		String pass = "test";
		 
		User  up = Ebean.find(User.class).where().eq("name", name).findUnique();
	    if(up == null){
	    	up = new User(name,pass);
	    	Ebean.save(up);
	    }
	    
	    NBallot nb = new NBallot(up,5);	    
	    Ebean.save(nb);
	    
	    String teamname = "kiki";
	    String Qname = "tollolol";		
	    
	    TeamDiscription tb = Ebean.find(TeamDiscription.class).where().eq("name", teamname).findUnique();
	    QuestionDescription qb = Ebean.find(QuestionDescription.class).where().eq("name", Qname).findUnique();	   
	    
	    if(tb == null){
	    	tb = new TeamDiscription(teamname);
	    	Ebean.save(tb);
	    }
	    if(qb == null){
	    	qb = new QuestionDescription(Qname);
	    	Ebean.save(qb);
	    }
	    */
	      // }
		//new SimpleLoginUI();
		ServiceLocator sl = ServiceLocator.getServiceLocator();
		new login.LoginGUIController();
		//new QuestionListMenuGUIController();
	}
	
}
