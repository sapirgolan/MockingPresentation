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
 * @PrepareForTest allows mocking a final class, without it, test would fail
 * with exception: you can't mock finals.
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest(FinalCalculator.class)
public class FinalCalculatorTest {

	@Test
	public void testComputePi_withPowerMockAPI() throws Exception {
		/*
		 * All the extra code was in the annotations, now we can mock and stub
		 * as normal.
		 */
		final FinalCalculator mockCalculator = PowerMockito.mock(FinalCalculator.class);
		PowerMockito.when(mockCalculator.computePi()).thenReturn(Math.PI);

		// And we get a quick and accurate stubbed calculation from our mock...
		System.out.println("Pi: " + mockCalculator.computePi());
		
		Mockito.verify(mockCalculator, Mockito.times(1)).computePi();
	}
	
	@Test
	public void testComputePi_withMockitoAPI() {
		/*
		 * All the extra code was in the annotations, now we can mock and stub
		 * as normal.
		 */
		final FinalCalculator mockCalculator = Mockito.mock(FinalCalculator.class);
		Mockito.when(mockCalculator.computePi()).thenReturn(Math.PI);

		// And we get a quick and accurate stubbed calculation from our mock...
		System.out.println("Pi: " + mockCalculator.computePi());
		
		Mockito.verify(mockCalculator, Mockito.times(1)).computePi();
	}
}
