class Node {
	public Node next;
	public int data;

	public Node(int data) {
		this.data = data;
		next = null;
	}
}

public class LinkedListExample {

	Node head;

	public boolean isEmpty() {
		return head == null;
	}

	// Task 1: Append an element into the linkedlist
	public void append(int data) {
		Node newNode = new Node(data);

		if (isEmpty()) {
			head = new Node(data);
			return;
		}

		Node lastNode = head;
		while (lastNode.next != null)
			lastNode = lastNode.next;

		lastNode.next = newNode;
		return;
	}

	public String toString() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		return "";
	}

	// Task 2: Remove the tail element from a linkedlist
	public void removeLastNode() {
		if (isEmpty()) {
			return;
		}
		Node last = head;
		Node previousNode = null;

		while (last.next != null) {
			previousNode = last;
			last = last.next;
		}
		previousNode.next = null;
	}

	// Task 3: Remove all element in the linkedlist that is great than a target
	// value
	public void removeBasedOnTargetValue(int value) {
		if (isEmpty()) {
			System.out.println("empty");
			return;
		} else {
			Node temp = head;
			Node previousNode = null;

			while (temp != null && temp.data > value) {
				head = temp.next;
				temp = head;
			}

			while (temp != null) {

				while (temp != null && temp.data <= value) {
					previousNode = temp;
					temp = temp.next;
				}

				if (temp == null)
					return;
				previousNode.next = temp.next;

				temp = previousNode.next;
			}
		}

	}

	public static void main(String args[]) {

		LinkedListExample ll = new LinkedListExample();
		ll.append(5);
		ll.append(4);
		ll.append(1);
		ll.append(2);
		ll.append(10);
		ll.append(3);
		ll.toString();
		ll.removeLastNode();
		System.out.println("");
		ll.toString();
		System.out.println("");
		ll.removeBasedOnTargetValue(4);
		ll.toString();

	}
}
