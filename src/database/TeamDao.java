package database;

import java.util.List;
import com.avaje.ebean.Ebean;


public class TeamDao {
	
	public void save(TeamDescription td)
	{
		Ebean.save(td);
	}
	
	public TeamDescription find(Integer id)
	{
		return Ebean.find(TeamDescription.class).where().eq("id", id).findUnique();
	}
	
	public TeamDescription find(String name)
	{
		return Ebean.find(TeamDescription.class).where().eq("name", name).findUnique();
	}
	
	public List<TeamDescription> findAll()
	{
		return Ebean.find(TeamDescription.class).findList();
	}
	
}
