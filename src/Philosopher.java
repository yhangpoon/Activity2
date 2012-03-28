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
	
	private int id;
	private Fork left;
	private Fork right;
	private boolean rHanded;
	private int nTimes;
	private long thinkMillis;
	private long eatMillis;
	private boolean infRun;
	
	
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
		int sleepAmount;
		Random rndGen = new Random();
		// Run while infinite run is set to true or if the counter hasn't
		// hit zero yet.
		while(infRun || (!(nTimes <= 0))){
			// Sleep for a random amount of time.
			sleepAmount = rndGen.nextInt((int)this.thinkMillis);
			System.out.println("Philosopher " + String.valueOf(this.id) + 
					" thinks for " + String.valueOf(sleepAmount) + 
					" time units.");
			try {
				Thread.sleep((long)sleepAmount);
			} catch (InterruptedException e) {
				// Do nothing
			}
			
			// Acquire first fork
			//TODO
		}
		
	} // end method run
	
} // end class Philosopher
