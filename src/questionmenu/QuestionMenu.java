package questionmenu;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import database.NBallot;
import database.QuestionDescription;
import database.User;
import exceed.dao.DaoFactory;


/**
 * Display question list and handle user choices
 * @author KSLV
 * @version Sep 30, 2012
 */
public class QuestionMenu {

	private User user; //Indicate current user
	//private int questionNumber; //Indicate total number of question
	//private String questionListDir = "src//database//QuestionsList.txt";
	//private String nBallotListDir = "src//database//NBallotList.txt";
	private List<QuestionDescription> questionDesc;
	private List<Integer> nBallotList;	
	
	
	/**
	 * Constructor for this class
	 * @param user Current user's line number indicator
	 * @throws IOException
	 */
	public QuestionMenu(User user) throws IOException {
		this.user = user;
		questionDesc = DaoFactory.getInstance().getQuestionDao().findAll();
		nBallotList = new ArrayList<Integer>();
		readData();
		//displayQuestionList();
		//readCommand();

	}

	/**
	 * Display the List of Vote Questions
	 * @throws IOException
	 */
	private void readData() throws IOException
	{
		Map<QuestionDescription, NBallot> ballotMap = user.getNBallot();
		for (QuestionDescription q : questionDesc) {
			
			NBallot nb = ballotMap.get(q);
			nBallotList.add(nb.getBallot());
		}
	}
	
	/**
	 * Return QuestionList
	 * @return List of questions
	 */
	public List<QuestionDescription> getQuestionDesc()
	{
		return questionDesc;
	}
	
	/**
	 * Return nBallotList
	 * @return List of Number of ballots
	 */
	public List<Integer> getNBallotList()
	{
		return nBallotList;
	}
	
	/**
	 * Return current userID
	 * @return current userID
	 */
	public User getUser()
	{
		return user;
	}
	
	/*
	private void displayQuestionList()
	{
		for(int i = 0 ; i < questionList.size() ; i++)
		{
			System.out.printf("%s (%s ballot left) : %d\n",questionList.get(i),nBallotList.get(i),i + 1);
		}
		
		System.out.println("Back to Menu : 0");
		System.out.print("Enter Command : ");
	}
	
	/**
	 * Receive and handle user commands
	 * @throws IOException
	 */
	/*
	private void readCommand() throws IOException
	{
		scanner = new Scanner(System.in);
		int command = scanner.nextInt();
		do{
			if(command >= 0)
			{
				if(command == 0) System.out.println("Back to Menu");
				else if(command <= questionNumber) 
				{
					qis = new FileInputStream(questionListDir);
					qin = new InputStreamReader(qis);
					qbr = new BufferedReader(qin);
					String brTmp = new String();
					
					for(int i = 1 ; i <= command ; i++)
					{
						brTmp = qbr.readLine();
					}
					System.out.printf("Selected Question : %s\n",brTmp);
					new VoteMenu(userID, command);
				}
				else System.out.println("Invalid input. Please enter command again.");
			}
			if(command != 0) 
				{
				displayQuestionList();
				command = scanner.nextInt();
				}
		}while(command != 0);
	}
	*/
	
}
