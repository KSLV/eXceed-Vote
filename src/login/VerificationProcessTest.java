package login;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import database.User;


public class VerificationProcessTest {

	private LoginGUI lg;
	
	@Test
	public void loginTestFinish() {
		try {
			lg = new LoginGUI();
		} catch (IOException e) {
			e.printStackTrace();
		}
		User id=null;
		try {
			id = lg.verifyLogin("ARLeader", "ARLeader");
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertEquals(1,id);
	}
	
	@Test
	public void loginFail() {
		try {
			lg = new LoginGUI();
		} catch (IOException e) {
			e.printStackTrace();
		}
		User id=null;
		try {
			id = lg.verifyLogin("login", "1234");
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertEquals(0,id);
	}
	
	@Test
	public void userNameTrue()
	{
		try {
			lg = new LoginGUI();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			lg.verifyLogin("ARLeader", "ARLeader");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		assertEquals("ARLeader", lg.getTmpUserName());
		assertEquals("ARLeader", lg.getTmpPassword());
	}
	
	

}
