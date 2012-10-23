package votemenu;

import java.io.IOException;

/**
 * Model for VoteMenu
 * @author KSLV
 * @version Oct 1, 2012
 */
public class VoteMenuGUI extends VoteMenu{

	/**
	 * Initialize VoteMenu class
	 * @param userID Indicate which userID has logged in
	 * @param questionNumber Indicate which question number this user is voting 
	 * @throws IOException
	 */
	public VoteMenuGUI(int userID, int questionNumber) throws IOException {
		super(userID, questionNumber);
	}

}
