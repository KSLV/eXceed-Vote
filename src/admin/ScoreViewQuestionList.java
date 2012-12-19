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

/**
 * View class of ScoreViewQuestionList application
 * @author Varunyu 5410546326	
 */
public class ScoreViewQuestionList extends JFrame {

	/**Center of BorderLayout*/
	private JPanel centerZone;
	/**East of BorderLayout*/
	private JPanel eastZone;
	/**Save list of button*/
	private List<JButton> buttonList;
	/**Save list of question name*/
	private List<String> question;


	/**
	 * Set important variable
	 */
	public ScoreViewQuestionList() {
		buttonList = new ArrayList<JButton>();
		question = new ArrayList<String>();
		setTitle("Score Viewer");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		pack();
	}
	
	/**
	 * Create the frame.
	 */
	public void create()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 226, 286);
		JPanel contentPane = new JPanel();
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
		pack();
	}
	
	/**
	 * Add question into question list
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
	 * Add question button into button list and program GUI
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
	 * return the list of button
	 * @return list of button
	 */
	public List<JButton> getButtonList()
	{
		return buttonList;
	}
	


	/**
	 * Close the frame
	 */
	public void close() {
		this.dispose();
	}
	

}
