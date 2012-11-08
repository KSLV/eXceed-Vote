package database;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Uservote {
	@Id
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	private int score;
	public Uservote() {
		// TODO Auto-generated constructor stub
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
}
