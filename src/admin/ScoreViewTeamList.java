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

/**
 * View class of ScoreViewTeamList application
 * @author Varunyu 5410546326	
 */
public class ScoreViewTeamList extends JFrame {

	/**Center of BorderLayout*/
	private JPanel centerZone;
	/**East of BorderLayout*/
	private JPanel eastZone;
	/**Save list of team name*/
	private List<String> teamList;


	/**
	 * Set important variable
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
	
	/**
	 * Create the frame.
	 */
	public void create(List<Integer> scores , QuestionDescription qDesc)
	{
		setBounds(100, 100, 450, 300);
		JPanel contentPane = new JPanel();
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
	
	/**
	 * Add team into team list
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
	 * Add team button into button list and program GUI
	 */
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
	
	/**
	 * Close the frame
	 */
	public void close() {
		this.dispose();
	}

	
	

}
