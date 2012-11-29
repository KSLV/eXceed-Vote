package database;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Id
	private Integer id;
	private String name;
	private String password;
	
	@OneToMany(cascade=CascadeType.ALL)
	@MapKey(name="question")
	private Map<QuestionDescription, NBallot> nBallot = new LinkedHashMap<QuestionDescription, NBallot>();
	
	public User(String name, String password) {		
		this.name = name;
		this.password = password;
	}
	public User(){
	
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Map<QuestionDescription, NBallot> getNBallot() {
		return nBallot;
	}
	public void setNBallot(Map<QuestionDescription, NBallot> nBallot) {
		this.nBallot = nBallot;
	}
	
	
}
