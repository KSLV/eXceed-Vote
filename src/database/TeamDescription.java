package database;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Contain name of a eXceed project's team
 * @author Varunyu Fuvattanasilp 5410546326
 * @version Nov 9 2012
 */
@Entity
public class TeamDescription {
	@Id
	private Integer id;
	/** name of team */
	private String name;
	public TeamDescription() {		
	}
	public TeamDescription(String name) {
		this.name = name;
	}
	/**
	 * 
	 * @return id of team
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 
	 * @return name of team
	 */
	public String getName() {
		return name;
	}
	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
