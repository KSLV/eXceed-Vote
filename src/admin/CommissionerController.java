package admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CommissionerController {

	/**Save question button*/
	private JButton questionButton;
	/**Save team button*/
	private JButton teamButton;
	/**Save user button*/
	private JButton userButton;
	/**Save score button*/
	private JButton scoreButton;

	/**
	 * Set important variable
	 * @param view from class Commissioner
	 */
	public CommissionerController(Commissioner view) {
		questionButton = view.getQuestionButton();
		teamButton = view.getTeamButton();
		userButton = view.getUserButton();
		scoreButton = view.getScoreButton();
		setAction();
	}

	/**
	 * Set listener for each button
	 */
	private void setAction() {
		questionButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new QuestionManagementController(new admin.QuestionManagement() , new admin.QuestionManagementModel());
			}
		});
		
		teamButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new TeamManagementController(new admin.TeamManagement() , new admin.TeamManagementModel());
			}
		});
		
		userButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new UserManagementController(new admin.UserManagement() , new admin.UserMannagementModel()) ;
			}
		});
		
		scoreButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ScoreViewQuestionListController(new admin.ScoreViewQuestionList() , new admin.ScoreViewQuestionListModel());
			}
		});
	}
	
}
