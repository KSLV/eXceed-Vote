package admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class UserManagementController {

	private JButton addButton;
	private JTextField inputUser;
	private JTextField inputPass;
	private JTextField inputFirstName;
	private UserMannagementModel model;
	private JTextField inputSureName;

	public UserManagementController(UserManagement view ,UserMannagementModel model) {
		this.model = model;
		addButton = view.getAddButton();
		inputUser = view.getInputUser();
		inputPass = view.getInputPass();
		inputFirstName = view.getInputFirstName();
		inputSureName = view.getInputSureName();
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
		if(inpusIsNULL()){
			if(model.checkDuplicateUser(inputUser.getText()))
			{
				//model.addUser(inputUser.getText(), inputPass.getText(), inputFirstName.getText());
				new messagebox.ShowPopup("Adding user [" + inputUser.getText() + "] completed.", "Complete!!", 2);
			}
			else
			{
				//model.setNBallot(inputUser.getText(), inputFirstName.getText());
				new messagebox.ShowPopup("This user name is already registered.\nReplaced all ballot left with the input.", "Duplicate Username", 2);
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
	
	public boolean inpusIsNULL()
	{
		if(inputUser.getText().length()==0)return false;
		if(inputPass.getText().length()==0)return false;
		if(inputFirstName.getText().length()==0)return false;
		if(inputSureName.getText().length()==0)return false;
		return true;
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
