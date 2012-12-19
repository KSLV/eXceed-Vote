package admin;

import database.QuestionDescription;
import exceed.dao.DaoFactory;

public class ScoreViewQuestionListModel {

	public ScoreViewQuestionListModel()
	{}
	
	public boolean isQuestionExist(int num)
	{
		return DaoFactory.getInstance().getQuestionDao().find(num) != null;
	}
	
	public QuestionDescription getQuestionDesc(int num)
	{
		return DaoFactory.getInstance().getQuestionDao().find(num);		
	}
	
}
