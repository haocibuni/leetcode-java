class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}
}

//单链表法
//在链表类中添加链表大小size来判断是否越界
//插入和删除时都寻找pre节点
class MyLinkedList {
	ListNode head;
	int size;

	public MyLinkedList() {

		head = new ListNode(0);
		size = 0;
	}

	public int get(int index) {
		if (index < 0 || index >= size) {
			return -1;
		}
		ListNode cur = head;
		for (int i = 0; i <= index; i++) {
			cur = cur.next;
		}
		return cur.val;

	}

	public void addAtHead(int val) {
		addAtIndex(0, val);

	}

	public void addAtTail(int val) {
		addAtIndex(size, val);
	}

	public void addAtIndex(int index, int val) {
		if (index > size) {
			return;
		}
		if (index < 0) {
			index = 0;
		}
		size++;
		ListNode pred = head;
		for (int i = 0; i < index; i++) {
			pred = pred.next;
		}
		ListNode add = new ListNode(val);
		add.next = pred.next;
		pred.next = add;
	}

	public void deleteAtIndex(int index) {
		if (index < 0 || index >= size) {
			return;
		}
		size--;
		ListNode pred = head;
		for (int i = 0; i < index; i++) {
			pred = pred.next;
		}
		pred.next = pred.next.next;
	}
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList(); int param_1 = obj.get(index);
 * obj.addAtHead(val); obj.addAtTail(val); obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */