package admin;

import java.util.List;

import database.NBallot;
import database.QuestionDescription;
import database.User;
import exceed.dao.DaoFactory;
import exceed.dao.QuestionDao;

/**
 * Model class of UserManagement application
 * @author Varunyu 5410546326	
 */
public class UserMannagementModel {

	public UserMannagementModel()
	{}
	
	/**
	 * Check if there is already a User with this name or not
	 * @param username A username to be check
	 * @return true if there exist some user with this username , else return false
	 */
	public boolean checkDuplicateUser(String username)
	{
		return (DaoFactory.getInstance().getExceedUserDao().find(username) != null);
	}
	
	/**
	 * Add a User with specific informations to the database
	 * @param username
	 * @param password
	 * @param name
	 * @param surname
	 */
	public void addUser(String username , String password ,String name,String surname)
	{
		User user = new User(username , password);
		user.setName(name);
		user.setSurename(surname);
		QuestionDao qDAO = DaoFactory.getInstance().getQuestionDao();
		List<QuestionDescription> qdList = qDAO.findAll();
		
		for (QuestionDescription q : qdList) {
			user.getNBallot().put(q, new NBallot(user, q, q.getMaxballot()));
		}
		DaoFactory.getInstance().getExceedUserDao().save(user);
	}
	
	public User getUser(String username)
	{
		return DaoFactory.getInstance().getExceedUserDao().find(username);
	}
	/*
	public void setNBallot(String username , String nBallot)
	{
		User user = getUser(username);
		List<QuestionDescription> qdList = DaoFactory.getInstance().getQuestionDao().findAll();
		for (QuestionDescription qDesc : qdList) {
			user.getNBallot().get(qDesc).setBallot(Integer.parseInt(nBallot));
		}
	}*/
}
