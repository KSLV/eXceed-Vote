package questionmenu;

import database.QuestionDescription;
import exceed.dao.DaoFactory;

/**
 * Model class for QuestionListMenu
 * @author Lattasit 5410545061
 */
public class QuestionListMenuModel {

	public QuestionListMenuModel()
	{
		
	}
	
	/**
	 * check if selected question id existed
	 * @param questionId id of selected question
	 * @return true if question exist , else return false
	 */
	public boolean isQuestionExist(int questionId)
	{
		return DaoFactory.getInstance().getQuestionDao().find(questionId) != null;
	}
	
	/**
	 * get QuestionDescription of a specific ID
	 * @param questionId id of selected question
	 * @return
	 */
	public QuestionDescription getQuestionDesc(int questionId)
	{
		return DaoFactory.getInstance().getQuestionDao().find(questionId);		
	}
	
}
