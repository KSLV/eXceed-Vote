package votemenu;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import database.QuestionDescription;
import database.User;

import servicelocator.ServiceLocator;
//import java.util.Scanner;

/**
 * Console-Based VoteMenuGUI
 * @author KSLV
 * @version Oct 1, 2012
 */
public class VoteMenu extends VoteProcess{
		
	private ArrayList<String> teamList; //Contain List name of each team
	
	///private final Logger logger = Logger.getLogger(this.toString());
	
	/**
	 * Constructor for this class
	 * @param user Indicate which userID has logged in
	 * @param q Indicate which question number this user is voting 
	 * @throws IOException
	 */
	public VoteMenu(User user, QuestionDescription q) throws IOException
	{
		super(user , q);		
		//readTeamList();		
	}
	/*
	/**
	 * Read and store name of each team in List
	 * @throws IOException
	 */
	/*
	private void readTeamList() throws IOException
	{
		ServiceLocator sl = ServiceLocator.getServiceLocator();
		
		teamList = new ArrayList<String>();
		tis = new FileInputStream(sl.getTeamListPath());
		tin = new InputStreamReader(tis);
		tbr = new BufferedReader(tin);
		String tmpTeam = tbr.readLine();
		while(tmpTeam != null)
		{
			teamList.add(tmpTeam);
			tmpTeam = tbr.readLine();
		}
		tis.close();
		tin.close();
		tbr.close();
	}
	*/
	/**
	 * Return teamList
	 * @return List of team name
	 */
	/*
	public ArrayList<String> getTeamList()
	{
		return teamList;
	}
	*/
}
