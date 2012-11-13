import java.io.IOException;
import java.util.List;

import com.avaje.ebean.Ebean;

import database.NBallot;
import database.QuestionDescription;
import database.TeamDiscription;
import database.User;

import servicelocator.ServiceLocator;




public class Main {

	public static void main(String [] args) throws IOException
	{
		
		database();
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
	static void database(){
		
		User a = new User("ARLeader","ARLeader");
		User b = new User("title","title");
		
		QuestionDescription q1 = new QuestionDescription("Question 1");
		QuestionDescription q2 = new QuestionDescription("Question 2");
		QuestionDescription q3 = new QuestionDescription("Question 3");
		
		TeamDiscription t1 = new TeamDiscription("Team 1");
		TeamDiscription t2 = new TeamDiscription("Team 2");
		
		
		Ebean.save(q1);
		Ebean.save(q2);
		Ebean.save(q3);
		Ebean.save(t1);
		Ebean.save(t2);
		
		List<QuestionDescription> noq = Ebean.find(QuestionDescription.class).findList();

		for (User user : new User[] { a, b }) {
			for (QuestionDescription q : noq) {
				user.getNBallot().put(q, new NBallot(user, q, 6));
			}
		}
		
		Ebean.save(a);
		Ebean.save(b);
		
		
		
	}
	
}
