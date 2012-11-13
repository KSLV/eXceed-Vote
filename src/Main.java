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
import database.TeamDescription;
import database.User;
import database.VoteLog;
import exceed.dao.DaoFactory;
import exceed.dao.ExceedUserDao;
import exceed.dao.QuestionDao;
import exceed.dao.TeamDao;
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
		consoleTest();
		//new QuestionListMenuGUIController();
	}
	private static void consoleTest() {
		int testInput = 0;
		QuestionDao testQDao = DaoFactory.getInstance().getQuestionDao();
		List<QuestionDescription> noq = testQDao.findAll();
		ExceedUserDao testUserDao = DaoFactory.getInstance().getExceedUserDao();
		TeamDao testTeamDao = DaoFactory.getInstance().getTeamDao();
		User harry = new User("Harry","Potter");
		Scanner scanner = new Scanner(System.in);
		
		do{
			System.out.println("User DAO Tester");
			System.out.println("---------------");
			System.out.println("1.New User Harry");
			System.out.println("2.Find User");
			System.out.println("3.Add User");
			System.out.println("4.Find All Voter");
			System.out.println("5.Show user Ballots");
			System.out.println("6.Vote");
			System.out.println("7.Display all user and all ballots");
			System.out.println("0.Exit");
			System.out.print("Input : ");
			testInput = Integer.parseInt(scanner.nextLine());
			switch(testInput)
			{
			case 1:
				
				for (QuestionDescription q : noq) {
					harry.getNBallot().put(q, new NBallot(harry, q, 6));
				}
				testUserDao.save(harry);
				System.out.println("Saved Harry Potter with id " + harry.getId());
				
				break;
			case 2:
				System.out.print("Enter user name to find : ");
				String inputName = scanner.nextLine();
				User user = testUserDao.find(inputName);
				if(user == null) System.out.println("User not Found");
				else System.out.println("Found " + user.getName() + " ID " + user.getId());
				break;
			case 3:
				System.out.print("Input Username : ");
				String username = scanner.nextLine();
				System.out.print("Input Password : ");
				String pass = scanner.nextLine();
				System.out.print("Input Number of Given Ballots : ");
				int ballot = Integer.parseInt(scanner.nextLine());
				User userA = new User(username , pass);
				for (QuestionDescription q : noq) {
					userA.getNBallot().put(q, new NBallot(userA, q, ballot));
				}
				testUserDao.save(userA);
				System.out.println("Saved "+username+" with id " + userA.getId());

			case 4:
				Collection<User> all = testUserDao.findAll();
				System.out.println("Users in database: " + all.size() ); 
				for(User x: all) System.out.println(x.getName());
				break;
			case 5:
				noq = testQDao.findAll();
				System.out.print("Enter user name to find : ");
				inputName = scanner.nextLine();
				user = testUserDao.find(inputName);
				if(user == null) System.out.println("User not Found");
				else{
					for (QuestionDescription q : noq) {
						harry = testUserDao.find(user.getId());
						Map<QuestionDescription, NBallot> aa = user.getNBallot();
						for (Entry<QuestionDescription, NBallot> entry : aa.entrySet()) {
							System.out.println(entry.getKey() + " , " + entry.getValue());
						}
						System.out.println(aa.size());
						NBallot nb = aa.get(q);
						System.out.println(nb + " , " + q);
						int ballot1 = nb.getBallot();
						System.out.println(user.getName()+" have "+ ballot1 + " on question "+ q.getName());
					}
				}
				break;
			case 6:
				System.out.print("Enter user name to vote : ");
				inputName = scanner.nextLine();
				user = testUserDao.find(inputName);
				if(user == null) System.out.println("User not Found");
				else 
				{
					noq = Ebean.find(QuestionDescription.class).findList();
				
					System.out.print("Input question Number to vote : ");
					int inputQ = Integer.parseInt(scanner.nextLine());
					QuestionDescription qd = testQDao.find(inputQ);
					if(qd == null)System.out.println("Question id not found");
					else
					{
						System.out.println("Select a Team : to vote");
						int inputT = Integer.parseInt(scanner.nextLine());
						int b = user.getNBallot().get(qd).getBallot();
						System.out.println("Before : " +b);
						b--;
						user.getNBallot().get(qd).setBallot(b);
						testUserDao.save(user.getNBallot().get(qd));
						System.out.println("Save Successfully with " + user.getNBallot().get(qd).getBallot());
					}
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
		
		TeamDescription t1 = new TeamDescription("Team 1");
		TeamDescription t2 = new TeamDescription("Team 2");
		
		
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
		

		VoteLog vl = new VoteLog(a.getId(), q1.getId(),t1.getId());
		VoteLog vl2 = new VoteLog(a.getId(), q2.getId(),t2.getId());		
		Ebean.save(vl);
		Ebean.save(vl2);
		
	}
	
}
