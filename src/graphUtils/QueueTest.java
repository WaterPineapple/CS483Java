package graphUtils;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class QueueTest {
	Queue<Integer> queue;
	
	@Before
	public void setupQueue() {
		queue = new Queue<>();
	}
	
	@Test
	public void testQueueReturnsIterator() {
		assertEquals(true, queue.iterator() instanceof Iterator);
	}
	
	@Test
	public void queueIteratorWorksCorrectly() {
		queue.enqueue(5);
		queue.enqueue(6);
		Iterator<Integer> iterator = queue.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(true, iterator.next() == 5);
		assertEquals(true, iterator.hasNext());
		assertEquals(true, iterator.next() == 6);
		assertEquals(false, iterator.hasNext());
		
	}
	
	@Test
	public void queueIsEmptyInitially() {
		assertEquals(true, queue.isEmpty());
	}
	
	@Test
	public void addingToQueueInsertsAtTail() {
		queue.enqueue(0);
		queue.enqueue(1);
		assertEquals(true, queue.peek() == 0);
	}
	
	@Test
	public void dequeueRemovesFirstElement() {
		queue.enqueue(0);
		queue.enqueue(1);
		int expected = queue.dequeue();
		assertEquals(true, expected == 0);
		assertEquals(true, queue.peek() == 1);
	}
}
