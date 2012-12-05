package admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class UserManagementController {

	private JButton addButton;
	private JTextField inputUser;
	private JTextField inputPass;
	private JTextField inputBallot;
	private UserMannagementModel model;

	public UserManagementController(UserManagement view ,UserMannagementModel model) {
		this.model = model;
		addButton = view.getAddButton();
		inputUser = view.getInputUser();
		inputPass = view.getInputPass();
		inputBallot = view.getInputBallot();
		setAction();

	}

	private void setAction()
	{
		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				clickAddButton();
			}
		});
	}

	private void clickAddButton()
	{
		if(inputUser.getText().length()!=0 && inputPass.getText().length()!=0 && inputBallot.getText().length()!=0 && isInteger(inputBallot.getText())){
			if(model.checkDuplicateUser(inputUser.getText()))
			{
				model.addUser(inputUser.getText(), inputPass.getText(), inputBallot.getText());
				new messagebox.ShowPopup("Adding user [" + inputUser.getText() + "] completed.", "Complete!!", 2);
			}
			else
			{
				new messagebox.ShowPopup("This user name is already registered.", "Duplicate Username", 2);
			}
		}else
		{
			new messagebox.ShowPopup("Invalid input.\n Please check you input", "Invalid Input", 2);
		}
		inputUser.setText(null);
		inputPass.setText(null);
		inputBallot.setText(null);
	}
	
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
