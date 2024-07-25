public class SinglyLinkedList {
	SingleNode dummyhead;
	SingleNode tail;
	int length;
	
	//default con.
	public SinglyLinkedList() {
		dummyhead = new SingleNode();
		tail = dummyhead;
		length = 0;
	}
	
	public void insertLast(Pair p) {
		SingleNode node = new SingleNode(p);
		tail.next = node;
		tail = node;
		length++;
	}
	
	public void insertFirst(Pair p) {
		SingleNode node = new SingleNode(p);
		node.next = dummyhead.next;
		dummyhead.next = node;
		length++;
	}
	
	
	public void printList() {
		SingleNode curr = dummyhead.next;
		while(curr != null) {
			System.out.print("(" + curr.data.key + "," + curr.data.value + ") -> ");
			curr = curr.next;
		}
	}
	
	public void removeFirst() {
		if(dummyhead.next != null) {
			dummyhead.next = dummyhead.next.next;
			length--;
		}
	}
}







