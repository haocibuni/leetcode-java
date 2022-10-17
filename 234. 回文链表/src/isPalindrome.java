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
//		fast�ڵ����������null�ڵ㣬��������β�ڵ�
		while (fast != null && fast.next != null) {
			pre = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
//		�Ͽ��ڵ�
		pre.next = null;
		ListNode cur1 = head;
//		��ת
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
//		��ʱ�ڵ㲻��ֵ
		ListNode temp;
		ListNode cur = head;
//		�׽ڵ㸳ֵβnull
		ListNode pre = null;
		while (cur != null) {
			temp = cur.next;
//			�Ͽ�������ǰ
			cur.next = pre;
			pre = cur;
			cur = temp;
		}
		return pre;
	}
}