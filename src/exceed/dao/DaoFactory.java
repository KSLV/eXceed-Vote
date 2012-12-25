package exceed.dao;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.EbeanServerFactory;
import com.avaje.ebean.config.DataSourceConfig;
import com.avaje.ebean.config.ServerConfig;

import database.NBallot;
import database.QuestionDescription;
import database.TeamDescription;
import database.User;
import database.VoteLog;

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

	/**
	 * setting configure of ebean
	 */
	public static void configure() {
		ServerConfig config = new ServerConfig();
		config.setName("ebean");
		config.loadFromProperties();
		config.setDefaultServer(true);
		config.setRegister(true);
		
		Class[] classes = {
				NBallot.class,
				QuestionDescription.class,
				TeamDescription.class,
				User.class,
				VoteLog.class
		};
		for (Class clazz : classes) config.addClass(clazz);
		
		DataSourceConfig ds = new DataSourceConfig();
		ds.loadSettings("mysql");
		config.setDataSourceConfig(ds);
		
		EbeanServer server = EbeanServerFactory.create(config);
	}
}
