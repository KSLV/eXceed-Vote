package database;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class QuestionTotal {

	@Id
	private Integer id;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private List<TeamScore> TSDB;
	public QuestionTotal() {
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<TeamScore> getTSDB() {
		return TSDB;
	}
	public void setTSDB(List<TeamScore> tSDB) {
		TSDB = tSDB;
	}
	
}
