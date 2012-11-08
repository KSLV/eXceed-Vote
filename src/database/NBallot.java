package database;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class NBallot {
	@Id
	private Integer id;
	@ManyToOne
	private User userPassDB;
	private int ballot;
	
	
	
	public NBallot(){	
	}
	public NBallot(User up,int ballot){
		this.ballot = ballot;
		this.userPassDB = up;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getUserPassDB() {
		return userPassDB;
	}
	public void setUserPassDB(User up) {
		this.userPassDB = up;
	}
	public int getBallot() {
		return ballot;
	}
	public void setBallot(int ballot) {
		this.ballot = ballot;
	}
	
}
