package questionmenu;

import java.util.List;

import database.NBallot;
import database.QuestionDescription;
import database.User;
import exceed.dao.DaoFactory;
import exceed.dao.QuestionDao;

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
	
	/**
	 * Check that user have ballot for all question or not if not it will auto generate ballot
	 * @param user
	 */
	public void checkballot(User user){
		QuestionDao qDAO = DaoFactory.getInstance().getQuestionDao();
		List<QuestionDescription> qdList = qDAO.findAll();
		
		for (QuestionDescription q : qdList) {
			if(!user.getNBallot().containsKey(q)){
				NBallot ballot = new NBallot(user, q, q.getMaxballot());
				user.getNBallot().put(q, ballot);
				DaoFactory.getInstance().getExceedUserDao().save(ballot);
			}
		}
		
	}
	
}
