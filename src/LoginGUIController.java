import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LoginGUIController extends JFrame{
	
	private String choose;
	private JTextField userField;
	private JPasswordField passField;
	public LoginGUIController()
	{
		super("Sign in");
		setLayout(new GridLayout(3, 2));
		addLabel("UserName");
		
		userField = new JTextField();
		userField.setFont(new Font(userField.getFont() + "", 0, 20));
		add(userField);
		
		addLabel("Password");
		passField = new JPasswordField();
		passField.setFont(new Font(passField.getFont() + "", 0, 20));
		passField.setPreferredSize(new Dimension(200, 10));
		add(passField);
		
		
		addButton("Submit");
		addButton("Cancel");
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	

	private void submit() throws IOException
	{
		LoginGUI loginGUI;
		String userName = userField.getText();
		String password = passField.getText();
		System.out.println(userName);
		System.out.println(password);
		int userID = 0;
		try {
			loginGUI = new LoginGUI(userName, password);
			userID = loginGUI.verifyLogin(userName, password);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(userID != 0)
		{
			close();
			new QuestionListMenuGUI(userID);
			dispose();
		}else
		{
			userField.setText(null);
			passField.setText(null);
			new ShowPopup("Username or Password incorrect.","Error!!!!!",0);
		}
	}
	
	private void close()
	{
		dispose();
	}
	
	/**
	 * Use to add label.
	 * 
	 * @param name
	 *            is word to show on label.
	 */
	public void addLabel(String name) {
		JLabel label = new JLabel(name);
		label.setFont(new Font(label.getFont() + "", 0, 20));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		add(label);
	}
	
	
	public void addButton(String name) {
		final JButton button = new JButton(name);
		ActionListener push = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				choose = e.getActionCommand();
				if (choose.equals("Submit")) {
					try {
						submit();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				if (choose.equals("Cancel")) {
					close();
				}
				
			}
		};

		button.setFont(new Font(button.getFont() + "", 0, 12));
		button.setForeground(Color.BLACK);
		button.addActionListener(push);
		button.setPreferredSize(new Dimension(10, 10));
		add(button);
	}
	
	
	/**
	 * Use to add button.
	 * 
	 * @param name
	 *            is word to show on button.
	 */
	/*
	public void addButton(String name) {
		JButton button = new JButton(name);
		button.setFont(new Font(button.getFont() + "", 0, 20));
		add(button);
	}*/
}
