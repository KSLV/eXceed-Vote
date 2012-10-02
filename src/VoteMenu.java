import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;


public class VoteMenu extends VoteProcess{

	
	private String teamListDir = ("src//TeamList.txt");
	private int teamNumber;
	private InputStream tis;
	private InputStreamReader tin;
	private BufferedReader tbr;
	private Scanner scanner;
	private ArrayList<String> teamList;
	
	///private final Logger logger = Logger.getLogger(this.toString());
	
	public VoteMenu(int userID, int questionNumber) throws IOException
	{
		super(userID , questionNumber);
		System.out.println("Test");
		readTeamList();
		//displayTeamList();
		
		//readCommand();
	}
	
	private void displayTeamList() throws IOException
	{
		

		
		System.out.printf("You have %d ballot left.\n",getNBallot());
		System.out.printf("Enter team number you like to vote for\nEnter 0 to go back to Question Menu : ");
	}
	
	private void readCommand() throws IOException
	{
		scanner = new Scanner(System.in);
		int command = scanner.nextInt();
		do{
			if(command >= 0)
			{
				if(command == 0) System.out.println("Back to Question List");
				else if(command <= teamNumber)
				{
					if(doVote(command)) System.out.println("Vote Success");
					else System.out.println("Insufficient ballot");
				}else System.out.println("Invalid input. Please enter command again.");
				
			}
			if(command != 0) 
			{
			displayTeamList();
			command = scanner.nextInt();
			}
		}while(command != 0);
	}
	
	private void readTeamList() throws IOException
	{
		teamList = new ArrayList<String>();
		tis = new FileInputStream(teamListDir);
		tin = new InputStreamReader(tis);
		tbr = new BufferedReader(tin);
		String tmpTeam = tbr.readLine();
		while(tmpTeam != null)
		{
			teamList.add(tmpTeam);
			tmpTeam = tbr.readLine();
		}
		tis.close();
		tin.close();
		tbr.close();
	}
	
	public ArrayList<String> getTeamList()
	{
		return teamList;
	}
}
