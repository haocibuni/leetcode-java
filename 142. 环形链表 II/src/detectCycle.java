
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

//双指针法 时间复杂度n 空间复杂度1
//l=a+b;f=2s;f=s+nb;
//f=2nb s=nb;
//k=a+nb
//fast重新定义到表头然后跟slow一起走a步即可到达入口处
public class Solution {
	public ListNode detectCycle(ListNode head) {
		ListNode slow = head, fast = head;
//		此处不能用a!=b，因为不能进入循环，起始都为头节点
		while (true) {
			if (fast == null || fast.next == null) {
				return null;
			}
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				break;
			}
		}
		fast = head;
		while (slow != fast) {
			fast = fast.next;
			slow = slow.next;
		}
		return fast;

	}
}