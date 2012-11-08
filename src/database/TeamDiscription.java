package database;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TeamDiscription {
	@Id
	private Integer id;
	private String name;
	public TeamDiscription() {		
	}
	public TeamDiscription(String name) {
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
