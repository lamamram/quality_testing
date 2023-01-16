package testing.spotBugsSamples;

public class TroublingRankBugs {
	
	public int param = 0; 
	
	/**
	 * Empty synchronized
	 */
	private void emptySynchronized() {
		synchronized (this) {
			param += 1;
		}
	}
	
	/**
	 * @throws InterruptedException
	 */
	private void sleepInSynchronized() throws InterruptedException {
		synchronized(this) {
			Thread.sleep(5000);
		}
	}
}
