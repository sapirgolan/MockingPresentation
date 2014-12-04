package mockitopresentation.mocknastyclass;

/**
 * Here is the class we want to test. It has many properties which many it
 * difficult to test: is final, uses initializers and static initializers,
 * sub-class constructor accesses externals, no way to injected dependencies,
 * static references, etc.
 */

public final class ComplexSystem extends BaseSystem {
	
	private static Collaborator1 staticCollaborator = new Collaborator1();

	static {
		System.out
				.println("ComplexSystem:static initializer accessing external resources!");
	}

	private final Collaborator1 memberCollaborator = new Collaborator1();

	{
		System.out
				.println("ComplexSystem:instance initializer() accessing external resources!");
	}

	public ComplexSystem() {
		System.out
				.println("ComplexSystem:ComplexSystem() accessing external resources!");
	}

	// We want to test this method!
	public int doSomething(final Collaborator3 collaborator3) {
		return 1 + collaborator3.getValueFinal()
				+ staticCollaborator.getValue() + memberCollaborator.getValue()
				+ Collaborator2.getValueStatic();
	}
}

