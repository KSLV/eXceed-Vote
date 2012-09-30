import java.io.IOException;
import java.util.Scanner;


public class SimpleUI {

	private int userID;
	
	public SimpleUI(int userID) throws IOException
	{
		this.userID = userID;
		displayMenu();
		getCommand();
	}
	

	private void displayMenu() throws IOException
	{
		System.out.println("== Voter's Command Menu Alpha version ==");
		System.out.println("Select Question to Vote : 1");
		System.out.println();
		System.out.println("Log Out : 0");
		System.out.print("Enter Command : ");

	}
	
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
	
	private void displayQuestionList() throws IOException
	{
		new QuestionMenu(userID);
	}
}
