package admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class QuestionManagementController {
	private QuestionManagement view;
	private JButton addButton;
	private JTextField inputBox;

	public QuestionManagementController(QuestionManagement view) {
		this.view = view;
		addButton = view.getAddButton();
		inputBox = view.getInputBox();
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
		if(inputBox.getText().length()!=0){
			System.out.println("Question Name : "+inputBox.getText());
		}
		inputBox.setText(null);
	}
}
