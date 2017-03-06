package graphUtils;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<T> implements Iterable<T> {
	private Node<T> first;
	private Node<T> last;
	private int size;

	public Queue() {
		first = last = null;
		size = 0;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public T peek() {
		if (isEmpty())
			throw new NoSuchElementException("Queue is empty. Queue.peek");
		return first.getData();
	}

	public void enqueue(T data) {
		if (isEmpty())
			first = last = new Node<T>(data, null);
		else {
			Node<T> tmp = last;
			tmp.setNext((last = new Node<T>(data, null)));
		}
		size++;
	}

	public T dequeue() {
		if (isEmpty())
			throw new NoSuchElementException("Queue underflow. Queue.dequeue");
		T data = first.getData();
		first = first.getNext();
		if (size-- == 1)
			last = null;
		return data;
	}

	public int getSize() {
		return size;
	}

	@Override
	public Iterator<T> iterator() {
		return new QueueIterator(first);
	}

	private class QueueIterator implements Iterator<T> {
		private Node<T> node;

		public QueueIterator(Node<T> first) {
			node = first;
		}

		@Override
		public boolean hasNext() {
			return node != null;
		}

		@Override
		public T next() {
			if (!hasNext())
				throw new IllegalStateException("No next elements. QueueIterator.next");
			T data = node.getData();
			node = node.getNext();
			return data;
		}
	}
}
