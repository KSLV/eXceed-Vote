package exceed.dao;
import java.util.List;

import com.avaje.ebean.Ebean;

import database.QuestionDescription;

public class QuestionDao {
	
	public void save(QuestionDescription qd)
	{
		Ebean.save(qd);
	}
	
	public QuestionDescription find(Integer id)
	{
		return Ebean.find(QuestionDescription.class).where().eq("id", id).findUnique();
	}
	
	public QuestionDescription find(String name)
	{
		return Ebean.find(QuestionDescription.class).where().eq("name", name).findUnique();
	}
	
	public List<QuestionDescription> findAll()
	{
		return Ebean.find(QuestionDescription.class).findList();
	}
	
}
