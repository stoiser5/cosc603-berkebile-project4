package edu.towson.cis.cosc603.project4.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineItemTest {

	VendingMachineItem item1, item2, item3;

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

	}

	@Before
	public void setUp() throws Exception {
		item1 = new VendingMachineItem("Chips", 1.);
		item2 = new VendingMachineItem("Coke", 0.);
		item3 = new VendingMachineItem("Peanuts", 3/4);
	}

	@After
	public void tearDown() throws Exception {

		item1 = null;
		item2 = null;
		item3 = null;
	}


	// test whether negative prices are rejected
	@Test(expected = VendingMachineException.class)	
	public void testVendingMachineConstructorBadPrice() {

		VendingMachineItem itemBadPrice1 = new VendingMachineItem("Mars Bar", -5.);
		
	}

	// test whether names that are null strings are rejected
	@Test(expected = VendingMachineException.class)	
	public void testVendingMachineConstructorNullString() {

		VendingMachineItem itemBadName1 = new VendingMachineItem(null, 2.);
		

	}

	// test whether names that are empty strings are rejected
	@Test(expected = VendingMachineException.class)	
	public void testVendingMachineConstructorEmptyString() {

		VendingMachineItem itemBadName2 = new VendingMachineItem("", 2.);
	}

	// test whether item names are returned correctly
	@Test
	public void testGetName() {
		assertEquals("Chips", item1.getName());
		assertEquals("Coke", item2.getName());
		assertEquals("Peanuts", item3.getName());
	}


	// test whether item prices are correctly returned, check if integers are cast to doubles
	@Test
	public void testGetPrice() {
		assertEquals(1., item1.getPrice(), 0.001);
		assertEquals(0., item2.getPrice(), 0.001);
		//assertEquals(0.75, item3.getPrice(), 0.001);

	}

}
