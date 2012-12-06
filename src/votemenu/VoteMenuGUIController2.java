package votemenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;

public class VoteMenuGUIController2 {
	private VoteMenuGUI2 view;
	private JButton logoutButton;
	private List<JButton> buttonList;

	public VoteMenuGUIController2(VoteMenuGUI2 view) {
		this.view = view;
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
			JButton button = buttonList.get(i);
			button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					//action each button
				}
			});
		}
		
		logoutButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//back to question list
			}
		});
	}
}
