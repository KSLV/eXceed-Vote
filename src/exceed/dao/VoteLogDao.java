package exceed.dao;

import com.avaje.ebean.Ebean;

import database.VoteLog;

public class VoteLogDao {

	public void save(VoteLog vl){
		Ebean.save(vl);
	}
	
	public void save(int userId,int questionID,int teamID){
		Ebean.save(new VoteLog(userId, questionID, teamID));
	}
}
