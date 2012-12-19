package database;

import java.sql.Timestamp;

import javax.persistence.Entity;

/**
 * Contain which user voted on which questionId in for which teamId.
 * @author Varunyu Fuvattanasilp 5410546326
 * @version Nov 9 2012
 */
@Entity
public class VoteLog {
	
	/** id of user */
	private Integer userId;	
	/** id of question */
	private Integer questionId;	
	/** id of team */
	private Integer teamId;
	/** time that this log is create */
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
	/**
	 * 
	 * @return id of user
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * 
	 * @param userId
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * 
	 * @return id of question 
	 */
	public Integer getQuestionId() {
		return questionId;
	}
	/**
	 * 
	 * @param questionId
	 */
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}
	/**
	 * 
	 * @return id of team 
	 */
	public Integer getTeamId() {
		return teamId;
	}
	/** 
	 * 
	 * @param teamId
	 */
	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}
	/**
	 * 
	 * @return time
	 */
	public Timestamp getTime() {
		return time;
	}
	/**
	 * 
	 * @param time
	 */
	public void setTime(Timestamp time) {
		this.time = time;
	}
}
