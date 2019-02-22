package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

import edu.smith.cs.csc212.adtr.real.JavaMap;

public class JavaMapTest {
	
	// you might want this.
	void assertIntEq(int x, int y) {
		assertEquals(x, y);
	}

	@Test
	public void testEmpty() {
		MapADT<String, Integer> empty = new JavaMap<>();
		assertEquals(empty.size(), 0);
	}
	
	// Put A - 1, B - 2, A - 3, C - 3 in Map
	// Make sure map size is 3
	@Test
	public void testSizeNonzero() {
		MapADT<String, Integer> abc = new JavaMap<>();
		abc.put("A", 1);
		abc.put("B", 2);
		abc.put("A", 3);
		abc.put("C", 3);
		assertEquals(abc.size(), 3);
	}
	
	// Put A - 1 in Map
	// Make sure get returns 1
	@Test
	public void testGet() {
		MapADT<String, Integer> a = new JavaMap<>();
		a.put("A", 1);
		assertIntEq(a.get("A"), 1);
	}
	
	// Put A - 1 and A - 2 in Map
	// Make sure get returns 2
	@Test
	public void testGetDuplicate() {
		MapADT<String, Integer> a = new JavaMap<>();
		a.put("A", 1);
		a.put("A", 2);
		assertIntEq(a.get("A"), 2);
	}
	
	// Put A - 1 in Map
	// Remove A
	// Make sure get is null
	@Test
	public void testRemove() {
		MapADT<String, Integer> a = new JavaMap<>();
		a.put("A", 1);
		assertIntEq(a.remove("A"), 1);
		assertNull(a.get("A"));
	}
	
	// Make an empty map
	// Get the Keys
	// Make sure the list is empty
	@Test
	public void testGetKeysEmpty() {
		MapADT<String, Integer> empty = new JavaMap<>();
		ListADT<String> emptyKeys = empty.getKeys();
		assertTrue(emptyKeys.isEmpty());
	}
	
	// Put A - 1, B - 2, A - 3, C - 3 into a Map
	// Get the Keys
	// Make sure the List has the same size as the Map
	// Make sure the List contains A
	@Test
	public void testGetKeysFilled() {
		MapADT<String, Integer> abc = new JavaMap<>();
		abc.put("A", 1);
		abc.put("B", 2);
		abc.put("A", 3);
		abc.put("C", 3);
		ListADT<String> abcKeys = abc.getKeys();
		assertEquals(abc.size(), abcKeys.size());
		boolean contains = false;
		for (String s : abcKeys) {
			if (s.equals("A")) {
				contains = true;
				break;
			}
		}
		assertTrue(contains);
	}
	
	// Make an empty Map
	// Get the entries
	// Make sure the list is empty
	@Test
	public void testGetEntriesEmpty() {
		MapADT<String, Integer> empty = new JavaMap<>();
		ListADT<Pair<String, Integer>> emptyValues = empty.getEntries();
		assertTrue(emptyValues.isEmpty());
	}
	
	// Put A - 1, B - 2, A - 3, C - 3 in Map
	// Get the entries
	// Make sure the list has the same size as the map
	// Make sure the list contains 3 for A and not 1
	@Test
	public void testGetEntriesFilled() {
		MapADT<String, Integer> abc = new JavaMap<>();
		abc.put("A", 1);
		abc.put("B", 2);
		abc.put("A", 3);
		abc.put("C", 3);
		ListADT<Pair<String, Integer>> abcValues = abc.getEntries();
		assertEquals(abcValues.size(), abc.size());
		boolean contains = false;
		boolean doesNotContain = true;
		for (Pair<String, Integer> p : abcValues) {
			if (p.getKey().equals("A") && p.getValue().equals(new Integer(3))) {
				contains = true;
			}
			else if (p.getKey().equals("A") && p.getValue().equals(new Integer (1))) {
				doesNotContain = false;
			}
		}
		assertTrue(contains);
		assertTrue(doesNotContain);
	}
	
	// Make an empty map
	// Convert it to Java
	// Make sure Java's set is empty
	@Test
	public void testToJavaEmpty() {
		MapADT<String, Integer> empty = new JavaMap<>();
		Map<String, Integer> emptyJava = empty.toJava();
		assertTrue(emptyJava.isEmpty());
	}
	
	// Put A - 1, B - 2, A - 3, and C - 4 in map
	// Convert it to Java
	// Make sure the Java map has the same size as the map
	// Make sure both maps contain the same value for A
	@Test
	public void testToJavaFilled() {
		MapADT<String, Integer> abc = new JavaMap<>();
		abc.put("A", 1);
		abc.put("B", 2);
		abc.put("A", 3);
		abc.put("C", 4);
		Map<String, Integer> abcJava = abc.toJava();
		assertEquals(abc.size(), abcJava.size());
		assertEquals(abc.get("A"), abcJava.get("A"));
	}
}
