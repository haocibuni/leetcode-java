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
	public boolean isPalindrome(ListNode head) {
		ListNode pre = head;
		ListNode slow = head;
		ListNode fast = head;
//		fast节点最多能跳到null节点，最少跳到尾节点
		while (fast != null && fast.next != null) {
			pre = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
//		断开节点
		pre.next = null;
		ListNode cur1 = head;
//		反转
		ListNode cur2 = reverseListNode(slow);
		while (cur1 != null) {
			if (cur1.val != cur2.val) {
				return false;
			}
			cur1 = cur1.next;
			cur2 = cur2.next;
		}

		return true;

	}

	public ListNode reverseListNode(ListNode head) {
//		临时节点不赋值
		ListNode temp;
		ListNode cur = head;
//		首节点赋值尾null
		ListNode pre = null;
		while (cur != null) {
			temp = cur.next;
//			断开后连接前
			cur.next = pre;
			pre = cur;
			cur = temp;
		}
		return pre;
	}
}