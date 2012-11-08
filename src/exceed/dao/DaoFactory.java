package exceed.dao;

public abstract class DaoFactory {
	
	static DaoFactory getInstance() {
		return null;
	}
	BallotDao getBallotDao() {
		return null;
	}
}
