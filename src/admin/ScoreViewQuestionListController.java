package admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;

import database.QuestionDescription;

/**
 * Display List of question to be select for score viewing
 * @author Lattasit 5410545061
 * @author Khanet	5410545974	( ActionListeners )
 */
public class ScoreViewQuestionListController {
	/**Save list of button*/
	private List<JButton> buttonList;
	/**Save model of ScoreViewQuestion*/
	private ScoreViewQuestionListModel model;

	/**
	 * Set important variable
	 * @param view from class ScoreViewQuestionList
	 * @param model from class ScoreViewQuestionListModel
	 */
	public ScoreViewQuestionListController(ScoreViewQuestionList view , ScoreViewQuestionListModel model ) {
		this.model = model;
		view.setQuestionList();
		view.create();
		buttonList = view.getButtonList();
		addAction();
	}
	
	/**
	 * Set listener for each button
	 */
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
