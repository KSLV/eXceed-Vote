package login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JTextField;

import database.User;

public class LoginGUIController2 {
	private VerificationProcess model;
	private LoginGUI2 view;
	private JTextField inputUser;
	private JTextField inputPass;
	private JButton loginButton;
	private JButton exitButton;

	public LoginGUIController2(VerificationProcess model , LoginGUI2 view) {
		this.model = model;
		this.view = view;
		inputUser = view.getInputUser();
		inputPass = view.getInputPass();
		loginButton = view.getLoginButton();
		exitButton = view.getExitButton();
		setAction();
	}

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
					System.out.println("Username : "+username);
					System.out.println("Password : "+password);
					
					try {
						user = model.verifyLogin(username, password);
					} catch (IOException e) {
						e.printStackTrace();
					}
					if(user != null)
					{
						System.out.println("Login !!");
					}else
					{
						new messagebox.ShowPopup("Username or Password incorrect.","Error!!!!!",0);
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
}
