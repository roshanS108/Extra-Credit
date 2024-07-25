public class SingleNode {
	Pair data;
	SingleNode next;
	//Default Constructor
	public SingleNode() {
		data = null;
		next = null;
	}
	//Non-default constructor
	public SingleNode(Pair pair) {
		data = pair;
		next = null;
	}
}
