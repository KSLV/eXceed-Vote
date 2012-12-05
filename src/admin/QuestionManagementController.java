package admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class QuestionManagementController {
	private JButton addButton;
	private JTextField inputBox;
	private QuestionManagementModel model;

	public QuestionManagementController(QuestionManagement view , QuestionManagementModel model) {
		this.model = model;
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
			if(model.checkDuplicateQuestion(inputBox.getText()))
			{
				model.addQestion(inputBox.getText());
				new messagebox.ShowPopup("Adding question [" + inputBox.getText() + "] completed.", "Complete!!", 2);
			}else
			{
				new messagebox.ShowPopup("Duplicate Question Existed.", "Empty input", 2);
			}
		}else
		{
			new messagebox.ShowPopup("Please enter something", "Empty input", 2);
		}
		inputBox.setText(null);
	}
}
