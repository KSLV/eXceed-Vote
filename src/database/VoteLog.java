package database;

import java.sql.Timestamp;

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
	private Timestamp time;
	
	public VoteLog()
	{
		
	}
	public VoteLog(Integer id,Integer qi,Integer ti){
		this.userId = id;
		this.questionId = qi;
		this.teamId = ti;
		this.time = new Timestamp(System.currentTimeMillis());
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
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
}
