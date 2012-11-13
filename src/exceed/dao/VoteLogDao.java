package exceed.dao;

import java.util.List;

import com.avaje.ebean.Ebean;

import database.VoteLog;

public class VoteLogDao {

	public void save(VoteLog vl){
		Ebean.save(vl);
	}
}
