package admin;

import database.QuestionDescription;
import exceed.dao.DaoFactory;

public class QuestionManagementModel {

	
	public QuestionManagementModel()
	{}
	
	public boolean checkDuplicateQuestion(String questionName)
	{
		return (DaoFactory.getInstance().getQuestionDao().find(questionName) == null);
	}

	public void addQestion(String questionName,int maxballot)
	{
		DaoFactory.getInstance().getQuestionDao().save(new QuestionDescription(questionName,maxballot));
	}
}
