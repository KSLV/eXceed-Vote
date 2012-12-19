package admin;

import java.util.List;

import database.NBallot;
import database.QuestionDescription;
import database.User;
import exceed.dao.DaoFactory;
import exceed.dao.QuestionDao;

public class UserMannagementModel {

	public UserMannagementModel()
	{}
	
	public boolean checkDuplicateUser(String username)
	{
		return (DaoFactory.getInstance().getExceedUserDao().find(username) == null);
	}
	
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
