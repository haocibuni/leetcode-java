class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}
}

class MyLinkedList {
	ListNode head;

	public MyLinkedList() {

		ListNode head = new ListNode(0);
	}

	public int get(int index) {
		ListNode cur = head;
		for (int i = 0; i <= index; i++) {
			cur = cur.next;
		}
		return cur.val;

	}

	public void addAtHead(int val) {

	}

	public void addAtTail(int val) {

	}

	public void addAtIndex(int index, int val) {

	}

	public void deleteAtIndex(int index) {

	}
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList(); int param_1 = obj.get(index);
 * obj.addAtHead(val); obj.addAtTail(val); obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */