package graphUtils;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {
	private LinkedList<Integer> list;

	@Before
	public void setupList() {
		list = new LinkedList<>();
	}

	@Test
	public void listReturnsIterator() {
		assertEquals(true, list.iterator() instanceof Iterator);
	}

	@Test
	public void listIteratorWorksCorrectly() {
		list.addFirst(5);
		list.addLast(6);
		Iterator<Integer> iterator = list.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(true, iterator.next() == 5);
		assertEquals(true, iterator.hasNext());
		assertEquals(true, iterator.next() == 6);
		assertEquals(false, iterator.hasNext());
	}
	
	@Test
	public void listIsEmptyInitially() {
		assertEquals(true, list.isEmpty());
	}

	@Test
	public void listIsNotEmptyAfterAddToFirst() {
		list.addFirst(5);
		assertEquals(false, list.isEmpty());
	}

	@Test
	public void listGetFirstReturnsData() {
		list.addFirst(5);
		assertEquals(true, list.getFirst() == 5);
	}

	@Test
	public void listGetLastReturnsLast() {
		list.addFirst(5);
		assertEquals(true, list.getLast() == 5);
		list.addFirst(9);
		assertEquals(true, list.getFirst() == 9);
		assertEquals(true, list.getLast() == 9);
	}

	@Test
	public void listAddsToLast() {
		list.addLast(5);
		assertEquals(true, list.getLast() == 5);
		list.addLast(9);
		assertEquals(true, list.getFirst() == 5);
		assertEquals(true, list.getLast() == 9);
	}

	@Test
	public void listIteratorIteratesForward() {
		list.addLast(4);
		list.addLast(3);
		Iterator<Integer> iterator = list.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(true, iterator.next() == 4);
		assertEquals(true, iterator.next() == 3);
	}

	@Test
	public void listShouldContainAddedElements() {
		list.addFirst(1);
		list.addLast(3);
		assertEquals(true, list.contains(1));
		assertEquals(true, list.contains(3));
	}

	@Test
	public void listShouldGetElement() {
		list.addFirst(0);
		list.addLast(1);
		list.addLast(2);
		assertEquals(true, list.get(0) == 0);
		assertEquals(true, list.get(1) == 1);
		assertEquals(true, list.get(2) == 2);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void indexGreaterThanListLengthThrowsIndexOutOfBoundsException() {
		list.addFirst(0);
		list.addLast(1);
		list.get(2);
	}

	@Test
	public void callingReverseShouldReverseTheList() {
		list.addLast(0);
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.reverseList();
		assertEquals(true, list.get(0) == 3);
		assertEquals(true, list.get(1) == 2);
		assertEquals(true, list.get(2) == 1);
		assertEquals(true, list.get(3) == 0);
	}
}