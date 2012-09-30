import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;


public class QuestionMenu {

	private int userID;
	private int questionNumber;
	private String questionListDir = "src//QuestionsList.txt";
	private String nBallotListDir = "src//NBallotList.txt";
	private InputStream qis,nis;
	private InputStreamReader qin,nin;
	private BufferedReader qbr,nbr;
	private Scanner scanner;
	
	public QuestionMenu(int userID) throws IOException {
		this.userID = userID;
		displayQuestionList();
		readCommand();

	}

	private void displayQuestionList() throws IOException
	{
		qis = new FileInputStream(questionListDir);
		qin = new InputStreamReader(qis);
		qbr = new BufferedReader(qin);
		nis = new FileInputStream(nBallotListDir);
		nin = new InputStreamReader(nis);
		nbr = new BufferedReader(nin);
		questionNumber = 0;
		
		String brTmp = new String();
		for(int i = 1 ; i <= userID ; i++)
		{
			brTmp = nbr.readLine();
		}
		nis.close();
		nin.close();
		nbr.close();
		
		String[] NBallotTemp = brTmp.split("\t");
		String tmpQuestion = qbr.readLine();
		for(int questionNumCounter = 1 ; tmpQuestion != null ; questionNumCounter++)
		{
			System.out.printf("%s ( %s Ballot Left ) : %d\n",tmpQuestion, NBallotTemp[questionNumber], questionNumCounter);
			tmpQuestion = qbr.readLine();
			questionNumber++;
		}
		qis.close();
		qin.close();
		qbr.close();
		
		System.out.println("Back to Menu : 0");
		System.out.print("Enter Command : ");

	}
	
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
	
	
}
