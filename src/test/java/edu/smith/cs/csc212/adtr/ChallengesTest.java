package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.*;
import org.junit.Test;

import edu.smith.cs.csc212.adtr.real.JavaList;
import edu.smith.cs.csc212.adtr.real.JavaSet;

public class ChallengesTest {
	
	// Make two empty sets
	// Unite them
	// Make sure their union is empty
	@Test
	public void testUnionEmpty() {
		SetADT<Integer> left = new JavaSet<Integer>();
		SetADT<Integer> right = new JavaSet<Integer>();
		SetADT<Integer> union = Challenges.union(left, right);
		assertEquals(union.size(), 0);
	}
	
	// Make two sets
	// Fill one with 1, 2, 3, 4
	// Fill the other with 3, 4, 5, 6
	// Unite them
	// Make sure their union has size 6 and contains 1 and 6
	@Test
	public void testUnion() {
		SetADT<Integer> left = new JavaSet<Integer>();
		left.insert(1);
		left.insert(2);
		left.insert(3);
		left.insert(4);
		SetADT<Integer> right = new JavaSet<Integer>();
		right.insert(3);
		right.insert(4);
		right.insert(5);
		right.insert(6);
		SetADT<Integer> union = Challenges.union(left, right);
		assertEquals(union.size(), 6);
		assertTrue(union.contains(1));
		assertTrue(union.contains(6));
	}
	
	// Make two empty sets
	// Intersect them
	// Make sure their intersection is empty
	@Test
	public void testIntersectionEmpty() {
		SetADT<Integer> left = new JavaSet<Integer>();
		SetADT<Integer> right = new JavaSet<Integer>();
		SetADT<Integer> intersection = Challenges.intersection(left, right);
		assertEquals(intersection.size(), 0);
	}
	
	// Make two sets
	// Fill one with 1, 2, 3, 4
	// Fill the other with 3, 4, 5, 6
	// Intersect them
	// Make sure their intersection has size 2,
	// contains 3 but does not contain 1 or 6
	@Test
	public void testIntersection() {
		SetADT<Integer> left = new JavaSet<Integer>();
		left.insert(1);
		left.insert(2);
		left.insert(3);
		left.insert(4);
		SetADT<Integer> right = new JavaSet<Integer>();
		right.insert(3);
		right.insert(4);
		right.insert(5);
		right.insert(6);
		SetADT<Integer> intersection = Challenges.intersection(left, right);
		assertEquals(intersection.size(), 2);
		assertTrue(intersection.contains(3));
		assertFalse(intersection.contains(1));
		assertFalse(intersection.contains(6));
	}

	// Make two sets
	// Fill one with 1, 2, 3, 4
	// Fill the other with 5, 6, 7, 8
	// Intersect them
	// Make sure their intersection has size 0
	@Test
	public void testIntersectionNoOverlap() {
		SetADT<Integer> left = new JavaSet<Integer>();
		left.insert(1);
		left.insert(2);
		left.insert(3);
		left.insert(4);
		SetADT<Integer> right = new JavaSet<Integer>();
		right.insert(5);
		right.insert(6);
		right.insert(7);
		right.insert(8);
		SetADT<Integer> intersection = Challenges.intersection(left, right);
		assertEquals(intersection.size(), 0);
	}
	
	// Make an empty list
	// wordCount it
	// Make sure the word Map is empty
	@Test
	public void testWordCountEmpty() {
		ListADT<String> words = new JavaList<String>();
		MapADT<String, Integer> empty = Challenges.wordCount(words);
		assertEquals(empty.size(), 0);
	}
	
	// Make list with "A", "B", "C", "A"
	// wordCount it
	// Make sure the word Map size is 3, A maps to 2,
	// C maps to 1, and D maps to null
	@Test
	public void testWordCount() {
		ListADT<String> words = new JavaList<String>();
		words.addBack("A");
		words.addBack("B");
		words.addBack("C");
		words.addBack("A");
		MapADT<String, Integer> wordsMap = Challenges.wordCount(words);
		assertEquals(wordsMap.size(), 3);
		assertEquals(wordsMap.get("A"), new Integer(2));
		assertEquals(wordsMap.get("C"), new Integer(1));
		assertNull(wordsMap.get("D"));
	}
	
}