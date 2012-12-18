package admin;

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

public class ScoreViewTeamList extends JFrame {

	private JPanel contentPane;
	private JPanel centerZone;
	private JPanel eastZone;
	private List<String> teamList;
	private int userBallot;


	/**
	 * Create the frame.
	 */
	public ScoreViewTeamList() {
		new ArrayList<JButton>();
		teamList = new ArrayList<String>();
		new ArrayList<JButton>();
		setTitle("Score Viewer");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		pack();
	}
	
	public void create(List<Integer> scores , QuestionDescription qDesc)
	{
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(10, 20));
		
		JPanel northZone = new JPanel();
		northZone.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(northZone, BorderLayout.NORTH);
		
		JLabel titleText = new JLabel("Score List of question : " + qDesc.getName()+".");
		titleText.setFont(new Font("Tahoma", Font.PLAIN, 17));
		northZone.add(titleText);
		
		JPanel southZone = new JPanel();
		southZone.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(southZone, BorderLayout.SOUTH);
		southZone.setLayout(new BorderLayout(0, 0));
		
		centerZone = new JPanel();
		contentPane.add(centerZone, BorderLayout.CENTER);
		centerZone.setLayout(new GridLayout(0, 1, 0, 10));
		
		eastZone = new JPanel();
		contentPane.add(eastZone, BorderLayout.EAST);
		eastZone.setLayout(new GridLayout(0, 1, 0, 10));
		
		addList(scores);
		
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
	
	private void addList(List<Integer> scores)
	{
		for(int i=0;i<teamList.size();i++)
		{
			JLabel lblTeam = new JLabel(teamList.get(i));
			centerZone.add(lblTeam);
			JLabel lblScore = new JLabel(scores.get(i).toString());
			eastZone.add(lblScore);
		}
		
	}
	
	public void close() {
		this.dispose();
	}

	
	

}
