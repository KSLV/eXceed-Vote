package database;

import javax.persistence.Entity;

/**
 * Contain which user voted on which questionId in for which teamId.
 * @author Varunyu 5410546326
 * @version Nov 9 2012
 */
@Entity
public class VoteLog {
	
	private Integer userId;	
	private Integer questionId;
	
	private Integer teamId;
	
	public VoteLog()
	{
		
	}
	public VoteLog(Integer id,Integer qi,Integer ti){
		this.userId = id;
		this.questionId = qi;
		this.teamId = ti;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}
	public Integer getTeamId() {
		return teamId;
	}
	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}
}
