package admin;

import java.util.List;

import database.QuestionDescription;

public class ScoreViewTeamListController {
	/**Save list of score*/
	private List<Integer> scores;

	public ScoreViewTeamListController(ScoreViewTeamList view , ScoreViewTeamListModel model , QuestionDescription question) {
		view.setTeamList();
		scores = model.getScoreList(question);
		view.create(scores , question);
		
	}
	
}
