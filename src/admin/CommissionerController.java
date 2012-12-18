package admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CommissionerController {

	private JButton questionButton;
	private JButton teamButton;
	private JButton userButton;
	private JButton scoreButton;

	public CommissionerController(Commissioner view) {
		questionButton = view.getQuestionButton();
		teamButton = view.getTeamButton();
		userButton = view.getUserButton();
		scoreButton = view.getScoreButton();
		setAction();
	}

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
