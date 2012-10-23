package votemenu;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;


public class VoteProcessTest {

	
	/**Test for userID 1 vote for Team 1 in question 1 
	 * @throws IOException */
	@Test 
	public void testVoteOneTime() throws IOException {	
		 
		VoteMenu vm =  new VoteMenu(1, 1);	
		int TmpS1,TmpS2;
		TmpS1 = vm.getScore(1);
		TmpS2 = vm.getScore(1);		
		assertEquals(0,TmpS2 - TmpS1);		
		if(vm.getNBallot() > 0) 
		{
			vm.doVote(1);
			TmpS2 = vm.getScore(1);
			assertEquals(1,TmpS2 - TmpS1);	
		}else assertEquals(0,TmpS2 - TmpS1);
				
	}
	
	/**Test for uerID 2 vote in Question 2 until out of Ballot
	 * @throws IOException
	 */	
	@Test
	public void testVoteUntilOutOfBallot() throws IOException{
		VoteMenu vm =  new VoteMenu(2, 2);	
		int score = vm.getScore((1));
		assertEquals(score, vm.getScore(1));
		int count = 0;
		while(vm.getNBallot() > 0)
		{
			vm.doVote(1);
			count++;
		}
		assertEquals(score+count, vm.getScore(1));
		vm.doVote(1);
		assertEquals(score+count, vm.getScore(1));
	}

}
