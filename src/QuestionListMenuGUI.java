import java.io.IOException;

/**
 * Initialize QuestionMenu and QuestionListMenuGUIController class.
 * @author Lattasit 5410545061
 * @version Oct 3, 2012
 */
public class QuestionListMenuGUI extends QuestionMenu{

	
	public QuestionListMenuGUI(int userID) throws IOException {
		super(userID);
		new QuestionListMenuGUIController(userID , getQuestionList(), getNBallotList());
		
	}


	
}
