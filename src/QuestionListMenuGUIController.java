import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class QuestionListMenuGUIController extends JFrame{


	private JPanel title;

	public QuestionListMenuGUIController(int userID)
	{
		super("QuestionListMenu");
		//setLayout(new GridLayout(3, 2));
		setLayout(new BoxLayout(this.getContentPane(), 1));
		JPanel head = new JPanel(new GridLayout(1,1));
		JLabel headWord = new JLabel("ISSUE LIST");
		headWord.setFont(new Font(headWord.getFont() + "", 0, 25));
		head.add(headWord);
		add(head);
		
		title = new JPanel(new GridLayout(5, 2));
		JLabel name = new JLabel("Name");
		JLabel ballot = new JLabel("Ballot");
		name.setFont(new Font(name.getFont() + "", 0, 20));
		ballot.setFont(new Font(ballot.getFont() + "", 0, 20));
		name.setHorizontalAlignment(SwingConstants.CENTER);
		ballot.setHorizontalAlignment(SwingConstants.CENTER);
		
		title.add(name);
		title.add(ballot);
		add(title);
		
		addQuestion(userID);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	public void addQuestion(int userID)
	{
		ArrayList<String> questionList = new ArrayList<String>();
		ArrayList<String> nBallotList = new ArrayList<String>();
		try {
			QuestionListMenuGUI a = new QuestionListMenuGUI(userID);
			questionList = a.getQuestionList();
			nBallotList = a.getNBallotList();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(int i=0;i<questionList.size();i++)
		{
			System.out.println(questionList.get(i));
			JButton question = new JButton(questionList.get(i));
			JLabel ballot = new JLabel(nBallotList.get(i));
			ballot.setHorizontalAlignment(SwingConstants.CENTER);
			title.add(question);
			title.add(ballot);
		}
	}
}
