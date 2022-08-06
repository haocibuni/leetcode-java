
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

class Solution {
	public ListNode reverseList(ListNode head) {
		ListNode pre = null, cur = head, temp;
		while (cur != null) {
			temp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = temp;
		}
		return pre;

	}

	public ListNode reverseList_recur(ListNode head) {
		return reverse(null, head);
	}

	public ListNode reverse(ListNode pre, ListNode cur) {
		if (cur == null) {
			return pre;
		}
		ListNode temp = cur.next;
		cur.next = pre;
		pre = cur;
		return reverse(cur, temp);

	}
}