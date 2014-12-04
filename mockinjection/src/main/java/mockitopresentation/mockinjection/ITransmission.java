package mockitopresentation.mockinjection;

/**
 * Another sample collaborator used by the S.U.T.; in addition to our already
 * defined Engine interface.
 */
public interface ITransmission {

	void shiftUp();

	void shiftDown();

	int getCurrentGear();
}
