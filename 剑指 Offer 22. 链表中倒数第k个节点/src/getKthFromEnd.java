/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
//先获取链表长度然后重新遍历 时间复杂度2n-k
class Solution_doublefor {
	public ListNode getKthFromEnd(ListNode head, int k) {
		ListNode temp = head;
		int sum = 0;
		while (temp != null) {
			temp = temp.next;
			sum++;
		}
		temp = head;
		for (int i = 0; i < sum - k; i++) {
			temp = temp.next;
		}
		return temp;

	}
}

//双指针法 时间复杂度n
//需要判断链表是否为空 k是否为0 k是否大于链表的长度
class Solution_doublepoint {
	public ListNode getKthFromEnd(ListNode head, int k) {
		ListNode former = head, latter = head;
		if (head == null || k <= 0) {
			return null;
		}
		for (int i = 0; i < k; i++) {
			if (former == null) {
				return null;
			}
			former = former.next;
		}
		while (former != null) {
			latter = latter.next;
			former = former.next;
		}
		return latter;

	}
}