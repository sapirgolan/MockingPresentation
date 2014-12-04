package mockitopresentation.mocknastyclass;

/**
 * This is a final collaborator with a final method.
 */
public final class Collaborator3 {
	
	public final int getValueFinal() {
		System.out
				.println("Collaborator3:getValueFinal() accessing external resources!");
		return 1;
	}
}
