package admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class QuestionManagementController {
	private JButton addButton;
	private JTextField inputBox;
	private QuestionManagementModel model;
	private JTextField inputBallot;

	public QuestionManagementController(QuestionManagement view , QuestionManagementModel model) {
		this.model = model;
		addButton = view.getAddButton();
		inputBox = view.getInputBox();
		inputBallot = view.getInputBallot();
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
		if(inputIsNULL()){
			if(model.checkDuplicateQuestion(inputBox.getText()))
			{
				model.addQestion(inputBox.getText(),Integer.parseInt(inputBallot.getText()) );
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
		inputBallot.setText(null);
	}
	
	private boolean inputIsNULL()
	{
		if(inputBox.getText().length()==0)return false;
		if(inputBallot.getText().length()==0)return false;
		try {
			Integer.parseInt(inputBallot.getText());
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
