package mockitopresentation.mocknastyclass;

/**
 * Base class's constructor accesses external resources.
 */
public class BaseSystem {
	
	public BaseSystem() {
		System.out
				.println("BaseSystem:BaseSystem accessing external resources!");
	}
}
