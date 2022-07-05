/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
//新建链表前插 时间复杂度n 空间复杂度n
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

//双指针法 时间复杂度n 空间复杂度1
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

//递归法 时间复杂度n 空间复杂度n 空间为每一次递归创建的res节点
class Solution_recur {
	public ListNode reverseList(ListNode head) {

		return recur(null, head);
	}

	public ListNode recur(ListNode before, ListNode cur) {
		if (cur == null) {
			return before;
		}
//		先递归到最后节点
		ListNode res = recur(cur, cur.next);
//		再沿着递归反方向进行回溯 连接当前节点和前面节点
		cur.next = before;
		return res;

	}
}