package login;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * Provide view class for Login windows
 * @author Khanet 5410545974
 */
public class LoginGUI extends JFrame {

	private JPanel contentPane;
	private JTextField inputUser;
	private JTextField inputPass;
	private JButton loginButton;
	private JButton exitButton;

	

	/**
	 * call components initialization and set the frame visible
	 */
	public LoginGUI() {
		initComponents();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	/**
	 * Initialize swing Components
	 */
	private void initComponents()
	{
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
	}
	
	/** dispose this page	 */
	public void close()
	{
		this.dispose();
	}
	
	/**
	 * get username textField
	 * @return username textField
	 */
	public JTextField getInputUser() {
		return inputUser;
	}

	/**
	 * get password textField
	 * @return password textField
	 */
	public JTextField getInputPass() {
		return inputPass;
	}

	/**
	 * get login button
	 * @return login button
	 */
	public JButton getLoginButton() {
		return loginButton;
	}
	
	/**
	 * get exit button
	 * @return exit button
	 */
	public JButton getExitButton() {
		return exitButton;
	}
	
}
