
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

class Solution {
	public void reorderList(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode cur2 = slow.next;
		slow.next = null;
		ListNode cur1 = head;
		cur2 = reverseListNode(cur2);
//		左一定大于右 所以如果右没了就结束了
		while (cur2 != null) {
			ListNode temp1 = cur1.next;
			ListNode temp2 = cur2.next;
			cur1.next = cur2;
			cur2.next = temp1;
			cur1 = temp1;
			cur2 = temp2;
		}

	}

	public ListNode reverseListNode(ListNode head) {
//		临时节点不赋值
		ListNode temp;
		ListNode cur = head;
//		首节点赋值尾null
		ListNode pre = null;
		while (cur != null) {
			temp = cur.next;
//			断开后连接前
			cur.next = pre;
			pre = cur;
			cur = temp;
		}
		return pre;
	}
}