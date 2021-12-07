package de.mathisneunzig.advancedIT.util;

public class FifoQueue<F> {
	
	private Node<F> head;
	private int size = 0;
	
	public void put(F data) {
		if(head == null)
			head = new Node<F>(data);
		else {
			Node<F> current = head;
			while(current.nextNode != null) {
				current = current.nextNode;
			}
			current.nextNode = new Node<F>(data);
		}
		size ++;
	}
	
	public F get() {
		Node<F> n = head;
		head = head.nextNode;
		size--;
		return n.data;
	}
	
	public int getSize() {
		return this.size;
	}
	
	private class Node<N> {
		public Node<N> nextNode;
		public N data;
		public Node(N data) {
			this.data = data;
		}
	}

}
