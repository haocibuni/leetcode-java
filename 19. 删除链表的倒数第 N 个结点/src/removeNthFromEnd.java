
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

//˫ָ�뷨 ʱ�临�Ӷ�n �ռ临�Ӷ�1
//��fastָ������n+1����slowΪɾ���ڵ��ǰһ���ڵ�
class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode slow = dummy, fast = dummy;
		while (n + 1 > 0 && fast != null) {
			fast = fast.next;
			n--;
		}
		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
		return dummy.next;
	}
}