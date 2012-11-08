package exceed.dao;

public interface BallotDao {
	Ballot find(Integer id);
	void save(Ballot b);
	void delete(Ballot b);
}
