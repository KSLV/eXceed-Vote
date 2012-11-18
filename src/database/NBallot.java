package database;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Contain the number of ballot that user have per criteria 
 * @author 
 * @version Nov 9 2012
 */
@Entity
public class NBallot {
	@Id
	private Integer id;
	
	@ManyToOne
	private User user; // user who this ballot belong to
	@ManyToOne
	private QuestionDescription question; // 
	
	private int ballot;
	
	public NBallot(){	
	}
	public NBallot(User up,QuestionDescription q,int ballot){
		this.ballot = ballot;
		this.question = q;
		this.user = up;
	}
	
	public QuestionDescription getQuestion() {
		return question;
	}
	public void setQuestion(QuestionDescription question) {
		this.question = question;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getBallot() {
		return ballot;
	}
	public void setBallot(int ballot) {
		this.ballot = ballot;
	}
	
}
