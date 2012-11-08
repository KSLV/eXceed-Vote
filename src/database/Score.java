package database;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Score {
	@Id
	private Integer id;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private List<QuestionTotal> qtdb;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public Score() {
		// TODO Auto-generated constructor stub
	}
	
	public List<QuestionTotal> getQtdb() {
		return qtdb;
	}
	public void setQtdb(List<QuestionTotal> qtdb) {
		this.qtdb = qtdb;
	}
}
