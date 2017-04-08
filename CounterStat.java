 

// ***********************
// NAME: <your name>
// ID: <your student ID>
// LOGIN: <your class login>
// ***********************

/**
* A class that implements a simple statistic tracking array
* @version
* @author
* @since
*/


public class CounterStat {

	private final int ARRAY_SIZE = 3;

	//private array of size 3
	private int[] Stat = new int[ARRAY_SIZE];

	public CounterStat()
	{
		// Nothing to do here
	}

	public CounterStat(int first, int second, int third)
	{
		Stat[0] = first;
		Stat[1] = second;
		Stat[2] = third;
	}

	public int getTotalGames() {
		return Stat[0]+Stat[1]+Stat[2];
	}

	public void incrementUserWins() {
		Stat[0]++;
	}

	public void incrementComputerWins() {
		Stat[1]++;
	}

	public void incrementTies() {
		Stat[2]++;
	}



	public int averageGames(int choice)
	{
		//TODO: Complete the method
		//Change the return
		return 0;

	}

	public void printStats()
	{
		System.out.println("Player won: "+averageGames(0) + "% Computer won: " + averageGames(1)+ "% Tied: "+ averageGames(2)+"%\n");
	}

	public void reset() {
		Stat[0]=0;
		Stat[1]=0;
		Stat[2]=0;

	}


	public void resetWrong()
	{
		// TODO: Create an incorrect reset method
		//this method should incorrectly reset the Stat array
	}


}
