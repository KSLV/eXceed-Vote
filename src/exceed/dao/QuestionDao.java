package exceed.dao;
import java.util.List;

import com.avaje.ebean.Ebean;

import database.QuestionDescription;

/**
 * Dao for QuestionDescription class
 * @author Varunyu 5410546326
 */
public class QuestionDao {
	
	public void save(QuestionDescription qd)
	{
		Ebean.save(qd);
	}
	
	/*
	 * find question with specific id
	 */
	public QuestionDescription find(Integer id)
	{
		return Ebean.find(QuestionDescription.class).where().eq("id", id).findUnique();
	}
	
	/*
	 * find question with specific name
	 */
	public QuestionDescription find(String name)
	{
		return Ebean.find(QuestionDescription.class).where().eq("name", name).findUnique();
	}
	
	/*
	 * return every question as list
	 */
	public List<QuestionDescription> findAll()
	{
		return Ebean.find(QuestionDescription.class).findList();
	}
	
}
