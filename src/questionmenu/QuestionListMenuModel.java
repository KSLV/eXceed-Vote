package questionmenu;

import database.QuestionDescription;
import exceed.dao.DaoFactory;

public class QuestionListMenuModel {

	public QuestionListMenuModel()
	{
		
	}
	
	public boolean isQuestionExist(int num)
	{
		return DaoFactory.getInstance().getQuestionDao().find(num) != null;
	}
	
	public QuestionDescription getQuestionDesc(int num)
	{
		return DaoFactory.getInstance().getQuestionDao().find(num);		
	}
	
}
