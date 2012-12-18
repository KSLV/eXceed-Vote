package admin;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Commissioner extends JFrame {

	private JButton questionButton;
	private JButton teamButton;
	private JButton scoreButton;
	private JButton userButton;

	public Commissioner() {
		BorderLayout borderLayout = (BorderLayout) getContentPane().getLayout();
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
	
	public JButton getQuestionButton()
	{
		return questionButton;
	}
	
	public JButton getTeamButton()
	{
		return teamButton;
	}
	
	public JButton getUserButton()
	{
		return userButton;
	}
	
	public JButton getScoreButton()
	{
		return scoreButton;
	}
}
