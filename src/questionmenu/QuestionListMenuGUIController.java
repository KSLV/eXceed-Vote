package questionmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.JButton;

import votemenu.VoteMenuGUI;
import votemenu.VoteMenuGUIController;
import votemenu.VoteMenuModel;

import database.QuestionDescription;
import database.User;

import login.LoginGUI;
import login.VerificationProcess;

public class QuestionListMenuGUIController {
	private QuestionListMenuGUI view;
	private List<JButton> buttonList;
	private JButton logoutButton;
	private QuestionListMenuModel model;
	private User user;

	public QuestionListMenuGUIController(QuestionListMenuGUI view , QuestionListMenuModel model , User user ) {
		this.view = view;
		this.model = model;
		this.user = user;
		view.setQuestionList();
		view.create(user);
		logoutButton = view.getLogoutButton();
		buttonList = view.getButtonList();
		addAction();
	}
	
	private void addAction()
	{
		for(int i=0;i<buttonList.size();i++)
		{
			JButton temp = buttonList.get(i);
			final int num = i+1;
			temp.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(model.isQuestionExist(num))
					{
						QuestionDescription qDesc = model.getQuestionDesc(num);
						new VoteMenuGUIController(new VoteMenuGUI() , new VoteMenuModel() , user , qDesc);
						view.dispose();
					}
					else
					{
						new messagebox.ShowPopup("Can't find QuestionID","Unexpected Error",0);
					}
				}
			});
		}
		
		logoutButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new login.LoginGUIController(new VerificationProcess(),new LoginGUI());
					view.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				view.close();
			}
		});
	}
	
}
