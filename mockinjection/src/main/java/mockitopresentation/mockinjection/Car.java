package mockitopresentation.mockinjection;

/**
 * Our System Unit Test - a car class.
 */

public class Car {

	private IEngine engine;
	private ITransmission transmission;

	public IEngine getEngine() {
		return engine;
	}

	public ITransmission getTransmission() {
		return transmission;
	}
}
