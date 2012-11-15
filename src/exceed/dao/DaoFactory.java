package exceed.dao;

public class DaoFactory {

	private static DaoFactory dao;
	
	private DaoFactory()
	{
		
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
}
