import java.awt.Font;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class VoteMenuGUIController extends JFrame{

	VoteMenu voteMenu;
	ArrayList<String> teamList;
	public VoteMenuGUIController(int idUser,int questionNumber,String nameQuestion)
	{
		super("TeamList");
		
		try {
			voteMenu = new VoteMenu(idUser, questionNumber);
			teamList = voteMenu.getTeamList();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		setLayout(new BoxLayout(this.getContentPane(), 1));
		JPanel head = new JPanel(new GridLayout(1,1));
		JLabel headWord = new JLabel(nameQuestion);
		headWord.setFont(new Font(headWord.getFont() + "", 0, 25));
		head.add(headWord);
		add(head);
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
}
