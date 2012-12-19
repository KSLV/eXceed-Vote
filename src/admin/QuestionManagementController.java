package admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class QuestionManagementController {
	/**Save add button*/
	private JButton addButton;
	/**Save textField of question name*/
	private JTextField inputBox;
	/**Save model of QuestionManagement*/
	private QuestionManagementModel model;
	/**Save textField of max ballot*/
	private JTextField inputBallot;

	/**
	 * Set important variable
	 * @param view from class QuestionManagement
	 * @param model from class QuestionManagementModel
	 */
	public QuestionManagementController(QuestionManagement view , QuestionManagementModel model) {
		this.model = model;
		addButton = view.getAddButton();
		inputBox = view.getInputBox();
		inputBallot = view.getInputBallot();
		setAction();
	}
	
	/**
	 * Set listener for each button
	 */
	private void setAction()
	{
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				clickAddButton();
			}
		});
		
	}
	
	/**
	 * Work when user click add button
	 */
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
	
	/**
	 * Check data of input
	 * @return true when input isn't empty
	 */
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
