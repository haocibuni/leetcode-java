/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
//�Ȼ�ȡ������Ȼ�����±��� ʱ�临�Ӷ�2n-k
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

//˫ָ�뷨 ʱ�临�Ӷ�n
//��Ҫ�ж������Ƿ�Ϊ�� k�Ƿ�Ϊ0 k�Ƿ��������ĳ���
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