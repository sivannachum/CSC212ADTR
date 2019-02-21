package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.smith.cs.csc212.adtr.real.JavaSet;

public class JavaSetTest {
	
	@Test
	public void testEmpty() {
		SetADT<String> empty = new JavaSet<>();
		assertEquals(empty.size(), 0);
	}
	
	// Add A, B, and C to a set
	// Make sure the size is 3
	@Test
	public void testSizeNonzero() {
		SetADT<String> abc = new JavaSet<>();
		abc.insert("A");
		abc.insert("B");
		abc.insert("C");
		assertEquals(abc.size(), 3);
	}
	
	// Add multiple A's and one B
	// Make sure the size is 2
	@Test
	public void testInsertDuplicate() {
		SetADT<String> aab = new JavaSet<>();
		aab.insert("A");
		aab.insert("A");
		aab.insert("A");
		aab.insert("B");
		aab.insert("A");
		assertEquals(aab.size(), 2);
	}
	
	// Add A
	// Test if set contains A is true
	@Test
	public void testContainsTrue() {
		SetADT<String> a = new JavaSet<>();
		a.insert("A");
		assertTrue(a.contains("A"));
	}
	
	// Add A
	// Test if set contains B is true
	@Test
	public void testContainsFalse() {
		SetADT<String> a = new JavaSet<>();
		a.insert("A");
		assertFalse(a.contains("B"));
	}
	
	// Add A and B
	// Remove B
	// Test if set still contains B
	@Test
	public void testRemove() {
		SetADT<String> ab = new JavaSet<>();
		ab.insert("A");
		ab.insert("B");
		ab.remove("B");
		assertFalse(ab.contains("B"));
	}
	
	// Make an empty set
	// Convert it to List
	// Make sure the list is empty
	@Test
	public void testToListEmpty() {
		SetADT<String> empty = new JavaSet<>();
		ListADT<String> emptyList = empty.toList();
		assertTrue(emptyList.isEmpty());
	}
	
	// Add A, A, B, and C
	// Convert to List
	// Make sure list size is same as SetADT's size
	// Make sure the list contains A
	@Test
	public void testToListFilled() {
		SetADT<String> abc = new JavaSet<>();
		abc.insert("A");
		abc.insert("A");
		abc.insert("B");
		abc.insert("C");
		ListADT<String> abcList = abc.toList();
		assertEquals(abcList.size(), abc.size());
		boolean contains = false;
		for (String s : abcList) {
			if (s.equals("A")) {
				contains = true;
				break;
			}
		}
		assertTrue(contains);
	}
	
	// Make an empty set
	// Convert it to Java
	// Make sure Java's set is empty
	@Test
	public void testToJavaEmpty() {
		SetADT<String> empty = new JavaSet<>();
		Set<String> emptyJava = empty.toJava();
		assertTrue(emptyJava.isEmpty());
	}
	
	// Add A, A, B, and C
	// Convert to Java
	// Make sure Java's set contains A, B, and C
	// Make sure Java's set size is same as SetADT's size
	// Make sure the list contains A
	@Test
	public void testToJavaFilled() {
		SetADT<String> abc = new JavaSet<>();
		abc.insert("A");
		abc.insert("A");
		abc.insert("B");
		abc.insert("C");
		Set<String> abcJava = abc.toJava();
		assertEquals(abc.size(), abcJava.size());
		assertTrue(abc.contains("A"));
		assertTrue(abc.contains("B"));
		assertTrue(abc.contains("C"));
		boolean contains = false;
		for (String s : abcJava) {
			if (s.equals("A")) {
				contains = true;
				break;
			}
		}
		assertTrue(contains);
	}
	
}
