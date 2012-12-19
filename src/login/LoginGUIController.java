package login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JTextField;

import questionmenu.QuestionListMenuGUI;
import questionmenu.QuestionListMenuGUIController;
import questionmenu.QuestionListMenuModel;

import database.User;

/**
 * Controller for login page
 * @author Lattasit 5410545061
 * @author Khanet 5410545974( ActionListeners )
 */
public class LoginGUIController {
	
	private VerificationProcess model;
	private LoginGUI view;
	
	private JTextField inputUser;
	private JTextField inputPass;
	private JButton loginButton;
	private JButton exitButton;

	/**
	 * Initialize view and model , retrieve components from view , and setup actionListener 
	 * @param model
	 * @param view
	 */
	public LoginGUIController(VerificationProcess model , LoginGUI view) {
		this.model = model;
		this.view = view;
		inputUser = view.getInputUser();
		inputPass = view.getInputPass();
		loginButton = view.getLoginButton();
		exitButton = view.getExitButton();
		setAction();
	}

	/**
	 * Setup actionListener on login and exit button
	 */
	private void setAction()
	{
		loginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String username = inputUser.getText();
				String password = inputPass.getText();
				User user = null;
				if(username.length()!=0 && password.length()!=0)
				{		
					try {
						user = model.verifyLogin(username, password);
					} catch (IOException e) {
						e.printStackTrace();
					}
					if(user != null)
					{
						goToQuestionListMenu(user);
					}else
					{
						new messagebox.ShowPopup("Username or Password incorrect.","Error!!!!!",0);
						view.close();
					}
				}
				inputUser.setText(null);
				inputPass.setText(null);

			}
		});


		exitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				view.close();
			}
		});
		

	}
	
	/**
	 * process to next page and close this page
	 * @param user contain User identity
	 */
	private void goToQuestionListMenu(User user)
	{
		new QuestionListMenuGUIController(new QuestionListMenuGUI(), new QuestionListMenuModel(), user);
		view.close();
	}
}
