package votemenu;

import database.QuestionDescription;
import database.User;
import exceed.dao.DaoFactory;

public class VoteMenuModel {

	private int ballot;

	public VoteMenuModel()
	{
		
	}
	
	public boolean isTextExist(int num)
	{
		return DaoFactory.getInstance().getTeamDao().find(num) != null;
	}
	
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
	
	public int getUserBallot()
	{
		return ballot;
	}
	
}
