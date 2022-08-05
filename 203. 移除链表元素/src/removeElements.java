
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

//����ڵ㷨
class Solution {
	public ListNode removeElements_dummy(ListNode head, int val) {
		ListNode dummy = new ListNode(-1, head);
		ListNode pre = dummy;
		ListNode cur = head;
		while (cur != null) {
			if (cur.val == val) {
				pre.next = cur.next;
			} else {
				pre = cur;
			}
			cur = cur.next;
		}
		return dummy.next;
	}

//	���������ڵ�ķ�ʽ
	public ListNode removeElements(ListNode head, int val) {
		while (head != null && head.val == val) {
			head = head.next;
		}
		// �Ѿ�Ϊnull����ǰ�˳�
		if (head == null) {
			return head;
		}
		// ��ȷ����ǰhead.val != val
		ListNode pre = head;
		ListNode cur = head.next;
		while (cur != null) {
			if (cur.val == val) {
				pre.next = cur.next;
			} else {
				pre = cur;
			}
			cur = cur.next;
		}
		return head;
	}

}

//
