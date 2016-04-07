/**
 * 
 */
package edu.towson.cis.cosc603.project4.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sigrid
 *
 */
public class VendingMachineTest {
	private VendingMachine emptyVendingMachine;
	private VendingMachine fullVendingMachine;
	private double price_A = 1.5;
	private double price_B = 2.;
	private double price_C = 0.99;
	private double price_D = 2.19;

	VendingMachineItem item1, item2, item3, item4;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {	

		item1 = new VendingMachineItem("Chips", price_A);
		item2 = new VendingMachineItem("Coke", price_B);
		item3 = new VendingMachineItem("Peanuts", price_C);
		item4 = new VendingMachineItem("Mars Bar", price_D);

		emptyVendingMachine = new VendingMachine();
		fullVendingMachine = new VendingMachine();

		fullVendingMachine.addItem(item1, "A");
		fullVendingMachine.addItem(item2, "B");
		fullVendingMachine.addItem(item3, "C");
		fullVendingMachine.addItem(item4, "D");

	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		emptyVendingMachine = null;
		fullVendingMachine = null;
		item1 = null;
		item2 = null;
		item3 = null;
		item4 = null;
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#addItem(edu.towson.cis.cosc603.project4.vendingmachine.VendingMachineItem, java.lang.String)}.
	 * tests whether items can be correctly added to empty vending machine
	 */
	@Test
	public void testAddItemToEmptyVMWithValidInput() {
		
		assertNull(emptyVendingMachine.getItem("A"));
		assertNull(emptyVendingMachine.getItem("B"));
		assertNull(emptyVendingMachine.getItem("C"));
		assertNull(emptyVendingMachine.getItem("D"));
		
		emptyVendingMachine.addItem(item1, "A");	
		emptyVendingMachine.addItem(item2, "B");
		emptyVendingMachine.addItem(item3, "C");	
		emptyVendingMachine.addItem(item4, "D");	

		assertEquals("Chips", emptyVendingMachine.getItem("A").getName());
		assertEquals("Coke", emptyVendingMachine.getItem("B").getName());
		assertEquals("Peanuts", emptyVendingMachine.getItem("C").getName());
		assertEquals("Mars Bar", emptyVendingMachine.getItem("D").getName());
	}

	// test if exceptions are thrown when items are placed in slots that are already occupied
	@Test(expected = VendingMachineException.class)
	public void testAddItemToOccupiedSlots() {
		fullVendingMachine.addItem(item1, "A");
		fullVendingMachine.addItem(item1, "B");
		fullVendingMachine.addItem(item1, "C");
		fullVendingMachine.addItem(item1, "D");
	}

	// test if exceptions are thrown when items are tried to be placed in slots with invalid code
	@Test(expected = VendingMachineException.class)
	public void testAddItemToNonexistingSlots() {
		emptyVendingMachine.addItem(item1, "X");
		emptyVendingMachine.addItem(item2, "Slot1");	
	}
	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#removeItem(java.lang.String)}.
	 * tests if items can be removed from all four slots
	 */
	@Test
	public void testRemoveItemWithValidInput() {
		fullVendingMachine.removeItem("A");
		fullVendingMachine.removeItem("B");
		fullVendingMachine.removeItem("C");
		fullVendingMachine.removeItem("D");

		assertNull(fullVendingMachine.getItem("A"));
		assertNull(fullVendingMachine.getItem("B"));
		assertNull(fullVendingMachine.getItem("C"));
		assertNull(fullVendingMachine.getItem("D"));		
	}

	// tests if exception is thrown when items are removed from empty slots
	@Test(expected = VendingMachineException.class)
	public void testRemoveItemFromEmptySlots() {
		emptyVendingMachine.removeItem("A");
		emptyVendingMachine.removeItem("B");
		emptyVendingMachine.removeItem("C");
		emptyVendingMachine.removeItem("D");	
	}

	// tests if exception is thrown when items are removed from invalid slots
	@Test(expected = VendingMachineException.class)
	public void testRemoveItemFromInvalidSlots() {
		fullVendingMachine.removeItem("X");
		fullVendingMachine.removeItem("Slot1");	
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#insertMoney(double)}.
	 * tests if money can be inserted into the machine and the balance is updated
	 */
	@Test
	public void testInsertMoneyValidInput() {
		assertTrue(emptyVendingMachine.getBalance() >= 0.);
		
		emptyVendingMachine.insertMoney(1.);
		emptyVendingMachine.insertMoney(2.);
		emptyVendingMachine.insertMoney(3.);
		fullVendingMachine.insertMoney(599.99);

		assertEquals(6., emptyVendingMachine.getBalance(), 0.001);
		assertEquals(599.99, fullVendingMachine.getBalance(), 0.001);
	}

	// tests if negative values for inserted money cause an exception to be thrown
	@Test(expected = VendingMachineException.class)
	public void testInsertMoneyNegativeInput() {
		assertTrue(emptyVendingMachine.getBalance() >= 0.);
		emptyVendingMachine.insertMoney(-1.);	
	}
	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#getBalance()}.
	 * tests if the money balance of the vending machine is correctif it is empty.
	 */
	@Test
	public void testGetBalanceOfEmptyVendingMachine() {

		assertEquals(0., emptyVendingMachine.getBalance(), 0.001);

		double balance = emptyVendingMachine.getBalance();

		assertEquals(0., balance , 0.001);

	}

	// tests if balance is correct if money is already in the vending machine
	@Test
	public void testGetBalanceOfVendingMachineWithMoney() {

		assertEquals(0., emptyVendingMachine.getBalance(), 0.001);
		emptyVendingMachine.insertMoney(3.5);
		assertEquals(3.5, emptyVendingMachine.getBalance(), 0.001);

		double balance = emptyVendingMachine.getBalance();

		assertEquals(3.5, balance, 0.001);

	}
	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#makePurchase(java.lang.String)}.
	 * test if the vending machine balance is updated after making a purchase
	 */
	@Test
	public void testMakePurchaseBalance() {

		assertTrue(fullVendingMachine.getBalance() >= 0.);

		fullVendingMachine.insertMoney(20.);

		fullVendingMachine.makePurchase("A");
		fullVendingMachine.makePurchase("B");
		fullVendingMachine.makePurchase("C");
		fullVendingMachine.makePurchase("D");

		assertEquals((20. - price_A - price_B - price_C - price_D), fullVendingMachine.getBalance(), 0.001);

	}

	// tests if the return code is true if purchase is successful
	@Test
	public void testMakePurchaseReturnCodeTrue() {

		assertTrue(fullVendingMachine.getBalance() >= 0.);

		fullVendingMachine.insertMoney(20.);

		assertTrue(fullVendingMachine.makePurchase("A"));
		assertTrue(fullVendingMachine.makePurchase("B"));
		assertTrue(fullVendingMachine.makePurchase("C"));
		assertTrue(fullVendingMachine.makePurchase("D"));
	}

	// tests if the return code is false if not enough money is in the machine to make purchase
	// or slot is empty
	@Test
	public void testMakePurchaseReturnCodeFalse() {

		assertTrue(fullVendingMachine.getBalance() >= 0.);
		fullVendingMachine.insertMoney(0.989);

		assertFalse(fullVendingMachine.makePurchase("A"));
		assertFalse(fullVendingMachine.makePurchase("B"));
		assertFalse(fullVendingMachine.makePurchase("C"));
		assertFalse(fullVendingMachine.makePurchase("D"));
		
		assertTrue(emptyVendingMachine.getBalance() >= 0.);
		emptyVendingMachine.insertMoney(5.);
		
		assertFalse(emptyVendingMachine.makePurchase("A"));
		assertFalse(emptyVendingMachine.makePurchase("B"));
		assertFalse(emptyVendingMachine.makePurchase("C"));
		assertFalse(emptyVendingMachine.makePurchase("D"));
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#returnChange()}.
	 * tests whether correct amount of change is returned and vending machine balance is set to 0. 
	 */
	@Test
	public void testReturnChange() {
		assertTrue(emptyVendingMachine.getBalance() >= 0.);
		double change0 = emptyVendingMachine.returnChange();
		assertEquals(0., emptyVendingMachine.getBalance(), 0.001);
		assertEquals(0., change0, 0.001);
		
		assertTrue(emptyVendingMachine.getBalance() >= 0.);
		emptyVendingMachine.insertMoney(10.);
		double change10 = emptyVendingMachine.returnChange();
		
		assertEquals(0., emptyVendingMachine.getBalance(), 0.001);
		assertEquals(10., change10, 0.001);
		
	}

}
