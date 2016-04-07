package edu.towson.cis.cosc603.project4.vendingmachine;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>VendingMachineExceptionTest</code> contains tests for the class <code>{@link VendingMachineException}</code>.
 *
 * @generatedBy CodePro at 4/3/16 8:21 PM
 * @author Sigrid
 * @version $Revision: 1.0 $
 */
public class VendingMachineExceptionTest {
	/**
	 * Run the VendingMachineException() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/3/16 8:21 PM
	 */
	@Test
	public void testVendingMachineException_1()
		throws Exception {

		VendingMachineException result = new VendingMachineException();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getCause());
		assertEquals("edu.towson.cis.cosc603.project4.vendingmachine.VendingMachineException", result.toString());
		assertEquals(null, result.getLocalizedMessage());
		assertEquals(null, result.getMessage());
	}

	/**
	 * Run the VendingMachineException(String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/3/16 8:21 PM
	 */
	@Test
	public void testVendingMachineException_2()
		throws Exception {
		String reason = "";

		VendingMachineException result = new VendingMachineException(reason);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getCause());
		assertEquals("edu.towson.cis.cosc603.project4.vendingmachine.VendingMachineException: ", result.toString());
		assertEquals("", result.getLocalizedMessage());
		assertEquals("", result.getMessage());
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 4/3/16 8:21 PM
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 4/3/16 8:21 PM
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 4/3/16 8:21 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(VendingMachineExceptionTest.class);
	}
}