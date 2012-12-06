package votemenu;

import java.awt.BorderLayout;
import java.awt.EventQueue;
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
import exceed.dao.QuestionDao;

public class VoteMenuGUI2 extends JFrame {

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
	 * Create the frame.
	 */
	public VoteMenuGUI2() {
		buttonList = new ArrayList<JButton>();
		teamList = new ArrayList<String>();
		setTitle("Team List");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		//create();
		pack();
	}
	
	public void create()
	{
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(10, 20));
		
		JPanel northZone = new JPanel();
		northZone.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(northZone, BorderLayout.NORTH);
		
		JLabel titleText = new JLabel("Team List");
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
		eastZone.setLayout(new GridLayout(0, 2, 0, 10));
		
		addList();
		
		pack();
	}
	
	public void setTeamList()
	{
		List<TeamDescription> teamList = DaoFactory.getInstance().getTeamDao().findAll();
		
		for(TeamDescription t : teamList)
		{
			this.teamList.add(t.getName());
		}
	}
	
	private void addList()
	{
		for(int i=0;i<teamList.size();i++)
		{
			JLabel lblTeam = new JLabel(teamList.get(i));
			centerZone.add(lblTeam);
			JButton button = new JButton("<<<");
			JButton desButton = new JButton("?");
			eastZone.add(button);
			eastZone.add(desButton);
			buttonList.add(button);
		}
		
	}
	
	public List<JButton> getButtonList()
	{
		return buttonList;
	}
	
	public JButton getbackButton()
	{
		return backButton;
	}

	public void close() {
		this.dispose();
	}

	public void setNBallot(int userBallot) {
		this.userBallot = userBallot;
	}
	
	public void setBallotShow(int userBallot)
	{
		nBallot.setText("Ballot :"+Integer.toString(userBallot));
	}
	

}
