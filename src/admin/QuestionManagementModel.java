package admin;

import database.QuestionDescription;
import exceed.dao.DaoFactory;

/**
 * Model class of QuestionManagement application
 * @author Lattasit 5410545061
 */
public class QuestionManagementModel {

	
	public QuestionManagementModel()
	{}
	
	/**
	 * Check if there is any question with this name already
	 * @param questionName The name to be check
	 * @return true if there exist some question with given name
	 */
	public boolean checkDuplicateQuestion(String questionName)
	{
		return (DaoFactory.getInstance().getQuestionDao().find(questionName) != null);
	}

	/**
	 * Add a new Question to the database
	 * @param questionName The name of question to be added
	 * @param maxballot Starting number of ballots every user initially have on this question
	 */
	public void addQestion(String questionName,int maxballot)
	{
		DaoFactory.getInstance().getQuestionDao().save(new QuestionDescription(questionName,maxballot));
	}
}
