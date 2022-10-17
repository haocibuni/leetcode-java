
public class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

//虚拟头节点法
//设置虚拟头节点和pre节点以及利用头节点
//建立三条link
class Solution {
	public ListNode swapPairs(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		while (pre.next != null && pre.next.next != null) {
			pre.next = head.next;
//			临时节点存储前两个节点之后断开的节点
			ListNode temp = head.next.next;
			head.next.next = head;
			head.next = temp;
			pre = head;
			head = pre.next;

		}
		return dummy.next;
	}
}