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
}
