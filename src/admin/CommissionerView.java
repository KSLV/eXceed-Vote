package admin;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * View class of Commissioner program
 * @author team KSLV
 */
public class CommissionerView extends JFrame {

	/**Open the question management*/
	private JButton questionButton;
	/**Open the team management*/
	private JButton teamButton;
	/**Open the score viewer*/
	private JButton scoreButton;
	/**Open the user management*/
	private JButton userButton;

	/**
	 * Create the frame.
	 */
	public CommissionerView() {
		setTitle("Commissioner");
		
		JPanel northZone = new JPanel();
		getContentPane().add(northZone, BorderLayout.NORTH);
		
		JLabel labelTitle = new JLabel("Commissioner Management");
		labelTitle.setFont(new Font("Tahoma", Font.PLAIN, 23));
		northZone.add(labelTitle);
		
		JPanel centerZone = new JPanel();
		getContentPane().add(centerZone, BorderLayout.CENTER);
		centerZone.setLayout(null);
		
		questionButton = new JButton("Question Management");
		questionButton.setBounds(10, 11, 202, 38);
		centerZone.add(questionButton);
		
		teamButton = new JButton("Team Management");
		teamButton.setBounds(222, 11, 202, 38);
		centerZone.add(teamButton);
		
		scoreButton = new JButton("View Score");
		scoreButton.setBounds(222, 63, 202, 38);
		centerZone.add(scoreButton);
		
		userButton = new JButton("User Management");
		userButton.setBounds(10, 63, 202, 38);
		centerZone.add(userButton);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 300, 450, 200);
	}
	
	/**
	 * return the question button
	 * @return question button
	 */
	public JButton getQuestionButton()
	{
		return questionButton;
	}
	
	/**
	 * return the team button
	 * @return team button
	 */
	public JButton getTeamButton()
	{
		return teamButton;
	}
	
	/**
	 * return the user button
	 * @return user button
	 */
	public JButton getUserButton()
	{
		return userButton;
	}
	
	/**
	 * return the score button
	 * @return score button
	 */
	public JButton getScoreButton()
	{
		return scoreButton;
	}
}
