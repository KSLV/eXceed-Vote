package admin;

import java.util.ArrayList;
import java.util.List;

import database.QuestionDescription;
import database.TeamDescription;
import database.User;
import exceed.dao.DaoFactory;
import exceed.dao.VoteLogDao;

/**
 * Model class of ScoreViewTeamList
 * @author Varunyu	5410546326	
 */
public class ScoreViewTeamListModel {

	public ScoreViewTeamListModel()
	{}

	/**
	 * Return list of score on each team on this question
	 * @param qDesc Currently selected question
	 * @return List of score on each team as int
	 */
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
