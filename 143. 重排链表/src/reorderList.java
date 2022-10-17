
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
	public void reorderList(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode cur2 = slow.next;
		slow.next = null;
		ListNode cur1 = head;
		cur2 = reverseListNode(cur2);
//		��һ�������� ���������û�˾ͽ�����
		while (cur2 != null) {
			ListNode temp1 = cur1.next;
			ListNode temp2 = cur2.next;
			cur1.next = cur2;
			cur2.next = temp1;
			cur1 = temp1;
			cur2 = temp2;
		}

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