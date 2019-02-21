package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import edu.smith.cs.csc212.adtr.errors.BadIndexError;
import edu.smith.cs.csc212.adtr.errors.EmptyListError;
import edu.smith.cs.csc212.adtr.real.JavaList;


public class JavaListTest {
	
	/**
	 * Make a new empty list.
	 * @return an empty list to be tested.
	 */
	private <T> ListADT<T> makeEmptyList() {
		return new JavaList<>();
	}
	
	/**
	 * Helper method to make a full list.
	 * @return [a, b, c, d] - a small, predictable list for many tests.
	 */
	private ListADT<String> makeFullList() {
		ListADT<String> data = makeEmptyList();
		data.addBack("a");
		data.addBack("b");
		data.addBack("c");
		data.addBack("d");
		return data;
	}
		
	@Test
	public void testEmpty() {
		ListADT<String> data = makeEmptyList();
		Assert.assertEquals(0, data.size());
		Assert.assertEquals(true, data.isEmpty());
	}
	
	@Test(expected=EmptyListError.class)
	public void testRemoveFrontCrash() {
		ListADT<String> data = makeEmptyList();
		data.removeFront();
	}
	
	@Test(expected=EmptyListError.class)
	public void testRemoveBackCrash() {
		ListADT<String> data = makeEmptyList();
		data.removeBack();
	}
	
	@Test(expected=EmptyListError.class)
	public void testRemoveIndexCrash() {
		ListADT<String> data = makeEmptyList();
		data.removeIndex(3);
	}

	@Test
	public void testAddToFront() {
		ListADT<String> data = makeEmptyList();
		Assert.assertEquals(true, data.isEmpty());
		data.addFront("1");
		Assert.assertEquals(1, data.size());
		Assert.assertEquals("1", data.getIndex(0));
		Assert.assertEquals(false, data.isEmpty());
		data.addFront("0");
		Assert.assertEquals(2, data.size());
		Assert.assertEquals("0", data.getIndex(0));
		Assert.assertEquals("1", data.getIndex(1));
		Assert.assertEquals(false, data.isEmpty());
		data.addFront("-1");
		Assert.assertEquals(3, data.size());
		Assert.assertEquals("-1", data.getIndex(0));
		Assert.assertEquals("0", data.getIndex(1));
		Assert.assertEquals("1", data.getIndex(2));
		Assert.assertEquals(false, data.isEmpty());
		data.addFront("-2");
		Assert.assertEquals("-1", data.getIndex(1));
		Assert.assertEquals("-2", data.getIndex(0));
		Assert.assertEquals("0", data.getIndex(2));
		Assert.assertEquals("1", data.getIndex(3));
		Assert.assertEquals(false, data.isEmpty());
	}
	
	@Test
	public void testAddToBack() {
		ListADT<String> data = makeEmptyList();
		data.addBack("1");
		Assert.assertEquals(1, data.size());
		Assert.assertEquals("1", data.getIndex(0));
		data.addBack("0");
		Assert.assertEquals(2, data.size());
		Assert.assertEquals("0", data.getIndex(1));
		Assert.assertEquals("1", data.getIndex(0));
		data.addBack("-1");
		Assert.assertEquals(3, data.size());
		Assert.assertEquals("-1", data.getIndex(2));
		Assert.assertEquals("0", data.getIndex(1));
		Assert.assertEquals("1", data.getIndex(0));
		data.addBack("-2");
		Assert.assertEquals("-2", data.getIndex(3));
		Assert.assertEquals("-1", data.getIndex(2));
		Assert.assertEquals("0", data.getIndex(1));
		Assert.assertEquals("1", data.getIndex(0));
	}
	
	@Test
	public void testGetFront() {
		ListADT<String> data = makeFullList();
		assertEquals("a", data.getFront());
	}
	
	@Test
	public void testGetBack() {
		ListADT<String> data = makeFullList();
		assertEquals("d", data.getBack());
	}
	
	@Test(expected=EmptyListError.class)
	public void testGetFrontCrash() {
		ListADT<String> data = makeEmptyList();
		data.getFront();
	}
	
	@Test(expected=EmptyListError.class)
	public void testGetBackCrash() {
		ListADT<String> data = makeEmptyList();
		data.getBack();
	}
	
	@Test(expected=BadIndexError.class)
	public void testGetIndexLow() {
		ListADT<String> data = makeFullList();
		data.getIndex(-2);
	}
	
	@Test(expected=BadIndexError.class)
	public void testGetIndexHigh() {
		ListADT<String> data = makeFullList();
		data.getIndex(data.size());
	}
	
	@Test(expected=BadIndexError.class)
	public void testGetIndexHighEasy() {
		ListADT<String> data = makeFullList();
		data.getIndex(data.size()*2);
	}
	
	@Test(expected=BadIndexError.class)
	public void testAddIndexHighEasy() {
		ListADT<String> data = makeFullList();
		data.addIndex(data.size()*2, "the");
	}
	
	@Test(expected=BadIndexError.class)
	public void testAddIndexHigh() {
		ListADT<String> data = makeFullList();
		data.addIndex(data.size()+1, "the");
	}
	
	@Test(expected=BadIndexError.class)
	public void testAddIndexLow() {
		ListADT<String> data = makeFullList();
		data.addIndex(-1, "the");
	}
	
	// Test that addIndex actually changes the value at the index
	// Make sure the next value in the list is what was previously at the index that was added
		@Test
		public void testAddIndex() {
			ListADT<String> data = makeFullList();
			String originalOne = data.getIndex(1);
			data.addIndex(1, "r");
			assertEquals(data.getIndex(1), "r");
			assertEquals(data.getIndex(2), originalOne);
		}
	
	// Test too low index for setIndex
	@Test(expected=BadIndexError.class)
	public void testSetIndexLow() {
		ListADT<String> data = makeFullList();
		data.setIndex(-1, "the");
	}
	
	// Test too high index for setIndex
	@Test(expected=BadIndexError.class)
	public void testSetIndexHigh() {
		ListADT<String> data = makeFullList();
		data.setIndex(data.size()+1, "the");
	}
	
	// Test very high too high index for setIndex
	@Test(expected=BadIndexError.class)
	public void testSetIndexHighEasy() {
		ListADT<String> data = makeFullList();
		data.setIndex(data.size()*2, "the");
	}
	
	// Test that setIndex actually changes the value at the index
	// Make sure that the next value in the list was the same as it was before
	@Test
	public void testSetIndex() {
		ListADT<String> data = makeFullList();
		String originalTwo = data.getIndex(2);
		data.setIndex(1, "r");
		assertEquals(data.getIndex(1), "r");
		assertEquals(data.getIndex(2), originalTwo);
	}
	
	// Make sure removeBack returns the item that is there
	// Make sure the size of the list decrements by one
	@Test
	public void testRemoveBack() {
		ListADT<String> data = makeFullList();
		int originalSize = data.size();
		assertEquals(data.getBack(), data.removeBack());
		assertEquals(data.size(), originalSize - 1);
	}
	
	// Make sure removeIndex returns the item that is there
	// Make sure the size of the list decrements by one
	@Test
	public void testRemoveIndex() {
		ListADT<String> data = makeFullList();
		int originalSize = data.size();
		assertEquals(data.getIndex(1), data.removeIndex(1));
		assertEquals(data.size(), originalSize - 1);
	}
		
	// Make sure removeFront returns the item that is there
	// Make sure the size of the list decrements by one
	@Test
	public void testRemoveFront() {
		ListADT<String> data = makeFullList();
		int originalSize = data.size();
		assertEquals(data.getFront(), data.removeFront());
		assertEquals(data.size(), originalSize - 1);
	}
	
	@Test
	public void testToJava() {
		assertEquals(makeFullList().toJava(), Arrays.asList("a", "b", "c", "d"));
	}
}
