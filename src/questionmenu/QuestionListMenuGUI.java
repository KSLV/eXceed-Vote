package questionmenu;

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
import database.User;
import exceed.dao.DaoFactory;
import java.awt.FlowLayout;

/**
 * view class of QuestionMenu
 * @author Khanet 5410545974	
 */
public class QuestionListMenuGUI extends JFrame {

	private JPanel contentPane;
	private JPanel centerZone;
	private JPanel eastZone;
	private List<JButton> buttonList;
	private List<String> question;
	private JButton logoutButton;
	private JPanel north_south_zone;
	private JPanel north_north_zone;
	private JLabel labelWelcome;


	/**
	 * Create Jframe and initialize lists.
	 */
	public QuestionListMenuGUI() {
		buttonList = new ArrayList<JButton>();
		question = new ArrayList<String>();
		setTitle("Question List");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		pack();
	}
	
	/**
	 * Initialize components
	 * @param user contain current User identity
	 */
	public void create(User user)
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(10, 20));
		
		JPanel northZone = new JPanel();
		northZone.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(northZone, BorderLayout.NORTH);
		northZone.setLayout(new BorderLayout(0, 0));
		
		north_south_zone = new JPanel();
		northZone.add(north_south_zone, BorderLayout.SOUTH);
		
		JLabel titleText = new JLabel("Question List");
		north_south_zone.add(titleText);
		titleText.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		north_north_zone = new JPanel();
		northZone.add(north_north_zone, BorderLayout.NORTH);
		north_north_zone.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		labelWelcome = new JLabel("Welcome!! " + user.getName() + " "+ user.getSurename() + ". Please select question to vote on.");
		north_north_zone.add(labelWelcome);
		
		JPanel southZone = new JPanel();
		southZone.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(southZone, BorderLayout.SOUTH);
		
		logoutButton = new JButton("Logout");
		southZone.add(logoutButton);
		
		centerZone = new JPanel();
		contentPane.add(centerZone, BorderLayout.CENTER);
		centerZone.setLayout(new GridLayout(0, 1, 0, 10));
		
		eastZone = new JPanel();
		contentPane.add(eastZone, BorderLayout.EAST);
		eastZone.setLayout(new GridLayout(0, 1, 0, 10));
		
		addList();
		//setMinimumSize(new Dimension(150,0));
		pack();
	}
	
	/**
	 * setup list of questionDescription
	 */
	public void setQuestionList()
	{
		List<QuestionDescription> questionList = DaoFactory.getInstance().getQuestionDao().findAll();
		
		for(QuestionDescription q : questionList)
		{
			question.add(q.getName());
		}
	}
	
	/**
	 * Add buttons to list equal to number of questionDescription List
	 */
	private void addList()
	{
		for(int i=0;i<question.size();i++)
		{
			JLabel lblTeam = new JLabel(question.get(i));
			centerZone.add(lblTeam);
			JButton button = new JButton("<<<");
			eastZone.add(button);
			buttonList.add(button);
		}
		
	}
	
	/**
	 * get List of QuestionDescription buttons
	 * @return list of QuestionDescription buttons
	 */
	public List<JButton> getButtonList()
	{
		return buttonList;
	}
	
	/**
	 * get Logout button
	 * @return Logout button
	 */
	public JButton getLogoutButton()
	{
		return logoutButton;
	}

	/**
	 * Dispose this page
	 */
	public void close() {
		this.dispose();
	}
	

}
