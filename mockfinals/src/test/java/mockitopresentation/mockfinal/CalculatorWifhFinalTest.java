package mockitopresentation.mockfinal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Notice the annotations added here:
 * 
 * @RunWith tells JUnit to use the PowerMock runner, which uses the PowerMock
 * classloader, enabling bytecode modification.
 * 
 * @PrepareForTest allows mocking final methods on a class, without it, test
 * would fail with exception: MissingMethodInvocationException, because of the
 * attempted call to a final method during stubbing. (After a 15 second delay,
 * in which it runs the actual, unchanged implementation final method).
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest(CalculatorWifhFinal.class)
public class CalculatorWifhFinalTest {

	@Test
	public void testComputeE() throws Exception {
		/*
		 * In addition to the annotations, we create the mock using the
		 * PowerMockito.mock static method instead of the Mockito.mock method.
		 */
		final CalculatorWifhFinal mockCalculator = PowerMockito.mock(CalculatorWifhFinal.class);

		// After creating the mock, its business as usual.
		PowerMockito.when(mockCalculator.computeE()).thenReturn(Math.E);

		// And we get a quick and accurate stubbed calculation from our mock...
		System.out.println("E: " + mockCalculator.computeE());
		
		Mockito.verify(mockCalculator, Mockito.times(1)).computeE();
	}
	
	@Test
	public void testComputeE_wontWork() throws Exception {
		/*
		 * In addition to the annotations, we create the mock using the
		 * PowerMockito.mock static method instead of the Mockito.mock method.
		 */
		final CalculatorWifhFinal mockCalculator = Mockito.mock(CalculatorWifhFinal.class);

		// After creating the mock, its business as usual.
		Mockito.when(mockCalculator.computeE()).thenReturn(Math.E);

		// And we get a quick and accurate stubbed calculation from our mock...
		System.out.println("E: " + mockCalculator.computeE());
		
		Mockito.verify(mockCalculator.computeE(), Mockito.times(1));
	}

}
