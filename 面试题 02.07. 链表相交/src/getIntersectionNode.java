
public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

//肯定能到null相等 或 公共节点相等
public class Solution {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode a = headA, b = headB;
		while (a != b) {
			a = a == null ? headB : a.next;
			b = b == null ? headA : b.next;
		}
		return a;
	}
}