import java.io.IOException;
import java.util.Scanner;

/**
 * Console-Based Voter GUI
 * @author KSLV
 * @version Oct 1, 2012
 */
public class SimpleUI {

	private int userID;
	
	/**
	 * Constructor for this class
	 * @param userID Indicate which user is using this class
	 * @throws IOException
	 */
	public SimpleUI(int userID) throws IOException
	{
		this.userID = userID;
		displayMenu();
		getCommand();
	}
	
	/**
	 * Display List of commands
	 * @throws IOException
	 */
	private void displayMenu() throws IOException
	{
		System.out.println("== Voter's Command Menu Alpha version ==");
		System.out.println("Select Question to Vote : 1");
		System.out.println();
		System.out.println("Log Out : 0");
		System.out.print("Enter Command : ");

	}
	
	/**
	 * Receive and handle user input
	 * @throws IOException
	 */
	private void getCommand() throws IOException
	{
		Scanner scanner = new Scanner(System.in);
		int command;
		command = scanner.nextInt();
		do{
			switch(command)
			{
				case 1: displayQuestionList();
				break;
				case 0: System.out.println("Logged out");
				break;
				default: System.out.println("Invalid input. Please enter command again.");
				break;
			}
			if(command != 0)
			{
				displayMenu();
				command = scanner.nextInt();
			}
		}while(command != 0);
	}
	
	/**
	 * Call QuestionMenu UI
	 * @throws IOException
	 */
	private void displayQuestionList() throws IOException
	{
		new QuestionMenu(userID);
	}
}
