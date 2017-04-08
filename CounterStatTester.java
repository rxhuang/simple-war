 
import org.junit.*;
import static org.junit.Assert.*;

// ***********************
// NAME: <your name>
// ID: <your student ID>
// LOGIN: <your class login>
// ***********************

public class CounterStatTester {

	private CounterStat stat;

	/* this sets up the test fixture. JUnit invokes this method before
	every testXXX method.  The @Before tag tells JUnit to run this method
	before each test */
	@Before
	public void setUp() throws Exception {
		stat = new CounterStat(1,2,3);
	}

	/* The @Test tag tells JUnit this is a test to run */
	@Test
	public void testgetTotalGames() {
		System.out.println("Checking getTotalGames");
		assertEquals(6, stat.getTotalGames());
	}

	@Test
	public void testIncrements() {
		System.out.println("Checking Proper Increment");
		stat.incrementComputerWins();
		assertEquals(7, stat.getTotalGames());
		stat.incrementUserWins();
		assertEquals(8, stat.getTotalGames());
		stat.incrementTies();
		assertEquals(9, stat.getTotalGames());
	}


	@Test
	public void testReset() {
		System.out.println("Checking Reset");

		/* TODO: finish a test the verifies Reset */
	}

	/* TODO: write a test that verifies the proper calculation of average for all games  */


	/* TODO: write a test that verifies the resetWrong method. This test must FAIL */

}
