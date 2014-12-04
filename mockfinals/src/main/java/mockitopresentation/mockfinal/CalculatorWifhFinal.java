package mockitopresentation.mockfinal;

/**
 * A non-final class with a final method, for testing.
 */
public class CalculatorWifhFinal {

	public final double computeE() {
		// Simulate a lengthly compuation
		System.out.println("Computing value...");
		try {
			Thread.sleep(15000);
		} catch (final InterruptedException e) {
			// won't be interrupted
		}

		return 2; // close enough, give up
	}
}
