package mockitopresentation.mockinjection;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Here is an example test class for the engine interface.
 */
public class CarSecondTest {

	/*
	 * The @Mock annotation means that JUnit will inject a mock Engine here.
	 */
	@Mock
	private IEngine mockStartedEngine;

	@Before
	public void setUp() throws Exception {
		/*
		 * Either need this call in a @Before method, or need to annotate class
		 * 
		 * @RunWith(MockitoJUnitRunner.class).
		 */
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetRPMs() {
		// We never initialized mockStartedEngine = mock(Engine.class);
		// but it IS setup for us.
		Mockito.when(mockStartedEngine.isRunning()).thenReturn(true);
		Mockito.when(mockStartedEngine.getRPMs()).thenReturn(2000);

		assertTrue("Engine should be running!", mockStartedEngine.isRunning());
		assertTrue("A running engine should be revolving!",
				mockStartedEngine.getRPMs() > 0);
	}

}
