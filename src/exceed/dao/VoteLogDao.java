package exceed.dao;

import com.avaje.ebean.Ebean;

import database.VoteLog;

/**
 * Dao for VoteLog class
 * @author Varunyu 5410546326
 */
public class VoteLogDao {

	public void save(VoteLog vl){
		Ebean.save(vl);
	}
	
	/*
	 * save voteLog with specific user , question , and team
	 */
	public void save(int userId,int questionID,int teamID){
		Ebean.save(new VoteLog(userId, questionID, teamID));
	}
	
	/*
	 * get total score of specific team on a specific question
	 */
	public int getScoreOf(int questionId , int teamId)
	{
		return Ebean.find(VoteLog.class).where().eq("questionId", questionId).eq("teamId", teamId).findList().size();
	}
}
