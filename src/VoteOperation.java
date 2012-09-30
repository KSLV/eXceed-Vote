
public class VoteOperation {

	private String Q1;
	private String[] teamList = {"A","B","C","D","E"}; 
	private int[] choicesNum;
	
	public VoteOperation()
	{
		choicesNum = new int[5];
	}
	

	/*public void setTeam(int input)
	{
		for(int i = 0 ; i < input ; i++)
		{
			teamList[i] = i+1+"";
		}
	}*/
	
	public boolean doVote(int inputVote)
	{
		try{
		choicesNum[inputVote-1]++;
		return true;
		}
		catch(IndexOutOfBoundsException e)
		{
			System.out.printf("TEAM INPUT ERROR");
			return false;
		}
	}
	
	public void showVote()
	{
		System.out.println("==========");
		System.out.println(getQ1());
		for(int i = 0 ; i < choicesNum.length ; i++)
		{
			System.out.printf("%s %d\n",teamList[i],choicesNum[i]);
		}
	}

	public void setQ1(String inputQ)
	{
		Q1 = inputQ;
	}
	
	public String getQ1()
	{
		return Q1;
	}
	

}
