package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import edu.towson.cis.cosc603.project4.vendingmachine.VendingMachineItemTest;
import edu.towson.cis.cosc603.project4.vendingmachine.VendingMachineTest;

@RunWith(Suite.class)
@SuiteClasses({
	VendingMachineItemTest.class,
	VendingMachineTest.class
})
public class AllTests {

}
