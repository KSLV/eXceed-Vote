package questionmenu;

import java.io.IOException;

import database.User;

/**
 * Initialize QuestionMenu and QuestionListMenuGUIController class.
 * @author Lattasit 5410545061
 * @version Oct 3, 2012
 */
public class QuestionListMenuGUI extends QuestionMenu{

	
	public QuestionListMenuGUI(User user) throws IOException {
		super(user);
		new QuestionListMenuGUIController(getUser() , getQuestionDesc(), getNBallotList());
		
	}


	
}
