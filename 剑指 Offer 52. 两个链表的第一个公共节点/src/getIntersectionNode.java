
public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

//暴力法 时间复杂度n2 空间复杂度1
class Solution_force {
	ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		while (headA != null) {
			while (headB != null) {
				if (headA.equals(headB)) {
					return headA;
				}
				headB = headB.next;
			}
			headA = headA.next;
		}
		return null;
	}
}

//双指针法 时间复杂度m+n 空间复杂度1
//具有相同尾部的链表终会相遇
//a为a链表长度 b为b链表长度 c为a和b的共同尾部
//a+(b-c)==b+(a-c)
//如果两个链表没有公共节点则把null当作他们的公共节点
class Solution_doublelink {
	ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode a = headA, b = headB;
		while (a != b) {
			a = a == null ? headB : a.next;
			b = b == null ? headA : b.next;
		}
		return a;
	}
}
//“我走过我的世界，再从你的世界走一遍”
//“你走过你的世界，再从我的世界走一遍”
//“最终我们将相遇，可能在途中（公共节点），可能在结尾（null）”