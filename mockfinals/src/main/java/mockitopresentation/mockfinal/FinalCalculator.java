package mockitopresentation.mockfinal;

/**
 * Here is a final class with a method we want to stub.
 */
public final class FinalCalculator {
	public double computePi() {
		// Simulate a lengthly compuation
		System.out.println("Computing value...");
		try {
			Thread.sleep(15000);
		} catch (final InterruptedException e) {
			// won't be interrupted
		}

		return 3; // close enough, give up
	}
}
