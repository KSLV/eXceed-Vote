package votemenu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Properties; 
import org.apache.log4j.Logger; 
import org.apache.log4j.PropertyConfigurator;

/**
 * Handle Vote Processes
 * @author KSLV
 * @version Oct 1, 2012
 */
public abstract class VoteProcess {

	private int userID;
	private int questionNumber;
	private File nBallotList;
	private File voteScore;
	private File tmpNBallotList;
	private File tmpVoteScore;
	private InputStream nis,vis; //InputStream for NBallotList.txt and VoteScore.txt , respectively
	private InputStreamReader nin,vin;
	private BufferedReader nbr,vbr;
	private OutputStream tnos,tvos; //OutputStream for tmpNBallotList.txt and tmpVoteScore.txt , respectively
	private OutputStreamWriter tnor,tvor;
	private BufferedWriter tnbw,tvbw;
	
	private final Logger logger = Logger.getLogger(getClass());	
	protected static Properties properties = new Properties();
	
	/**
	 * Constructor for this class
	 * @param userID Indicate which user is using this class
	 * @param questionNumber Indicate which question this user is voting on
	 * @throws IOException
	 */
	public VoteProcess(int userID,int questionNumber) throws IOException
	{
		PropertyConfigurator.configure("src//log4j//log4j.properties");
		
		logger.info("Question No."+questionNumber);
		
		this.userID = userID;
		this.questionNumber = questionNumber;
		
		nBallotList = new File("src//database//NBallotList.txt");
		voteScore = new File("src//database//VoteScore.txt");
		tmpNBallotList = new File("src//database//tmpNBallotList.txt");
		tmpVoteScore = new File("src//database//tmpVoteScore.txt");
		
		if(tmpNBallotList.exists()) tmpNBallotList.delete();
		if(tmpVoteScore.exists()) tmpVoteScore.delete();
		tmpNBallotList.createNewFile();
		tmpVoteScore.createNewFile();
	}
	
	/**
	 * Read score of specific team
	 * @param team ID of team to have score return
	 * @return Score of specific team
	 * @throws IOException
	 */
	public int getScore(int team) throws IOException{
		vis = new FileInputStream(voteScore);
		vin = new InputStreamReader(vis);
		vbr = new BufferedReader(vin);
		String TmpScore = new String();
		for(int i =1;i <= questionNumber;i++){
			TmpScore = vbr.readLine();
		}
		String[] Score = TmpScore.split("\t");
		vis.close();
		vin.close();
		vbr.close();
		vis = null;
		vin = null;
		vbr = null;
		return Integer.parseInt(Score[team-1]);
	}
	
	/**
	 * Read number of ballots of current user and return it as int
	 * @return Number of ballot of this user as Integer
	 * @throws IOException
	 */
	public int getNBallot() throws IOException
	{
		nis = new FileInputStream(nBallotList);
		nin = new InputStreamReader(nis);
		nbr = new BufferedReader(nin);
		String brTmp = new String();
		for(int i = 1 ; i <= userID ; i++)
		{
			brTmp = nbr.readLine();
		}
		String[] brSplit = brTmp.split("\t");
		nis.close();
		nin.close();
		nbr.close();
		nis = null;
		nin = null;
		nbr = null;
		System.gc();
		return Integer.parseInt(brSplit[questionNumber - 1]);
	}
	
	/**
	 * Alter VoteScore and NBallotList by Read and Overwrite the file 
	 * @param team Number of team which user has chosen
	 * @return true if vote is success, else false
	 * @throws IOException
	 */
	protected boolean doVote(int team) throws IOException
	{
		if(getNBallot() > 0)
		{
			logger.info("vote to team "+ team);
			
			writeTmpVote(team);
			writeTmpNBallot(team);
			if(nBallotList.exists() && voteScore.exists())
			{
				if(nBallotList.delete()) tmpNBallotList.renameTo(nBallotList);
				else
				{
					logger.info("NBallotList deletion failed");
					return false;
				}
				if(voteScore.delete()) tmpVoteScore.renameTo(voteScore);
				else 
				{
					logger.info("VoteScore deletion failed");
					return false;
				}
				return true;
			}
			logger.info("NBallotList or VoteScore doesn't exist");
			return false;
		}
		logger.info("Out of Ballot");
		return false;
	}
	
	/**
	 * Write temporary VoteScore which to be replace the original VoteScore.txt
	 * @param team Indicate which team number the user voted on
	 * @throws IOException
	 */
	private void writeTmpVote(int team) throws IOException
	{
		vis = new FileInputStream(voteScore);
		vin = new InputStreamReader(vis);
		vbr = new BufferedReader(vin);
		tvos = new FileOutputStream(tmpVoteScore);
		tvor = new OutputStreamWriter(tvos);
		tvbw = new BufferedWriter(tvor);
		String tmpText = new String();
		tmpText = vbr.readLine();
		int questionCount = 1;
		while(tmpText != null)
		{
			if(questionCount == questionNumber)
			{
				String[] tmpSplitText = tmpText.split("\t");
				int tmpScore = Integer.parseInt(tmpSplitText[team - 1]) + 1;
				tmpSplitText[team - 1] = Integer.toString(tmpScore);
				for(int i = 0 ; i < tmpSplitText.length ; i++)
				{
					tvbw.write(tmpSplitText[i] + "\t");
					tvbw.flush();
				}
				tvbw.newLine();
				tvbw.flush();
			}else{
			tvbw.write(tmpText);
			tvbw.newLine();
			tvbw.flush();
			}
			tmpText = vbr.readLine();
			questionCount++;
		}
		vis.close();
		vin.close();
		vbr.close();
		tvos.close();
		tvor.close();
		tvbw.close();
	}
	
	/**
	 * Write temporary nBallot which to be replace the original NBallotList.txt
	 * @param team Indicate which team number user voted on
	 * @throws IOException
	 */
	private void writeTmpNBallot(int team) throws IOException
	{
		nis = new FileInputStream(nBallotList);
		nin = new InputStreamReader(nis);
		nbr = new BufferedReader(nin);
		tnos = new FileOutputStream(tmpNBallotList);
		tnor = new OutputStreamWriter(tnos);
		tnbw = new BufferedWriter(tnor);
		
		
		String tmpText = new String();
		tmpText = nbr.readLine();
		int personCount = 1;
		while(tmpText != null)
		{
			
			if(personCount == userID)
			{
				String[] tmpSplitText = tmpText.split("\t");
				int tmpBallot = Integer.parseInt(tmpSplitText[questionNumber - 1]) - 1;
				tmpSplitText[questionNumber - 1] = Integer.toString(tmpBallot);
				for(int i = 0 ; i < tmpSplitText.length ; i++)
				{
					tnbw.write(tmpSplitText[i] + "\t");
					tnbw.flush();
				}
				tnbw.newLine();
				tnbw.flush();
			}else{
				tnbw.write(tmpText);
				tnbw.newLine();
				tnbw.flush();
			}
			tmpText = nbr.readLine();
			personCount++;
		}
		nis.close();
		nin.close();
		nbr.close();
		nis = null;
		nin = null;
		nbr = null;
		tnos.close();
		tnor.close();
		tnbw.close();
		System.gc();
	}
	
	
	/*private void closeAllStream() throws IOException
	{
		vis.close();
		vin.close();
		vbr.close();
		nis.close();
		nin.close();
		nbr.close();
		tvos.close();
		tvor.close();
		tvbw.close();
		tnos.close();
		tnor.close();
		tnbw.close();
	}*/
}
