package database;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Contain the number of ballot that user have per criteria 
 * @author Varunyu Fuvattanasilp 5410546326
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
	
	/** number of ballot that user have */
	private int ballot;
	
	public NBallot(){	
	}
	public NBallot(User up,QuestionDescription q,int ballot){
		this.ballot = ballot;
		this.question = q;
		this.user = up;
	}
	
	/**
	 *  
	 * @return QuestionDescription that this ballot can vote
	 */
	public QuestionDescription getQuestion() {
		return question;
	}
	/**
	 * setter of QuestionDescription
	 * @param question
	 */
	public void setQuestion(QuestionDescription question) {
		this.question = question;
	}
	/**
	 * 
	 * @return id of this class 
	 */
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 
	 * @return user that this ballot belong to
	 */
	public User getUser() {
		return user;
	}
	/**
	 * 
	 * @param user
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * 
	 * @return number of ballot 
	 */
	public int getBallot() {
		return ballot;
	}
	/**
	 * 
	 * @param ballot
	 */
	public void setBallot(int ballot) {
		this.ballot = ballot;
	}
	
}
