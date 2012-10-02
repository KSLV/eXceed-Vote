import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;


public class QuestionListMenuGUIController extends JFrame{


	private JPanel title;
	private ArrayList<String> questionList = new ArrayList<String>();
	private ArrayList<String> nBallotList = new ArrayList<String>();
	private int userID;

	public QuestionListMenuGUIController(int idUser , ArrayList<String> questionList , ArrayList<String> nBallotList)
	{
		super("QuestionListMenu");
		this.userID = idUser;
		this.questionList = questionList;
		this.nBallotList = nBallotList;
		//setLayout(new GridLayout(3, 2));
		setLayout(new BoxLayout(this.getContentPane(), 1));
		//JPanel head = new JPanel(new GridLayout(1,2));
		JPanel head = new JPanel(new BorderLayout());
		JLabel headWord = new JLabel("ISSUE LIST");
		headWord.setFont(new Font(headWord.getFont() + "", 0, 25));
		head.add(headWord,BorderLayout.WEST);
		//head.add(headWord);
		add(head);
		
		title = new JPanel(new GridLayout(questionList.size()+1, 2));
		JLabel name = new JLabel("Name");
		JLabel ballot = new JLabel("Ballot");
		name.setFont(new Font(name.getFont() + "", 0, 20));
		ballot.setFont(new Font(ballot.getFont() + "", 0, 20));
		name.setHorizontalAlignment(SwingConstants.CENTER);
		ballot.setHorizontalAlignment(SwingConstants.CENTER);
		
		title.add(name);
		title.add(ballot);
		add(title);
		
		addQuestion();
		
		JPanel lastLine = new JPanel(new BorderLayout(0,30));
		JButton signOut = new JButton("SignOut");
		lastLine.add(signOut,BorderLayout.SOUTH);
		add(lastLine);
		
		ActionListener signOutPush = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				signOut();
				
			}
		};
		
		signOut.addActionListener(signOutPush);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	private void close()
	{
		dispose();
	}
	
	private void signOut()
	{
		close();
		new LoginGUIController();
	}
		
	
	private void addQuestion()
	{
		for(int i=0;i<questionList.size();i++)
		{
			//System.out.println(questionList.get(i));
			JButton question = new JButton(questionList.get(i));
			JLabel ballot = new JLabel(nBallotList.get(i));
			ballot.setHorizontalAlignment(SwingConstants.CENTER);
			question.setHorizontalAlignment(SwingConstants.LEFT);
			ActionListener push = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					for(int i=0;i<questionList.size();i++)
					{
						if(e.getActionCommand().equals(questionList.get(i)))
						{
							close();
							selectQuestion(i+1 , e.getActionCommand());
						}
					}
				}
			};
			question.addActionListener(push);
			title.add(question);
			title.add(ballot);
		}
	}
	
	public void selectQuestion(int questionNumber , String questionName)
	{
		new VoteMenuGUIController(userID, questionNumber,questionName,nBallotList.get(questionNumber - 1));
	}
}
