package admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class UserManagementController {

	private UserManagement view;
	private JButton addButton;
	private JTextField inputUser;
	private JTextField inputPass;
	private JTextField inputBallot;

	public UserManagementController(UserManagement view) {
		this.view = view;
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
		if(inputUser.getText().length()!=0 && inputPass.getText().length()!=0 && inputBallot.getText().length()!=0){
			System.out.println("UserName : "+inputUser.getText());
			System.out.println("Password : "+inputPass.getText());
			System.out.println("Ballot Number : "+inputBallot.getText());
		}
		inputUser.setText(null);
		inputPass.setText(null);
		inputBallot.setText(null);
	}
}
