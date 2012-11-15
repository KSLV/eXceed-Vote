package exceed.dao;

import java.util.List;
import com.avaje.ebean.Ebean;
import database.User;

public class ExceedUserDao  {

	public void save(User user)
	{
		Ebean.save(user);
	}
	
	public User find(Integer id)
	{
		return Ebean.find(User.class).where().eq("id", id).findUnique();
	}
	
	public User find(String name)
	{
		return Ebean.find(User.class).where().eq("name", name).findUnique();
	}
	
	public List<User> findAll()
	{
		return Ebean.find(User.class).findList();
	}
}
