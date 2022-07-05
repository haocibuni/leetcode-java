/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
//˫ָ�뷨 ʱ�临�Ӷ�l1+l2 �ռ临�Ӷ�1
//αͷ�ڵ���Ҫnew �����ܸ�ֵ
class Solution_doublepoint {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode headtemp, cur = headtemp;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				cur.next = l1;
				l1 = l1.next;
			} else {
				cur.next = l2;
				l2 = l2.next;
			}
			cur = cur.next;
		}
		if (l1 != null) {
			cur.next = l1;
		} else {
			cur.next = l2;
		}
		return headtemp.next;
	}
}