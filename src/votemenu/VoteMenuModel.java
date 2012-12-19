package votemenu;

import database.QuestionDescription;
import database.User;
import exceed.dao.DaoFactory;

/**
 * Model class for VoteMenu
 * @author Lattasit 5410545061
 */
public class VoteMenuModel {

	private int ballot;

	public VoteMenuModel()
	{
		
	}
	
	/**
	 * Check if team with specific ID existed or not
	 * @param num id of a team
	 * @return true if team exist , else return false
	 */
	public boolean isTeamExist(int num)
	{
		return DaoFactory.getInstance().getTeamDao().find(num) != null;
	}
	
	/**
	 * Vote on the selected team
	 * @param user indicate current User
	 * @param qDesc indicate selected question
	 * @param team team id to be vote on
	 * @return true if vote success , else return false
	 */
	public boolean vote(User user , QuestionDescription qDesc , int team)
	{
		if(user.getNBallot().get(qDesc).getBallot() > 0)
		{
			DaoFactory.getInstance().getVoteLogDao().save(user.getId(), qDesc.getId(), team);	
			ballot = user.getNBallot().get(qDesc).getBallot();
			user.getNBallot().get(qDesc).setBallot(ballot - 1);
			DaoFactory.getInstance().getExceedUserDao().save(user.getNBallot().get(qDesc));
			return true;
		}
		return false;
	}
	
	/**
	 * Get number of ballot the user have on this specific question
	 * @param user current User
	 * @param qDesc current question
	 * @return number of ballot the user have on this question
	 */
	public int getUserBallot(User user , QuestionDescription qDesc)
	{
		return user.getNBallot().get(qDesc).getBallot();
	}
	
}
