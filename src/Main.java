import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import com.avaje.ebean.Ebean;

import database.NBallot;
import database.QuestionDescription;
import database.User;
import exceed.dao.DaoFactory;
import exceed.dao.ExceedUserDao;
import exceed.dao.QuestionDao;
import servicelocator.ServiceLocator;




public class Main {

	public static void main(String [] args) throws IOException
	{		
		ServiceLocator.getServiceLocator();		
		//new login.LoginGUIController();
		new admin.QuestionManagement();
		new admin.TeamManagement();
		
	}
	private static void consoleTest() {
		int testInput = 0;
		QuestionDao testQDao = DaoFactory.getInstance().getQuestionDao();
		List<QuestionDescription> noq = testQDao.findAll();
		ExceedUserDao testUserDao = DaoFactory.getInstance().getExceedUserDao();
		DaoFactory.getInstance().getTeamDao();
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
						user = testUserDao.find(user.getId());
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
						Integer.parseInt(scanner.nextLine());
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
	
	
}
