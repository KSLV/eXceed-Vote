package database;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class VoteLog {
	
	private Integer userId;	
	private Integer questionId;
	
	private Integer teamId;
	
	public VoteLog() {
		// TODO Auto-generated constructor stub
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
