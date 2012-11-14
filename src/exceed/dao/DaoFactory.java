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
	public UserDao getUserDao() {
		return new UserDao();
	}
	public BallotDao getBallotDao() {
		return new BallotDao();
	}
}
