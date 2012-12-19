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

public class TeamManagement extends JFrame {

	/**Get team name from user*/
	private JTextField inputBox;
	/**Submit input data*/
	private JButton addButton;

	

	/**
	 * Create the frame.
	 */
	public TeamManagement() {
		setTitle("Team Management");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 354, 193);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 10));
		setContentPane(contentPane);
		
		JLabel titleText = new JLabel("Team Management");
		titleText.setFont(new Font("Tahoma", Font.PLAIN, 23));
		titleText.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(titleText, BorderLayout.NORTH);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(null);
		
		JLabel inputLabel = new JLabel("Team Name");
		inputLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		inputLabel.setBounds(10, 11, 207, 14);
		centerPanel.add(inputLabel);
		
		inputBox = new JTextField();
		inputBox.setBounds(34, 36, 272, 28);
		centerPanel.add(inputBox);
		inputBox.setColumns(10);
		
		addButton = new JButton("ADD");
		addButton.setBounds(140, 77, 77, 23);
		centerPanel.add(addButton);
		
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
	 * return the input team name
	 * @return textField of team name
	 */
	public JTextField getInputBox()
	{
		return inputBox;
	}
}
