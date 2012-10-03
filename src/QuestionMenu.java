import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
//import java.util.Scanner;
//import java.util.logging.Logger;

/**
 * Display question list and handle user choices
 * @author KSLV
 * @version Sep 30, 2012
 */
public class QuestionMenu {

	private int userID; //Indicate line number of the current user
	//private int questionNumber; //Indicate total number of question
	private String questionListDir = "src//QuestionsList.txt";
	private String nBallotListDir = "src//NBallotList.txt";
	private InputStream qis,nis; //InputStream for QuestionsList.txt and NBallotList.txt, respectively
	private InputStreamReader qin,nin;
	private BufferedReader qbr,nbr;
	private ArrayList<String> questionList;
	private ArrayList<String> nBallotList;	
	
	
	/**
	 * Constructor for this class
	 * @param userID Current user's line number indicator
	 * @throws IOException
	 */
	public QuestionMenu(int userID) throws IOException {
		this.userID = userID;
		questionList = new ArrayList<String>();
		nBallotList = new ArrayList<String>();
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
		qis = new FileInputStream(questionListDir);
		qin = new InputStreamReader(qis);
		qbr = new BufferedReader(qin);
		nis = new FileInputStream(nBallotListDir);
		nin = new InputStreamReader(nis);
		nbr = new BufferedReader(nin);
		
		String brTmp = new String();
		for(int i = 1 ; i <= userID ; i++)
		{
			brTmp = nbr.readLine();
		}
		String[] brSplitTmp = brTmp.split("\t");
		for(int i = 0 ; i < brSplitTmp.length ; i++)
		{
			nBallotList.add(brSplitTmp[i]);
		}
		nis.close();
		nin.close();
		nbr.close();
		
		String tmpQuestion = qbr.readLine();
		while(tmpQuestion != null)
		{
			questionList.add(tmpQuestion);
			tmpQuestion = qbr.readLine();
		}
		qis.close();
		qin.close();
		qbr.close();
		
		

	}
	
	/**
	 * Return QuestionList
	 * @return List of questions
	 */
	public ArrayList<String> getQuestionList()
	{
		return questionList;
	}
	
	/**
	 * Return nBallotList
	 * @return List of Number of ballots
	 */
	public ArrayList<String> getNBallotList()
	{
		return nBallotList;
	}
	
	/**
	 * Return current userID
	 * @return current userID
	 */
	public int getUserID()
	{
		return userID;
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
