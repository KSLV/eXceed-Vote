package votemenu;

import java.io.IOException;
import java.util.Properties; 
import org.apache.log4j.Logger; 
import org.apache.log4j.PropertyConfigurator;

import database.QuestionDescription;
import database.User;
import exceed.dao.DaoFactory;
import servicelocator.ServiceLocator;

/**
 * Handle Vote Processes
 * @author KSLV
 * @version Oct 1, 2012
 */
public abstract class VoteProcess {

	private User user;
	private QuestionDescription questionDesc;

	
	private final Logger logger = Logger.getLogger(getClass());	
	protected static Properties properties = new Properties();
	
	/**
	 * Constructor for this class
	 * @param user Indicate which user is using this class
	 * @param q Indicate which question this user is voting on
	 * @throws IOException
	 */
	public VoteProcess(User user,QuestionDescription q) throws IOException
	{
		ServiceLocator sl = ServiceLocator.getServiceLocator();
		
		PropertyConfigurator.configure(sl.getLog4jPath());
		
		logger.info("Question No."+q);
		
		this.user = user;
		this.questionDesc = q;
		
		
	}
	
//	/**
//	 * Read score of specific team
//	 * @param team ID of team to have score return
//	 * @return Score of specific team
//	 * @throws IOException
//	 */
//	public int getScore(int team) throws IOException{
//		vis = new FileInputStream(voteScore);
//		vin = new InputStreamReader(vis);
//		vbr = new BufferedReader(vin);
//		String TmpScore = new String();
//		for(int i =1;i <= questionDesc;i++){
//			TmpScore = vbr.readLine();
//		}
//		String[] Score = TmpScore.split("\t");
//		vis.close();
//		vin.close();
//		vbr.close();
//		vis = null;
//		vin = null;
//		vbr = null;
//		return Integer.parseInt(Score[team-1]);
//	}
	
	/**
	 * Read number of ballots of current user and return it as int
	 * @return Number of ballot of this user as Integer
	 * @throws IOException
	 */
	public int getNBallot() throws IOException
	{
		return user.getNBallot().get(questionDesc).getBallot();
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
			DaoFactory.getInstance().getVoteLogDao().save(user.getId(), questionDesc.getId(), team);
			int ballot = user.getNBallot().get(questionDesc).getBallot();
			user.getNBallot().get(questionDesc).setBallot(ballot - 1);
			DaoFactory.getInstance().getExceedUserDao().save(user.getNBallot().get(questionDesc));
			logger.info("Vote completed on teamID " + team + " in questionID " + questionDesc.getId() + " by user " + user.getName());
			return true;
		}
		logger.info("Out of Ballot");
		return false;
	}
	
	/**
	 * Write temporary VoteScore which to be replace the original VoteScore.txt
	 * @param team Indicate which team number the user voted on
	 * @throws IOException
	 */
//	private void writeTmpVote(int team) throws IOException
//	{
//		String tmpText = new String();
//		tmpText = vbr.readLine();
//		int questionCount = 1;
//		while(tmpText != null)
//		{
//			if(questionCount == questionDesc)
//			{
//				String[] tmpSplitText = tmpText.split("\t");
//				int tmpScore = Integer.parseInt(tmpSplitText[team - 1]) + 1;
//				tmpSplitText[team - 1] = Integer.toString(tmpScore);
//				for(int i = 0 ; i < tmpSplitText.length ; i++)
//				{
//					tvbw.write(tmpSplitText[i] + "\t");
//					tvbw.flush();
//				}
//				tvbw.newLine();
//				tvbw.flush();
//			}else{
//			tvbw.write(tmpText);
//			tvbw.newLine();
//			tvbw.flush();
//			}
//			tmpText = vbr.readLine();
//			questionCount++;
//		}
//		vis.close();
//		vin.close();
//		vbr.close();
//		tvos.close();
//		tvor.close();
//		tvbw.close();
//	}
	
	/**
	 * Write temporary nBallot which to be replace the original NBallotList.txt
	 * @param team Indicate which team number user voted on
	 * @throws IOException
	 */
//	private void writeTmpNBallot(int team) throws IOException
//	{
//		nis = new FileInputStream(nBallotList);
//		nin = new InputStreamReader(nis);
//		nbr = new BufferedReader(nin);
//		tnos = new FileOutputStream(tmpNBallotList);
//		tnor = new OutputStreamWriter(tnos);
//		tnbw = new BufferedWriter(tnor);
//		
//		
//		String tmpText = new String();
//		tmpText = nbr.readLine();
//		int personCount = 1;
//		while(tmpText != null)
//		{
//			
//			if(personCount == user)
//			{
//				String[] tmpSplitText = tmpText.split("\t");
//				int tmpBallot = Integer.parseInt(tmpSplitText[questionDesc - 1]) - 1;
//				tmpSplitText[questionDesc - 1] = Integer.toString(tmpBallot);
//				for(int i = 0 ; i < tmpSplitText.length ; i++)
//				{
//					tnbw.write(tmpSplitText[i] + "\t");
//					tnbw.flush();
//				}
//				tnbw.newLine();
//				tnbw.flush();
//			}else{
//				tnbw.write(tmpText);
//				tnbw.newLine();
//				tnbw.flush();
//			}
//			tmpText = nbr.readLine();
//			personCount++;
//		}
//		nis.close();
//		nin.close();
//		nbr.close();
//		nis = null;
//		nin = null;
//		nbr = null;
//		tnos.close();
//		tnor.close();
//		tnbw.close();
//		System.gc();
//	}
	
	
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
