package admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

/**
 * Add or edit User to the database
 * @author Lattasit 5410545061
 * @author Khanet 	5410545974	( ActionListeners )
 */
public class UserManagementController {

	/**Save add button*/
	private JButton addButton;
	/**Save textField of username*/
	private JTextField inputUser;
	/**Save textField if password*/
	private JTextField inputPass;
	/**Save textField if first name*/
	private JTextField inputFirstName;
	/**Save textField if sur name*/
	private JTextField inputSureName;
	/**Save model of UserManagement*/
	private UserMannagementModel model;

	/**
	 * Set important variable
	 * @param view from class UserManagement
	 * @param model from class UsermanagementModel
	 */
	public UserManagementController(UserManagement view ,UserMannagementModel model) {
		this.model = model;
		addButton = view.getAddButton();
		inputUser = view.getInputUser();
		inputPass = view.getInputPass();
		inputFirstName = view.getInputFirstName();
		inputSureName = view.getInputSureName();
		setAction();

	}

	/**
	 * Set listener for each button
	 */
	private void setAction()
	{
		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				clickAddButton();
			}
		});
	}

	/**
	 * Work when user click add button
	 */
	private void clickAddButton()
	{
		if(inputIsNULL()){
			if(!model.checkDuplicateUser(inputUser.getText()))
			{
				model.addUser(inputUser.getText(), inputPass.getText(),inputFirstName.getText(),inputSureName.getText());
				new messagebox.ShowPopup("Adding user [" + inputUser.getText() + "] completed.", "Complete!!", 2);
			}
			else
			{
				//model.setNBallot(inputUser.getText(), "5");/**/
				new messagebox.ShowPopup("This user name is already registered.", "Duplicate Username", 2);
			}
		}else
		{
			new messagebox.ShowPopup("Invalid input.\n Please check you input", "Invalid Input", 2);
		}
		inputUser.setText(null);
		inputPass.setText(null);
		inputFirstName.setText(null);
		inputSureName.setText(null);
	}
	
	/**
	 * Check data of input
	 * @return true when input isn't empty
	 */
	public boolean inputIsNULL()
	{
		if(inputUser.getText().length()==0)return false;
		if(inputPass.getText().length()==0)return false;
		if(inputFirstName.getText().length()==0)return false;
		if(inputSureName.getText().length()==0)return false;
		return true;
	}
	
	/**
	 * Check data of input
	 * @return true when input is can convert to int
	 */
	public boolean isInteger( String input ) {
	    try {
	        Integer.parseInt( input );
	        return true;
	    }
	    catch( Exception e ) {
	        return false;
	    }
	}
}
