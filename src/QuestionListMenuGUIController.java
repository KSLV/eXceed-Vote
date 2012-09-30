import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class QuestionListMenuGUIController extends JFrame{


	public QuestionListMenuGUIController()
	{
		super("QuestionListMenu");
		setLayout(new GridLayout(2, 2));
		JPanel head = new JPanel(new GridLayout(1,1));
		JLabel headWord = new JLabel("ISSUE LIST");
		headWord.setFont(new Font(headWord.getFont() + "", 0, 25));
		head.add(headWord);
		add(head);
		
		JPanel title = new JPanel(new GridLayout(1, 2));
		JLabel name = new JLabel("Name");
		JLabel ballot = new JLabel("Ballot");
		name.setFont(new Font(name.getFont() + "", 0, 20));
		ballot.setFont(new Font(ballot.getFont() + "", 0, 20));
		name.setHorizontalAlignment(SwingConstants.CENTER);
		ballot.setHorizontalAlignment(SwingConstants.CENTER);
		
		title.add(name);
		title.add(ballot);
		add(title);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
}
