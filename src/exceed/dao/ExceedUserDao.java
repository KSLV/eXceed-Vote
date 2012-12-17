package exceed.dao;

import java.util.List;
import com.avaje.ebean.Ebean;

import database.NBallot;
import database.User;

public class ExceedUserDao  {

	public void save(User user)
	{
		Ebean.save(user);
	}
	
	public void save(NBallot ballot)
	{
		Ebean.save(ballot);
	}
	
	public User find(Integer id)
	{
		return Ebean.find(User.class).where().eq("id", id).findUnique();
	}
	
	public User find(String username)
	{
		return Ebean.find(User.class).where().eq("username", username).findUnique();
	}
	
	public List<User> findAll()
	{
		return Ebean.find(User.class).findList();
	}
}
