package admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class TeamManagementController {
	private JButton addButton;
	private JTextField inputBox;
	private TeamManagementModel model;

	public TeamManagementController(TeamManagement view , TeamManagementModel model) {
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
			if(model.checkDuplicateTeam(inputBox.getText()))
			{
				model.addTeam(inputBox.getText());
				new messagebox.ShowPopup("Adding team [" + inputBox.getText() + "] completed.", "Complete!!", 2);
			}else
			{
				new messagebox.ShowPopup("Duplicate Team Existed.", "Empty input", 2);
			}
		}else
		{
			new messagebox.ShowPopup("Please enter something", "Empty input", 2);
		}
		inputBox.setText(null);
	}
}
