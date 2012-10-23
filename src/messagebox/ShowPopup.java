package messagebox;

import javax.swing.JOptionPane;

/**
 * Create a pop-up according to input send to Constructor method
 * @author KSLV
 * @version Oct 1, 2012
 */
public class ShowPopup {
	/*
	 * 0 = x
	 * 1 = i
	 * 2 = !
	 * 3 = ?
	 * 
	 * */
	
	/**
	 * Constructor for this class
	 * @param message A message to be show
	 * @param title Title of the pop-up
	 * @param type Type of pop-up windows
	 */
	public ShowPopup(String message,String title,int type)
	{
		 JOptionPane.showMessageDialog(null,message, title, type);
	}
}
