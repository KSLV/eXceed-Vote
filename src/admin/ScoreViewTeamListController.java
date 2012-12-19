package admin;

import java.util.List;

import database.QuestionDescription;

/**
 * Display score of each team on specific question
 * @author Lattasit 5410545061
 * @author Khanet 	5410545974	
 */
public class ScoreViewTeamListController {
	/**Save list of score*/
	private List<Integer> scores;

	public ScoreViewTeamListController(ScoreViewTeamList view , ScoreViewTeamListModel model , QuestionDescription question) {
		view.setTeamList();
		scores = model.getScoreList(question);
		view.create(scores , question);
		
	}
	
}
