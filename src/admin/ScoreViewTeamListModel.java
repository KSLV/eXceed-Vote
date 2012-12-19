package admin;

import java.util.ArrayList;
import java.util.List;

import database.QuestionDescription;
import database.TeamDescription;
import database.User;
import exceed.dao.DaoFactory;
import exceed.dao.VoteLogDao;

public class ScoreViewTeamListModel {

	private int ballot;

	public ScoreViewTeamListModel()
	{}
	
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
	
	public List<Integer> getScoreList(QuestionDescription qDesc)
	{
		List<Integer> scores = new ArrayList<Integer>();
		List<TeamDescription> teamList = DaoFactory.getInstance().getTeamDao().findAll();
		VoteLogDao voteLogDao = DaoFactory.getInstance().getVoteLogDao();
		
		for(int i = 0 ; i < teamList.size() ; i++)
		{
			scores.add(voteLogDao.getScoreOf(qDesc.getId(), teamList.get(i).getId()));
		}
		
		return scores;
	}
	
}
