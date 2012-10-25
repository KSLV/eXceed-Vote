package votemenu;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


/**
 * Initialize GUI and handle user inputs
 * @author KSLV
 * @version Oct 1, 2012
 */
public class VoteMenuGUIController extends JFrame{

	private JPanel title;
	private int userID; //Indicate which user is using this class
	private VoteMenuGUI voteMenuGUI;
	private ArrayList<String> teamList; //List of name for each team
	
	/**
	 * Constructor for this class
	 * @param idUser current userID
	 * @param questionNumber Indicate which question number this user is voting on
	 * @param nameQuestion Contain the question description as String
	 * @param nBallotList List of number of ballots this user has
	 */
	public VoteMenuGUIController(int idUser,int questionNumber,String nameQuestion, String nBallotList)
	{
		super("TeamList");
		this.userID = idUser;
		
		try {
			voteMenuGUI = new VoteMenuGUI(idUser, questionNumber);
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	    teamList = voteMenuGUI.getTeamList();
		
		
		
		setLayout(new BoxLayout(this.getContentPane(), 1));
		JPanel head = new JPanel(new GridLayout(1,1));
		JLabel headWord = new JLabel(nameQuestion);
		headWord.setFont(new Font(headWord.getFont() + "", 0, 25));
		head.add(headWord);
		add(head);
		
		title = new JPanel(new GridLayout(teamList.size()+1, 1));
		JLabel name = new JLabel("Click on a team you like to vote on");
		name.setFont(new Font(name.getFont() + "", 0, 17));
		
		title.add(name);
		add(title);
		
		addTeam();
		
		JPanel showLast = new JPanel(new BorderLayout(0, 20));
		JPanel lastLine = new JPanel(new GridLayout(1,2));
		JLabel nballot = new JLabel("Ballot : "+ nBallotList);
		JButton cancel = new JButton("Cancel");
		showLast.add(lastLine,BorderLayout.SOUTH);
		nballot.setHorizontalAlignment(SwingConstants.CENTER);
		lastLine.add(nballot);
		lastLine.add(cancel);
		add(showLast);
		
		ActionListener cancelPush = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				close();
				try {
					new questionmenu.QuestionListMenuGUI(userID);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		};
		
		cancel.addActionListener(cancelPush);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	/**
	 * Create button with each team name as it's Label
	 */
	private void addTeam()
	{
		for(int i=0;i<teamList.size();i++)
		{
			//System.out.println(teamList.get(i));
			JButton question = new JButton(teamList.get(i));
			question.setHorizontalAlignment(SwingConstants.LEFT);
			ActionListener push = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					//System.out.println(e.getActionCommand());
					for(int i=0;i<teamList.size();i++)
					{
						if(e.getActionCommand().equals(teamList.get(i)))
						{
							//System.out.println(i+1);
							clickVote(i+1);
						}
					}
					
				}
			};
			question.addActionListener(push);
			title.add(question);
		}
	}
	
	/**
	 * Free memory and close this JFrame
	 */
	private void close()
	{
		this.dispose();
	}
	
	/**
	 * Handle user action when click on team name
	 * @param team
	 */
	private void clickVote(int team)
	{
		close();
		try {
			if(!voteMenuGUI.doVote(team))
				new messagebox.ShowPopup("Insufficient ballot", "Error!!!!!!!", 2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			new questionmenu.QuestionListMenuGUI(userID);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
