package votemenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;

import database.QuestionDescription;
import database.User;

import questionmenu.QuestionListMenuGUI;
import questionmenu.QuestionListMenuGUIController;
import questionmenu.QuestionListMenuModel;

/**
 * Controller class of VoteMenu
 * @author Lattasit 5410545061
 * @author Khanet 	5410545974	( ActionListeners )
 */
public class VoteMenuGUIController {
	
	private VoteMenuGUI view;
	private JButton backButton;
	private List<JButton> buttonList;
	private User user;
	private QuestionDescription question;
	private VoteMenuModel model;

	/**
	 * Receive View, Model, User,and QuestionDescription , call view to update the TeamDescription List, update number of ballots , initialize buttons and setup ActionListener
	 * @param view
	 * @param model
	 * @param user Current User identity
	 * @param question Currently selected question
	 */
	public VoteMenuGUIController(VoteMenuGUI view , VoteMenuModel model , User user , QuestionDescription question) {
		this.view = view;
		this.model = model;
		this.user = user;
		this.question = question;
		view.setTeamList();
		view.setNBallot(model.getUserBallot(user , question));
		view.create(question);
		backButton = view.getbackButton();
		buttonList = view.getButtonList();
		setAction();
	}
	
	/**
	 * Setup ActionListener of every button in view
	 */
	private void setAction()
	{
		//Add ActionListener for Vote Button
		for(int i=0;i<buttonList.size();i++)
		{
			final int num = i+1;
			JButton button = buttonList.get(i);
			button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(model.isTeamExist(num))
					{
						if(model.vote(user, question, num))
						{
							new messagebox.ShowPopup("Vote Completed","Completed",1);
							view.setBallotShow(model.getUserBallot(user, question));
						}else new messagebox.ShowPopup("Inefficient Ballot","Error",0);
					}else new messagebox.ShowPopup("Can't find team","Unexpected Error",0);
				}
			});
		}
		
		//Add ActionListener for Back Button
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new QuestionListMenuGUIController(new QuestionListMenuGUI(), new QuestionListMenuModel(), user);
				view.close();
			}
		});
	}
}
