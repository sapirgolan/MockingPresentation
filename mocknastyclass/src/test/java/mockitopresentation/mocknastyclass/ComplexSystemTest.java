package mockitopresentation.mocknastyclass;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.core.classloader.annotations.SuppressStaticInitializationFor;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

/**
 * Here is an example more akin to real-world or especially legacy code.
 * 
 * We want to test the doSomething() method of the ComplexSystem class, without
 * causing any output written to the Console (this output represents where
 * external resources would be referenced, which is what we DON'T want to happen
 * in our unit test!
 * 
 * Also: if any of the methods we call aren't stubbed properly, they will return
 * the default value of 0. We want the result of doSomething to be 5, to
 * demonstrate all have been stubbed properly.
 */

@RunWith(PowerMockRunner.class)
@SuppressStaticInitializationFor("mockitopresentation.mocknastyclass.ComplexSystem")
@PrepareForTest({ Collaborator1.class, Collaborator2.class,
		Collaborator3.class, BaseSystem.class, ComplexSystem.class })
public class ComplexSystemTest {

	/**
	 * We'll use this method to create an instance of the SUT, with all
	 * collaborators mocked using PowerMock.
	 */
	private static ComplexSystem getNewInstanceToTest() {
		// Mock the static method call on collaborator 2
		PowerMockito.mockStatic(Collaborator2.class);
		PowerMockito.when(Collaborator2.getValueStatic()).thenReturn(1);

		// Suppress base class constructor
		PowerMockito.suppress(PowerMockito.constructor(BaseSystem.class));

		// Suppress System Under Test constructor
		PowerMockito.suppress(PowerMockito.constructor(ComplexSystem.class));

		/*
		 * The use of the @SuppressStaticInitializationFor annotation prevents
		 * ALL static initialization for ComplexSystem from running.
		 * 
		 * Unfortunately, this will mean a NullPoinerException when
		 * staticCollaborator is accessed, since its default value is set during
		 * static initialization. So we need to set it here to a mock.
		 * 
		 * The Whitebox utilities allow us to do this.
		 */
		Whitebox.setInternalStateFromContext(ComplexSystem.class,
				MyContext.class);

		// We can now create the instance of our system to test
		final ComplexSystem complexSystem = new ComplexSystem();

		// Since initialization suppressed, need to manually set value
		// of memberCollaborator field (to a mock)
		final Collaborator1 mockCollaborator1 = PowerMockito.mock(Collaborator1.class);
		PowerMockito.when(mockCollaborator1.getValue()).thenReturn(1);
		Whitebox.setInternalState(complexSystem, "memberCollaborator", mockCollaborator1);

		return complexSystem;
	}

	@Test
	public void testSystemUnderTestDoSomething() {
		// Get our instance to test with mocked collaborators
		final ComplexSystem complexSystem = getNewInstanceToTest();

		// Mock an instance of collaborator3 and stub its final method to
		// provide as an argument
		final Collaborator3 mockCollaborator3 = PowerMockito.mock(Collaborator3.class);
		PowerMockito.when(mockCollaborator3.getValueFinal()).thenReturn(1);

		/*
		 * And call the method on it with no console output.
		 * 
		 * If any of the methods we call are actual implementations, other print
		 * statements will appear on the console.
		 * 
		 * If any of the mocks we've stubstituted aren't stubbed properly, they
		 * will return the default value of 0. We want the result of doSomething
		 * to be 5, to demonstrate all have been stubbed properly.
		 */
		System.out.println("Resulting value: "
				+ complexSystem.doSomething(mockCollaborator3));
	}
}

/**
 * Need to setup a class with identically named static fields (which are mocked)
 * to get values of those mocked static fields copied to our System Under Test
 * using the Whitebox utils.
 * 
 * Stub the static field in a static initializer.
 */
class MyContext {
	private static Collaborator1 staticCollaborator;
	static {
		staticCollaborator = PowerMockito.mock(Collaborator1.class);
		PowerMockito.when(staticCollaborator.getValue()).thenReturn(1);
	}
};
