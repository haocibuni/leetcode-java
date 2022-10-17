
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

//����ͷ�ڵ㷨
//��������ͷ�ڵ��pre�ڵ��Լ�����ͷ�ڵ�
//��������link
class Solution {
	public ListNode swapPairs(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		while (pre.next != null && pre.next.next != null) {
			pre.next = head.next;
//			��ʱ�ڵ�洢ǰ�����ڵ�֮��Ͽ��Ľڵ�
			ListNode temp = head.next.next;
			head.next.next = head;
			head.next = temp;
			pre = head;
			head = pre.next;

		}
		return dummy.next;
	}
}