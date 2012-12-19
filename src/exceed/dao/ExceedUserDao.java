package exceed.dao;

import java.util.List;
import com.avaje.ebean.Ebean;

import database.NBallot;
import database.User;

/**
 * Dao for User class
 * @author Varunyu 5410546326
 */
public class ExceedUserDao  {

	public void save(User user)
	{
		Ebean.save(user);
	}

	public void save(NBallot ballot)
	{
		Ebean.save(ballot);
	}
	
	/*
	 * find user with specific id
	 */
	public User find(Integer id)
	{
		return Ebean.find(User.class).where().eq("id", id).findUnique();
	}
	
	/*
	 * find user with specific username
	 */
	public User find(String username)
	{
		return Ebean.find(User.class).where().eq("username", username).findUnique();
	}
	
	/*
	 * return every user as list
	 */
	public List<User> findAll()
	{
		return Ebean.find(User.class).findList();
	}
}
