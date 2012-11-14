package exceed.dao;

import java.util.Collection;
import java.util.List;

import com.avaje.ebean.Ebean;

import database.QuestionDescription;
import database.User;

public class UserDao {

	public void save(User user)
	{
		Ebean.save(user);
	}
	
	public User find(Integer id)
	{
		return Ebean.find(User.class).where().eq("id", id).findUnique();
	}
	
	public Collection<User> findAll()
	{
		return Ebean.find(User.class).findList();
	}
}
