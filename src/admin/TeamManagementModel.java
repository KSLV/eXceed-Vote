package admin;

import database.TeamDescription;
import exceed.dao.DaoFactory;

/**
 * Model class of TeamManagement
 * @author Varunyu 5410546326	
 */
public class TeamManagementModel {

	public TeamManagementModel()
	{}
	
	/**
	 * Check if there is already a team with this name or not
	 * @param teamName A name to be check
	 * @return true if there exist some team with this name , else return false
	 */
	public boolean checkDuplicateTeam(String teamName)
	{
		return (DaoFactory.getInstance().getTeamDao().find(teamName) != null);
	}
	
	/**
	 * Add a team with specific name to the database
	 * @param teamName A name of team to be add
	 */
	public void addTeam(String teamName)
	{
		DaoFactory.getInstance().getTeamDao().save(new TeamDescription(teamName));
	}
}
