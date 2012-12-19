package exceed.dao;

import com.avaje.ebean.Ebean;

/**
 * Provide Dao for data classes
 * @author Varunyu 5410546326	
 */
public class DaoFactory {

	private static DaoFactory dao;
	
	private DaoFactory()
	{
		Ebean.beginTransaction();
		Ebean.endTransaction();
	}
	
	public static DaoFactory getInstance() {
		if(dao == null)dao = new DaoFactory();
		return dao;
	}
	
	public ExceedUserDao getExceedUserDao() {
		return new ExceedUserDao();
	}
	
	public QuestionDao getQuestionDao() {
		return new QuestionDao();
	}
	
	public TeamDao getTeamDao() {
		return new TeamDao();
	}
	
	public VoteLogDao getVoteLogDao() {
		return new VoteLogDao();
	}
}
