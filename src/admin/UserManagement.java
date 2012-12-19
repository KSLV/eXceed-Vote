package admin;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;

/**
 * View class of UserManagement application
 * @author Khanet	5410545974	
 */
public class UserManagement extends JFrame {

	/**Get username from user*/
	private JTextField inputUser;
	/**Get password name from user*/
	private JTextField inputPass;
	/**Get First Name from user*/
	private JTextField inputFirstName;
	/**Get Sur Name from user*/
	private JTextField inputSureName;
	/**Submit input data*/
	private JButton addButton;

	

	/**
	 * Create the frame.
	 */
	public UserManagement() {
		setTitle("User Register");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 354, 350);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 10));
		setContentPane(contentPane);
		
		JLabel titleText = new JLabel("User Register");
		titleText.setFont(new Font("Tahoma", Font.PLAIN, 23));
		titleText.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(titleText, BorderLayout.NORTH);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(null);
		
		JLabel labelUser = new JLabel("Username");
		labelUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelUser.setBounds(10, 11, 207, 23);
		centerPanel.add(labelUser);
		
		inputUser = new JTextField();
		inputUser.setBounds(34, 36, 272, 28);
		centerPanel.add(inputUser);
		inputUser.setColumns(10);
		
		inputPass = new JTextField();
		inputPass.setColumns(10);
		inputPass.setBounds(34, 94, 272, 28);
		centerPanel.add(inputPass);
		
		JLabel labelPassword = new JLabel("Password");
		labelPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelPassword.setBounds(10, 68, 207, 23);
		centerPanel.add(labelPassword);
		
		addButton = new JButton("ADD");
		addButton.setBounds(138, 243, 77, 23);
		centerPanel.add(addButton);
		
		JLabel labelFirstName = new JLabel("First Name");
		labelFirstName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelFirstName.setBounds(10, 125, 207, 23);
		centerPanel.add(labelFirstName);
		
		inputFirstName = new JTextField();
		inputFirstName.setColumns(10);
		inputFirstName.setBounds(34, 149, 272, 28);
		centerPanel.add(inputFirstName);
		
		JLabel labelSureName = new JLabel("Sur Name");
		labelSureName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelSureName.setBounds(10, 180, 207, 23);
		centerPanel.add(labelSureName);
		
		inputSureName = new JTextField();
		inputSureName.setColumns(10);
		inputSureName.setBounds(34, 204, 272, 28);
		centerPanel.add(inputSureName);
		
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	
	/**
	 * return the add button
	 * @return add button
	 */
	public JButton getAddButton()
	{
		return addButton;
	}
	
	/**
	 * return the input username
	 * @return textField of username
	 */
	public JTextField getInputUser()
	{
		return inputUser;
	}
	
	/**
	 * return the input password
	 * @return textField of password
	 */
	public JTextField getInputPass()
	{
		return inputPass;
	}
	
	/**
	 * return the input first name
	 * @return textField of first name
	 */
	public JTextField getInputFirstName()
	{
		return inputFirstName;
	}
	
	/**
	 * return the input sur name
	 * @return textField of sur name
	 */
	public JTextField getInputSureName()
	{
		return inputSureName;
	}
}
