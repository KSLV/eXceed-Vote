package questionmenu;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.junit.Test;

/**
 * Test Unit of QuestionListMenuGUI
 * @author Lattasit 5410545061
 * @version Oct 2, 2012
 */
public class QuestionListMenuGUITest {

	/**
	 * Test if questionList is equal with the String the BufferedReader read in or not.
	 * @throws IOException 
	 */
	@Test (timeout = 1000)
	public void testQuestionRead() throws IOException {
		
		QuestionListMenuGUI qListGUI = new QuestionListMenuGUI(1);
		
		InputStream is = new FileInputStream("src//database//QuestionsList.txt");
		InputStreamReader in = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(in);
		ArrayList<String> testList = new ArrayList<String>();
		testList.add(br.readLine());
		
		assertEquals(qListGUI.getQuestionList().get(0) , testList.get(0));
		is.close();
		in.close();
		br.close();
	}
	

	/**
	 * Test if the QuestionListMenuGUI initialize correct userID or not.
	 * @throws IOException
	 */
	@Test (timeout = 1000)
	public void testUserIDCalling() throws IOException
	{
		QuestionListMenuGUI qListGUI = new QuestionListMenuGUI(1);
		assertEquals(1,qListGUI.getUserID());
		
		qListGUI = new QuestionListMenuGUI(2);
		assertEquals(2,qListGUI.getUserID());
	}

	/**
	 * Test if the QuestionListMenuGUI initialize correct userID or not.
	 * @throws IOException
	 */
	@Test (expected = FileNotFoundException.class)
	public void testInvalidFileLocation() throws IOException
	{
		QuestionListMenuGUI qListGUI = new QuestionListMenuGUI(1);
		assertEquals(1,qListGUI.getUserID());
		new FileInputStream("src//database//List.txt");
	}
	
	/**
	 * Test if the QuestionListMenuGUI initialize correct userID or not.
	 * @throws IOException
	 */
	@Test (timeout = 500)
	public void testvalidFileLocation() throws IOException
	{
		QuestionListMenuGUI qListGUI = new QuestionListMenuGUI(1);
		assertEquals(1,qListGUI.getUserID());
		InputStream is = new FileInputStream("src//database//QuestionsList.txt");
		is.close();
		
	}
}
