package questionmenu;

import java.io.IOException;

import database.User;

/**
 * Initialize QuestionMenu and QuestionListMenuGUIController class.
 * @author Lattasit 5410545061
 * @version Oct 3, 2012
 */
public class QuestionListMenuGUIController extends QuestionMenu{

	
	public QuestionListMenuGUIController(User user) throws IOException {
		super(user);
		new QuestionListMenuGUI(getUser() , getQuestionDesc(), getNBallotList());
		
	}


	
}
