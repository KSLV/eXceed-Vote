package admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class TeamManagementController {
	private TeamManagement view;
	private JButton addButton;
	private JTextField inputBox;

	public TeamManagementController(TeamManagement view) {
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
			System.out.println("Team Name : "+inputBox.getText());
		}
		inputBox.setText(null);
	}
}
