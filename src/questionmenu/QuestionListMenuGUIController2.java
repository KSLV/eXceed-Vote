package questionmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;

import login.LoginGUI2;
import login.VerificationProcess;

public class QuestionListMenuGUIController2 {
	private QuestionListMenuGUI2 view;
	private ArrayList<JButton> buttonList;
	private JButton logoutButton;

	public QuestionListMenuGUIController2(QuestionListMenuGUI2 view) {
		this.view = view;
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
					System.out.println(num);
				}
			});
		}
		
		logoutButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new login.LoginGUIController2(new VerificationProcess(),new LoginGUI2());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				view.close();
			}
		});
	}
	
}
