/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
//�½�����ǰ�� ʱ�临�Ӷ�n �ռ临�Ӷ�n
class Solution_newList {
	public ListNode reverseList(ListNode head) {
		ListNode last = new ListNode();
		if (head != null) {
			last.val = head.val;
			last.next = null;
			head = head.next;
		} else {
			return head;
		}

		while (head != null) {
			ListNode headtemp = new ListNode();
			headtemp.val = head.val;
			headtemp.next = last;
			last = headtemp;
			head = head.next;

		}
		return last;
	}
}

//˫ָ�뷨 ʱ�临�Ӷ�n �ռ临�Ӷ�1
class Solution_doublepoint {
	public ListNode reverseList(ListNode head) {
		ListNode cur = head, before = null;
		while (cur != null) {
			ListNode temp = cur.next;
			cur.next = before;
			before = cur;
			cur = temp;
		}
		return before;
	}
}

//�ݹ鷨 ʱ�临�Ӷ�n �ռ临�Ӷ�n �ռ�Ϊÿһ�εݹ鴴����res�ڵ�
class Solution_recur {
	public ListNode reverseList(ListNode head) {

		return recur(null, head);
	}

	public ListNode recur(ListNode before, ListNode cur) {
		if (cur == null) {
			return before;
		}
//		�ȵݹ鵽���ڵ�
		ListNode res = recur(cur, cur.next);
//		�����ŵݹ鷴������л��� ���ӵ�ǰ�ڵ��ǰ��ڵ�
		cur.next = before;
		return res;

	}
}