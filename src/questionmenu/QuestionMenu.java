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
}
