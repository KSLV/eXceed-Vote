package exceed.dao;

import java.util.List;
import com.avaje.ebean.Ebean;

import database.TeamDescription;

/**
 * Dao for TeamDescription class
 * @author Varunyu 5410546326
 */
public class TeamDao {
	
	public void save(TeamDescription td)
	{
		Ebean.save(td);
	}
	
	/*
	 * find team with specific id
	 */
	public TeamDescription find(Integer id)
	{
		return Ebean.find(TeamDescription.class).where().eq("id", id).findUnique();
	}
	
	/*
	 * find team with specific name
	 */
	public TeamDescription find(String name)
	{
		return Ebean.find(TeamDescription.class).where().eq("name", name).findUnique();
	}
	
	/*
	 * return every team as list
	 */
	public List<TeamDescription> findAll()
	{
		return Ebean.find(TeamDescription.class).findList();
	}
	
}
