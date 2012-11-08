package database;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class TeamScore {
	@Id
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private List<Uservote> uservote;
	public TeamScore() {
		// TODO Auto-generated constructor stub
	}
	public List<Uservote> getUservote() {
		return uservote;
	}
	public void setUservote(List<Uservote> uservote) {
		this.uservote = uservote;
	}
	
}
