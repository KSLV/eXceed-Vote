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
		JPanel head = new JPanel(new GridLayout(1,1));
		JLabel headWord = new JLabel("ISSUE LIST");
		headWord.setFont(new Font(headWord.getFont() + "", 0, 25));
		head.add(headWord);
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
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	public void close()
	{
		dispose();
	}
		
	
	public void addQuestion()
	{
		for(int i=0;i<questionList.size();i++)
		{
			System.out.println(questionList.get(i));
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
							try {
								close();
								new VoteMenu(userID, i+1);
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
					}
				}
			};
			question.addActionListener(push);
			title.add(question);
			title.add(ballot);
		}
	}
}
