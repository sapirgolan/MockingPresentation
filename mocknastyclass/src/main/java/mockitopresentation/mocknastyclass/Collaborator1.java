package mockitopresentation.mocknastyclass;

/**
 * This collaborator's constructor accesses external resources.
 */
public class Collaborator1 {
	public Collaborator1() {
		System.out
				.println("Collaborator1:Collaborator1() accessing external resources!");
	}

	public int getValue() {
		System.out
				.println("Collaborator1:getValue() accessing external resources!");
		return 1;
	}
}
