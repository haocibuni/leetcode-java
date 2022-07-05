/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
//双指针法 时间复杂度l1+l2 空间复杂度1
//伪头节点需要new 否则不能赋值
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