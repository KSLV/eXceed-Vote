package votemenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;

import database.QuestionDescription;
import database.User;

import questionmenu.QuestionListMenuGUI2;
import questionmenu.QuestionListMenuGUIController2;
import questionmenu.QuestionListMenuModel;

public class VoteMenuGUIController2 {
	private VoteMenuGUI2 view;
	private JButton logoutButton;
	private List<JButton> buttonList;
	private User user;
	private QuestionDescription question;
	private VoteMenuModel model;

	public VoteMenuGUIController2(VoteMenuGUI2 view , VoteMenuModel model , User user , QuestionDescription question) {
		this.view = view;
		this.model = model;
		this.user = user;
		this.question = question;
		view.setTeamList();
		view.create();
		logoutButton = view.getbackButton();
		buttonList = view.getButtonList();
		setAction();
	}
	
	private void setAction()
	{
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
							new messagebox.ShowPopup("Vote Completed","Completed",0);
						}else new messagebox.ShowPopup("Inefficient Ballot","Error",0);
					}else new messagebox.ShowPopup("Can't find team","Unexpected Error",0);
				}
			});
		}
		
		logoutButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new QuestionListMenuGUIController2(new QuestionListMenuGUI2(), new QuestionListMenuModel(), user);
				view.close();
			}
		});
	}
}
