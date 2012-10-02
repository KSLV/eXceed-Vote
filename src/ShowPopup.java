import java.awt.Component;
import java.awt.Image;
import java.awt.TrayIcon.MessageType;

import javax.swing.JOptionPane;


public class ShowPopup {
	/*
	 * 0 = x
	 * 1 = i
	 * 2 = !
	 * 3 = ?
	 * 
	 * */
	public ShowPopup(String message,String title,int type)
	{
		 JOptionPane.showMessageDialog(null,message, title, type);
	}
}
