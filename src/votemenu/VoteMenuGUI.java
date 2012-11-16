package votemenu;

import java.io.IOException;

import database.QuestionDescription;
import database.User;

/**
 * Model for VoteMenu
 * @author KSLV
 * @version Oct 1, 2012
 */
public class VoteMenuGUI extends VoteMenu{

	/**
	 * Initialize VoteMenu class
	 * @param user Indicate which userID has logged in
	 * @param q Indicate which question number this user is voting 
	 * @throws IOException
	 */
	public VoteMenuGUI(User user, QuestionDescription q) throws IOException {
		super(user, q);
	}

}
