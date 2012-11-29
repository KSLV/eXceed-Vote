package admin;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class QuestionManagement extends JFrame{
	
	private JLabel titleText;
	private JTextArea input;
	private JButton addButton;
	public QuestionManagement() {
		super("Question Management");
		BorderLayout borderLayout = new BorderLayout(20,20);
		borderLayout.setHgap(100);
		setLayout(borderLayout);
		
//		NORTH ZONE
		titleText = new JLabel("Question Management");
		titleText.setFont(new Font(getFont()+"", 0, 20));
		titleText.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		add(titleText,BorderLayout.NORTH);
		
//		CENTER ZONE
		JPanel center = new JPanel();
		GridLayout gridLayout = new GridLayout(2,1);

		center.setLayout(gridLayout);
		titleText = new JLabel("Question Name");
		center.add(titleText,BorderLayout.CENTER);
		input = new JTextArea();
		center.add(input,BorderLayout.CENTER);
		add(center);
		
//		SOUTH ZONE
		addButton = new JButton("ADD");
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				addClick();
			}
		});
		add(addButton,BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	public String getInput() {
		return input.getText();
	}
	
	private void addClick()
	{
		if(getInput()==null)return;
		System.out.println(getInput());
		input.setText(null);
	}

}
