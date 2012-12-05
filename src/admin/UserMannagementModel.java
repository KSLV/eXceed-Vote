package admin;

import java.util.List;

import database.NBallot;
import database.QuestionDescription;
import database.User;
import exceed.dao.DaoFactory;
import exceed.dao.QuestionDao;

public class UserMannagementModel {

	public UserMannagementModel()
	{
		
	}
	
	public boolean checkDuplicateUser(String username)
	{
		return (DaoFactory.getInstance().getExceedUserDao().find(username) == null);
	}
	
	public void addUser(String username , String password , String nBallot)
	{
		User user = new User(username , password);
		QuestionDao qDAO = DaoFactory.getInstance().getQuestionDao();
		List<QuestionDescription> qdList = qDAO.findAll();
		for (QuestionDescription q : qdList) {
			user.getNBallot().put(q, new NBallot(user, q, Integer.parseInt(nBallot)));
		}
		DaoFactory.getInstance().getExceedUserDao().save(user);
	}
}