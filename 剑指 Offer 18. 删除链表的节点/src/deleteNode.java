/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
//���ظ�Ԫ��˫ָ�뷨 ʱ�临�Ӷ�n
class Solution_doublelink {
	public ListNode deleteNode(ListNode head, int val) {
		ListNode before = head, temp = head;

		while (temp != null) {
			if (head.val == val) {
				head = temp.next;
				before = head;
				temp = head;
				continue;

			}
			if (temp.val == val) {
				before.next = temp.next;
				temp = temp.next;
			}
			before = temp;
			if (temp != null) {
				temp = temp.next;
			}

		}
		return head;

	}
}

//���ظ�Ԫ��˫ָ�뷨��ʱ�临�Ӷ�n
class Solution {
	public ListNode deleteNode(ListNode head, int val) {
		if (head.val == val)
			return head.next;
		ListNode pre = head, cur = head.next;
		while (cur != null && cur.val != val) {
			pre = cur;
			cur = cur.next;
		}
		if (cur != null)
			pre.next = cur.next;
		return head;
	}
}