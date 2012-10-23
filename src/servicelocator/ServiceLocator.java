package servicelocator;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ServiceLocator {

	private static String log4j = "src//log4j//log4j.properties";
	
	private static String questionListDir = "src//database//QuestionsList.txt";
	
	
	private static String teamListDir = "src//database//TeamList.txt";	
	
	private static String userListDir = "src//database//UsernameList.txt";
	private static String passListDir = "src//database//PasswordList.txt";	
	
	private static String nBallotList = "src//database//NBallotList.txt";
	private static String voteScore = "src//database//VoteScore.txt";
	private static String tmpNBallotList = "src//database//tmpNBallotList.txt";
	private static String tmpVoteScore = "src//database//tmpVoteScore.txt";
	
	public static ServiceLocator sl = new ServiceLocator();
	
	private ServiceLocator(){				
	}
	public static ServiceLocator getServiceLocator(){
		return sl;
	}
	public String getLog4jPath(){
		return log4j;
	}
	public String getQuestionListPath(){
		return questionListDir;
	}
	public String getNBallotListPath(){
		return nBallotList;
	}
	public String getTeamListPath(){
		return teamListDir;
	}
	public String getUserListPath(){
		return userListDir;
	}
	public String getPassListPath(){
		return passListDir;
	}
	public String getVoteScorePath(){
		return voteScore;
	}
	public String getTmpBallotListPath(){
		return tmpNBallotList;
	}
	public String getTmpVoteScorePath(){
		return tmpVoteScore;
	}
}
