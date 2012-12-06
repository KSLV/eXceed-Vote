package questionmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import votemenu.VoteMenuGUI2;
import votemenu.VoteMenuGUIController2;

import database.QuestionDescription;
import database.User;

import exceed.dao.DaoFactory;

import login.LoginGUI2;
import login.VerificationProcess;

public class QuestionListMenuGUIController2 {
	private QuestionListMenuGUI2 view;
	private List<JButton> buttonList;
	private JButton logoutButton;
	private QuestionListMenuModel model;
	private User user;

	public QuestionListMenuGUIController2(QuestionListMenuGUI2 view , QuestionListMenuModel model , User user ) {
		this.view = view;
		this.model = model;
		this.user = user;
		view.setQuestionList();
		view.create();
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
						new VoteMenuGUIController2(new VoteMenuGUI2());
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
					new login.LoginGUIController2(new VerificationProcess(),new LoginGUI2());
					view.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				view.close();
			}
		});
	}
	
}
