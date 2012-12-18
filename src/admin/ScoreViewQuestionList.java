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
import exceed.dao.DaoFactory;
import java.awt.FlowLayout;

public class ScoreViewQuestionList extends JFrame {

	private JPanel contentPane;
	private JPanel centerZone;
	private JPanel eastZone;
	private List<JButton> buttonList;
	//private ArrayList<QuestionDescription> question;
	private List<String> question;


	/**
	 * Create the frame.
	 */
	public ScoreViewQuestionList() {
		buttonList = new ArrayList<JButton>();
		question = new ArrayList<String>();
		setTitle("Score Viewer");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		pack();
	}
	
	public void create()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 226, 286);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(10, 20));
		
		JPanel northZone = new JPanel();
		northZone.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(northZone, BorderLayout.NORTH);
		northZone.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel titleText = new JLabel("Score Viewer. Please select question to inspect.");
		northZone.add(titleText);
		titleText.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
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
	
	public void setQuestionList()
	{
		List<QuestionDescription> questionList = DaoFactory.getInstance().getQuestionDao().findAll();
		
		for(QuestionDescription q : questionList)
		{
			question.add(q.getName());
		}
	}
	
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
	
	public List<JButton> getButtonList()
	{
		return buttonList;
	}
	


	public void close() {
		this.dispose();
	}
	

}
