package database;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TeamDescription {
	@Id
	private Integer id;
	private String name;
	public TeamDescription() {		
	}
	public TeamDescription(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
