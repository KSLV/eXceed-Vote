package database;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Contain a eXceed camp's voting criteria.
 * @author Varunyu Fuvattanasilp 5410546326
 * @version Nov 9 2012
 */
@Entity
public class QuestionDescription {
	@Id
	private Integer id;
	/**
	 * name of this question
	 */
	private String name;
	/**
	 * maximum number that user can vote for this question
	 */
	private int maxballot;
	
	public QuestionDescription(){
		
	}
	public QuestionDescription(String name,int maxballot){
		this.name = name;
		this.maxballot = maxballot;
	}
	/**
	 * return id of this entity
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
	 * @return name of question
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
	 * @return maximum number that user can vote for this question
	 */
	public int getMaxballot() {
		return maxballot;
	}
	/**
	 * 
	 * @param maxballot
	 */
	public void setMaxballot(int maxballot) {
		this.maxballot = maxballot;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QuestionDescription other = (QuestionDescription) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
