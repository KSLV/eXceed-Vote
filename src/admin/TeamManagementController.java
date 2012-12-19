package admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

/**
 * Add or edit team in the database
 * @author Lattasit 5410545061
 * @author Khanet 5410545974	
 */
public class TeamManagementController {
	/**Save add button*/
	private JButton addButton;
	/**Save textField of team name*/
	private JTextField inputBox;
	/**Save model of TeamManagement*/
	private TeamManagementModel model;

	/**
	 * Set important variable
	 * @param view from class TeamManagement
	 * @param model from class TeamManagementModel
	 */
	public TeamManagementController(TeamManagement view , TeamManagementModel model) {
		this.model = model;
		addButton = view.getAddButton();
		inputBox = view.getInputBox();
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
		if(inputBox.getText().length()!=0){
			if(!model.checkDuplicateTeam(inputBox.getText()))
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
