package prob1;


public class DoublyLinkedDeleteFirst {
	
	Node header;

	public DoublyLinkedDeleteFirst() {
		header = new Node();
	}

	// adds to the end of the list
	public void addLast(String item) {
		Node next = header;
		while (next.next != null) {
			next = next.next;
		}
		Node n = new Node();
		n.value = item;
		next.next = n;
		n.previous = next;

	}
	
	public boolean isEmpty() {
		return header.next == null;
	}
	
	//removes the node at position 1 and returns
	//the string contained in that node
	public String deleteFirst() {
		if(header.next == null) throw new IllegalStateException(
				"There is no item in position 0 or 1");
		else if(header.next.next == null) throw new IllegalStateException(
				"There is no item in position 1");
		
		else {
			Node oldPos1 = header.next.next;
			Node pos0 = header.next;
			String retVal = oldPos1.value;
			pos0.next = oldPos1.next;
			if(pos0.next != null) {
				pos0.next.previous = pos0;
			}
			return retVal;
		}
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		toString(sb, header);
		return sb.toString();

	}

	private void toString(StringBuilder sb, Node n) {
		if (n == null)
			return;
		if (n.value != null)
			sb.append(" " + n.value);
		toString(sb, n.next);
	}

	class Node {
		String value;
		Node next;
		Node previous;

		public String toString() {
			return value == null ? "null" : value;
		}
	}

	public static void main(String[] args) {
		DoublyLinkedDeleteFirst list = new DoublyLinkedDeleteFirst();
		list.addLast("Bob");
		list.addLast("Harry");
		list.addLast("Steve");
		String deleted = list.deleteFirst();
		System.out.println("This item was deleted: " + deleted);
		System.out.println(list);

	}
}
