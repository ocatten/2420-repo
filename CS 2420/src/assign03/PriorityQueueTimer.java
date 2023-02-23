package assign03;

import java.util.Random;

public class PriorityQueueTimer {
	public static void main(String args[]) {
		
		Random randomNumberGenerator = new Random();
		
		// Do 10000 lookups and use the average running time
		int timesToLoop = 1000;
		
		// For each problem size n . . .
		for(int n = 100000; n <= 2000000; n += 100000) {
			
			// Starts with a new priority queue that's empty.
			SimplePriorityQueue priorityQueue = new SimplePriorityQueue();
			
			// Generate a new sorted array of random values and find the max value.
			for(int i = 0; i < n; i++) {
				priorityQueue.insert(randomNumberGenerator.nextInt());
			}
				
			// Defines the fields to track the time.
			long startTime, midpointTime, stopTime;

			// First, spin computing stuff until one second has gone by
			// This allows this thread to stabilize
			startTime = System.nanoTime();
			while(System.nanoTime() - startTime < 1000000000) { // empty block 
			}

			// Now, run the test
			startTime = System.nanoTime();

			for(int i = 0; i < timesToLoop; i++) {
				// Lookup the max element.
				priorityQueue.findMax();
			}

			midpointTime = System.nanoTime();

			// Run a loop to capture the cost of running the "timesToLoop" loop
			for(int i = 0; i < timesToLoop; i++) { // empty block 

			}

			stopTime = System.nanoTime();

			// Compute the time, subtract the cost of running the loop
			// from the cost of running the loop and doing the lookups
			// Average it over the number of runs
			double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime)) / (double) timesToLoop;

			System.out.println(n + "\t" + averageTime);
		}
	}
}