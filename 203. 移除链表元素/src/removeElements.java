
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

//虚拟节点法
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

//	不添加虚拟节点的方式
	public ListNode removeElements(ListNode head, int val) {
		while (head != null && head.val == val) {
			head = head.next;
		}
		// 已经为null，提前退出
		if (head == null) {
			return head;
		}
		// 已确定当前head.val != val
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
