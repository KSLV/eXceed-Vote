import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import com.avaje.ebean.Ebean;

import database.NBallot;
import database.QuestionDescription;
import database.TeamDiscription;
import database.User;
import exceed.dao.BallotDao;
import exceed.dao.DaoFactory;
import exceed.dao.UserDao;

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
		consoleTest();
		new login.LoginGUIController();
		//new QuestionListMenuGUIController();
	}
	private static void consoleTest() {
		int testInput = 0;
		List<QuestionDescription> noq = Ebean.find(QuestionDescription.class).findList();
		UserDao testDao = DaoFactory.getInstance().getUserDao();
		BallotDao bdao = DaoFactory.getInstance().getBallotDao();
		User harry = new User("Harry","Potter");
		for (QuestionDescription q : noq) {
			harry.getNBallot().put(q, new NBallot(harry, q, 6));
		}
		testDao.save(harry);
		Scanner scanner = new Scanner(System.in);
		
		do{
			System.out.println("User DAO Tester");
			System.out.println("---------------");
			System.out.println("1.New User Harry");
			System.out.println("2.Find Harry");
			System.out.println("3.Add User");
			System.out.println("4.Find All Voter");
			System.out.println("5.Show Harry Ballots");
			//System.out.println("6.Test change of ballot");
			System.out.println("0.Exit");
			System.out.print("Input : ");
			testInput = Integer.parseInt(scanner.nextLine());
			switch(testInput)
			{
			case 1:
				System.out.println("Saved Harry Potter with id " + harry.getId());
				
				break;
			case 2:
				User voter = testDao.find(harry.getId());
				System.out.println("Found " + voter.getName() + " ID " + voter.getId());
				break;
			case 3:
				System.out.print("Input Username : ");
				String user = scanner.nextLine();
				System.out.print("Input Password : ");
				String pass = scanner.nextLine();
				User userA = new User(user , pass);
				testDao.save(userA);
				System.out.println("Saved "+user+" with id " + userA.getId());

			case 4:
				Collection<User> all = testDao.findAll();
				System.out.println("Users in database: " + all.size() ); 
				for(User x: all) System.out.println(x.getName());
				break;
			case 5:
				noq = Ebean.find(QuestionDescription.class).findList();
				
				for (QuestionDescription q : noq) {
					harry = testDao.find(harry.getId());
					Map<QuestionDescription, NBallot> aa = harry.getNBallot();
					for (Entry<QuestionDescription, NBallot> entry : aa.entrySet()) {
						System.out.println(entry.getKey() + " , " + entry.getValue());
					}
					System.out.println(aa.size());
					NBallot nb = aa.get(q);
					System.out.println(nb + " , " + q);
					int ballot = nb.getBallot();
					System.out.println("Harry have "+ ballot + " on question "+ q.getName());
				}
				break;
					
				
				
			}
			
		}while(testInput != 0);
		
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
