
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

//˫ָ�뷨 ʱ�临�Ӷ�n �ռ临�Ӷ�1
//l=a+b;f=2s;f=s+nb;
//f=2nb s=nb;
//k=a+nb
//fast���¶��嵽��ͷȻ���slowһ����a�����ɵ�����ڴ�
public class Solution {
	public ListNode detectCycle(ListNode head) {
		ListNode slow = head, fast = head;
//		�˴�������a!=b����Ϊ���ܽ���ѭ������ʼ��Ϊͷ�ڵ�
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