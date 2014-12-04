package mockitopresentation.mocknastyclass;

/**
 * This collaborator represents a static utility class.
 */
public class Collaborator2 {
	
	public static int getValueStatic() {
		System.out
				.println("Collaborator2:getValueStatic() accessing external resources!");
		return 1;
	}
}
