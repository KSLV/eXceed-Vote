import java.io.IOException;


public class QuestionListMenuGUI extends QuestionMenu{

	
	public QuestionListMenuGUI(int userID) throws IOException {
		super(userID);
		new QuestionListMenuGUIController(userID , getQuestionList(), getNBallotList());
		
	}


	
}
