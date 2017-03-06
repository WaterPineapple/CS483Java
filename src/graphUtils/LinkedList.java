package graphUtils;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T> {
	private Node<T> head;
	private Node<T> tail;

	public LinkedList() {
		head = null;
		tail = null;
	}

	public void addFirst(T data) {
		head = tail = new Node<T>(data, null);
	}

	public void addLast(T data) {
		if (head == null)
			addFirst(data);
		else {
			Node<T> tmp = tail;
			tmp.setNext(new Node<T>(data, null));
			tail = tmp.getNext();
		}
	}

	public boolean isEmpty() {
		return head == null;
	}

	public T getFirst() {
		if (head == null)
			throw new NoSuchElementException("List is empty. LinkedList.getFirst");
		return head.getData();
	}

	public T getLast() {
		if (head == null)
			throw new NoSuchElementException("List is empty. LinkedList.getLast");
		return tail.getData();
	}

	public void reverseList() {
		if (head == null)
			throw new IllegalStateException("List is empty. LinkedList.reverseList");
		Node<T> tmp, curr = head;
		tail = head;
		Node<T> next = head.getNext();
		Node<T> prev = tmp = null;
		while (next != null) {
			tmp = next.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = next;
			next.setNext(prev);
			head = next;
			next = tmp;
		}
	}

	public boolean contains(T x) {
		for (T tmp : this)
			if (tmp.equals(x))
				return true;
		return false;
	}

	public T get(int index) {
		if (head == null)
			throw new IndexOutOfBoundsException("Index is out of bounds. LinkedList.get");
		Node<T> tmp = head;
		for (int i = 0; i < index && tmp != null; i++)
			tmp = tmp.getNext();
		if (tmp == null)
			throw new IndexOutOfBoundsException("Index is out of bounds. LinkedList.get");
		T data = tmp.getData();
		return data;
	}

	@Override
	public Iterator<T> iterator() {
		return new LListIterator();
	}

	private class LListIterator implements Iterator<T> {
		private Node<T> node;

		public LListIterator() {
			node = head;
		}

		@Override
		public boolean hasNext() {
			return node != null;
		}

		@Override
		public T next() {
			if (!hasNext())
				throw new IllegalStateException("No next elements. LListIterator.next");
			T data = node.getData();
			node = node.getNext();
			return data;
		}
	}
}