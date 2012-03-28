/**
 * @author Greg Chambers
 * @author Jacob Juby
 * @author Yin Poon
 */

import java.util.Random;

/**
 * Philosopher class that extends thread. Concurrently used to acquire Fork
 * resources and simulated eating and thinking behavior. 
 */
public class Philosopher extends Thread {
	
	private final int id;
	private Fork left;
	private Fork right;
	private final boolean rHanded;
	private final int nTimes;
	private final long thinkMillis;
	private final long eatMillis;
	private final boolean infRun;
	
	
	/**
	 * Constructor for the Philosopher threaded class.
	 * 
	 * @param int id
	 * @param Fork left
	 * @param Fork right
	 * @param boolean rHanded
	 * @param int nTimes
	 * @param long thinkMillis
	 * @param long eatMillis
	 */
	public Philosopher(int id, Fork left, Fork right, boolean rHanded,
			int nTimes, long thinkMillis, long eatMillis){
		this.id = id;
		this.left = left;
		this.right = right;
		this.rHanded = rHanded;
		this.nTimes = nTimes;
		this.thinkMillis = thinkMillis;
		this.eatMillis = eatMillis;
		if(nTimes == 0){
			this.infRun = true;
		} else {
			this.infRun = false;
		}
		
	} // end constructor Philosopher
	
	/**
	 * Override for the run method in the Thread class.
	 */
	public void run(){
		int runCount = this.nTimes;
		long sleepAmount;
		long eatAmount;
		Random rndGen = new Random();
		// Run while infinite run is set to true or if the counter hasn't
		// hit zero yet.
		while(infRun || (!(runCount <= 0))){
			// Sleep for a random amount of time.
			sleepAmount = rndGen.nextLong() % this.thinkMillis;
			System.out.println("Philosopher " + String.valueOf(this.id) + 
					" thinks for " + String.valueOf(sleepAmount) + 
					" time units.");
			try {
				Thread.sleep(sleepAmount);
			} catch (InterruptedException e) {
				// Do nothing
			}
			
			// Acquire first fork
			if(this.rHanded){
				System.out.println("Philosopher " + String.valueOf(this.id) +
						" goes for right fork.");
				this.right.acquire();
				System.out.println("Philosopher " + String.valueOf(this.id) + 
						" has right fork.");
			} else {
				System.out.println("Philosopher " + String.valueOf(this.id) +
					" goes for left fork.");
				this.left.acquire();
				System.out.println("Philosopher " + String.valueOf(this.id) +
					" has left fork.");
			}
			
			// Let other threads acquire fork
			Thread.yield();
			
			// Acquire second fork
			if(this.rHanded){
				System.out.println("Philosopher " + String.valueOf(this.id) +
					" goes for left fork.");
				this.left.acquire();
				System.out.println("Philosopher " + String.valueOf(this.id) +
					" has left fork.");
			} else {
				System.out.println("Philosopher " + String.valueOf(this.id) +
					" goes for right fork.");
				this.right.acquire();
				System.out.println("Philosopher " + String.valueOf(this.id) + 
					" has right fork.");
			}
			
			// Eating
			eatAmount = rndGen.nextLong() % this.eatMillis;
			System.out.println("Philosopher " + String.valueOf(this.id) + 
					" eats for " + String.valueOf(eatAmount) + 
					" time units.");
			try {
				Thread.sleep(eatAmount);
			} catch (InterruptedException e) {
				// Do nothing
			}
			
			// Release forks
			this.right.release();
			System.out.println("Philosopher " + String.valueOf(this.id) + 
					" releases right fork.");
			this.left.release();
			System.out.println("Philosopher " + String.valueOf(this.id) + 
				" releases left fork.");
			
		}
		
	} // end method run
	
} // end class Philosopher
