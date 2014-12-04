package mockitopresentation.mockinjection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;



/**
 * Here is an example test class for the car class.
 * 
 * Could have also included a call to MockitoAnnotations.initMocks(this); in a
 * 
 * @Before annotated method.
 */
@RunWith(MockitoJUnitRunner.class)
public class CarTest {
	@Mock
	private IEngine mockStartedEngine;

	@Mock
	private ITransmission mockFirstGearTransmission;

	@InjectMocks
	private Car classUnderTest;

	@Test
	public void testCarHasEngine() {
		/*
		 * We NEVER created mocks for the car's engine or transmission, and we
		 * NEVER set them on our classUnderTest instance, yet here they are,
		 * available to us
		 */
		Assert.assertNotNull("Car should have an engine!", classUnderTest.getEngine());
		Assert.assertNotNull("Car should have a transmission!", classUnderTest.getTransmission());

		// We can now use the mock engine and mock transmission as needed...
	}
}
