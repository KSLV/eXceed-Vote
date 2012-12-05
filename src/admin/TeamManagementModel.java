package admin;

import database.TeamDescription;
import exceed.dao.DaoFactory;

public class TeamManagementModel {

	public TeamManagementModel()
	{
		
	}
	
	public boolean checkDuplicateTeam(String teamName)
	{
		return (DaoFactory.getInstance().getTeamDao().find(teamName) == null);
	}
	
	public void addTeam(String teamName)
	{
		DaoFactory.getInstance().getTeamDao().save(new TeamDescription(teamName));
	}
}
