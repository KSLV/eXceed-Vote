package admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;

import database.QuestionDescription;

public class ScoreViewQuestionListController {
	private List<JButton> buttonList;
	private ScoreViewQuestionListModel model;

	public ScoreViewQuestionListController(ScoreViewQuestionList view , ScoreViewQuestionListModel model ) {
		this.model = model;
		view.setQuestionList();
		view.create();
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
						new ScoreViewTeamListController(new ScoreViewTeamList() , new ScoreViewTeamListModel() , qDesc);
					}
					else
					{
						new messagebox.ShowPopup("Can't find QuestionID","Unexpected Error",0);
					}
				}
			});
		}
		
	
	}
	
}
