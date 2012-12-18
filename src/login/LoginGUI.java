package login;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoginGUI extends JFrame {

	private JPanel contentPane;
	private JTextField inputUser;
	private JTextField inputPass;
	private JButton loginButton;
	private JButton exitButton;

	

	/**
	 * Create the frame.
	 */
	public LoginGUI() {
		setTitle("Exceed Vote - Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 196);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel userLabel = new JLabel("Username");
		userLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		userLabel.setBounds(10, 34, 128, 14);
		contentPane.add(userLabel);
		
		inputUser = new JTextField();
		inputUser.setBounds(111, 29, 161, 31);
		contentPane.add(inputUser);
		inputUser.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPassword.setBounds(10, 75, 128, 14);
		contentPane.add(lblPassword);
		
		inputPass = new JTextField();
		inputPass.setColumns(10);
		inputPass.setBounds(111, 71, 161, 28);
		contentPane.add(inputPass);
		
		loginButton = new JButton("Login");
		loginButton.setBounds(34, 124, 89, 23);
		contentPane.add(loginButton);
		
		exitButton = new JButton("Exit");
		exitButton.setBounds(166, 124, 89, 23);
		contentPane.add(exitButton);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void close()
	{
		this.dispose();
	}
	
	public JTextField getInputUser() {
		return inputUser;
	}

	public JTextField getInputPass() {
		return inputPass;
	}

	public JButton getLoginButton() {
		return loginButton;
	}
	
	public JButton getExitButton() {
		return exitButton;
	}
	
}
