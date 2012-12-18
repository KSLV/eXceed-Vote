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

public class VoteMenuGUIController {
	private VoteMenuGUI view;
	private JButton backButton;
	private List<JButton> buttonList;
	private User user;
	private QuestionDescription question;
	private VoteMenuModel model;
	private List<JButton> desList;

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
		desList = view.getDesList();
		setAction();
	}
	
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
					if(model.isTextExist(num))
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
		
		
		//Add ActionListener for Description Button
		for(int i=0;i<desList.size();i++)
		{
			final int num = i+1;
			JButton button = desList.get(i);
			button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					System.out.println("Description of team : "+num);
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
