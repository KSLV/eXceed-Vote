package database;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

/**
 * Contain a voter username and password
 * @author Varunyu Fuvattanasilp 5410546326
 * @version Nov 9 2012
 */
@Entity
public class User {
	@Id
	private Integer id;
	/** username of user */
	private String username;
	/** password of use */
	private String password;
	/** first name of user */
	private String name;
	/** surname of user */
	private String surename;
	
	/**
	 * map for keep that the ballot is for voting in which question 
	 */
	@OneToMany(cascade=CascadeType.ALL)
	@MapKey(name="question")
	private Map<QuestionDescription, NBallot> nBallot = new LinkedHashMap<QuestionDescription, NBallot>();
	
	public User(String name, String password) {		
		this.username = name;
		this.password = password;
	}
	public User(){
	
	}
	/**
	 * 
	 * @return username for login
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 
	 * @param username
	 */
	public void setUsername(String name) {
		this.username = name;
	}
	/**
	 * 
	 * @return password of user
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 
	 * @return id of user
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
	 * @return map that contain question and ballot
	 */
	public Map<QuestionDescription, NBallot> getNBallot() {
		return nBallot;
	}
	/**
	 * 
	 * @param nBallot
	 */
	public void setNBallot(Map<QuestionDescription, NBallot> nBallot) {
		this.nBallot = nBallot;
	}
	/**
	 * 
	 * @return first name of user
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
	/**
	 * 
	 * @return surname of user
	 */
	public String getSurename() {
		return surename;
	}
	/**
	 * 
	 * @param surename
	 */
	public void setSurename(String surename) {
		this.surename = surename;
	}
	
}
