package admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;

public class UserManagement extends JFrame {

	private JPanel contentPane;
	private JTextField inputUser;
	private JTextField inputPass;
	private JTextField inputBallot;
	private JButton addButton;

	

	/**
	 * Create the frame.
	 */
	public UserManagement() {
		setTitle("User Register");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 354, 301);
		contentPane = new JPanel();
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
		
		JLabel inputLabel = new JLabel("Username");
		inputLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		inputLabel.setBounds(10, 11, 207, 23);
		centerPanel.add(inputLabel);
		
		inputUser = new JTextField();
		inputUser.setBounds(34, 36, 272, 28);
		centerPanel.add(inputUser);
		inputUser.setColumns(10);
		
		inputPass = new JTextField();
		inputPass.setColumns(10);
		inputPass.setBounds(34, 94, 272, 28);
		centerPanel.add(inputPass);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(10, 68, 207, 23);
		centerPanel.add(lblPassword);
		
		addButton = new JButton("ADD");
		addButton.setBounds(139, 188, 77, 23);
		centerPanel.add(addButton);
		
		JLabel lblNumberOfBallot = new JLabel("Number of ballot");
		lblNumberOfBallot.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNumberOfBallot.setBounds(10, 125, 207, 23);
		centerPanel.add(lblNumberOfBallot);
		
		inputBallot = new JTextField();
		inputBallot.setColumns(10);
		inputBallot.setBounds(34, 149, 272, 28);
		centerPanel.add(inputBallot);
		
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public JButton getAddButton()
	{
		return addButton;
	}
	
	public JTextField getInputUser()
	{
		return inputUser;
	}
	
	public JTextField getInputPass()
	{
		return inputPass;
	}
	
	public JTextField getInputBallot()
	{
		return inputBallot;
	}
}
