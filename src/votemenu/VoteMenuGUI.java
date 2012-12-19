package votemenu;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.border.EtchedBorder;

import database.QuestionDescription;
import database.TeamDescription;
import exceed.dao.DaoFactory;

/**
 * View class for VoteMenu
 * @author Khanet	5410545974	
 */
public class VoteMenuGUI extends JFrame {

	private JPanel contentPane;
	private JPanel centerZone;
	private JPanel eastZone;
	private List<JButton> buttonList;
	private List<String> teamList;
	private JButton backButton;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel nBallot;
	private int userBallot;


	/**
	 * Create JFrame and set it visible
	 */
	public VoteMenuGUI() {
		buttonList = new ArrayList<JButton>();
		teamList = new ArrayList<String>();
		new ArrayList<JButton>();
		setTitle("Team List");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		//create();
		pack();
	}
	
	/**
	 * Initialize and setup components 
	 * @param qDesc indicate currently selected question
	 */
	public void create(QuestionDescription qDesc)
	{
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(10, 20));
		
		JPanel northZone = new JPanel();
		northZone.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(northZone, BorderLayout.NORTH);
		
		JLabel titleText = new JLabel("Question : " + qDesc.getName() + ". Please select team to vote");
		titleText.setFont(new Font("Tahoma", Font.PLAIN, 17));
		northZone.add(titleText);
		
		JPanel southZone = new JPanel();
		southZone.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(southZone, BorderLayout.SOUTH);
		southZone.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		southZone.add(panel, BorderLayout.SOUTH);
		
		
		backButton = new JButton("Back");
		panel.add(backButton);
		
		panel_1 = new JPanel();
		southZone.add(panel_1, BorderLayout.NORTH);
		
		nBallot = new JLabel("Ballot :"+userBallot );
		panel_1.add(nBallot);
		
		centerZone = new JPanel();
		contentPane.add(centerZone, BorderLayout.CENTER);
		centerZone.setLayout(new GridLayout(0, 1, 0, 10));
		
		eastZone = new JPanel();
		contentPane.add(eastZone, BorderLayout.EAST);
		eastZone.setLayout(new GridLayout(0, 1, 0, 10));
		
		addList();
		
		pack();
	}
	
	/**
	 * setup List of teamDescription
	 */
	public void setTeamList()
	{
		List<TeamDescription> teamList = DaoFactory.getInstance().getTeamDao().findAll();
		
		for(TeamDescription t : teamList)
		{
			this.teamList.add(t.getName());
		}
	}
	
	/**
	 * Create and add button for every teamDescription in teamList
	 */
	private void addList()
	{
		for(int i=0;i<teamList.size();i++)
		{
			JLabel lblTeam = new JLabel(teamList.get(i));
			centerZone.add(lblTeam);
			JButton button = new JButton("<<<");
			eastZone.add(button);
			buttonList.add(button);
		}
		
	}
	
	/**
	 * get list of team buttons
	 * @return list of team buttons
	 */
	public List<JButton> getButtonList()
	{
		return buttonList;
	}
	
	/**
	 * get back button
	 * @return back button
	 */
	public JButton getbackButton()
	{
		return backButton;
	}

	/**
	 * dispose this page
	 */
	public void close() {
		this.dispose();
	}

	/**
	 * set number of ballot
	 * @param userBallot number of ballot this user have on this question
	 */
	public void setNBallot(int userBallot) {
		this.userBallot = userBallot;
	}
	
	/**
	 * update label indicating number of ballot
	 * @param userBallot number of ballot this user have on this question
	 */
	public void setBallotShow(int userBallot)
	{
		nBallot.setText("Ballot :"+Integer.toString(userBallot));
	}
	

}
