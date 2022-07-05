import java.util.ArrayList;
import java.util.Stack;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
//��ջ�������������ջ�У�ʱ�临�Ӷ�Ϊn���ռ临�Ӷ�Ϊn��ע�ⲻ�ܽ�ջ��size��Ϊforѭ������ʱ����pop��push�Ĺ��̣�size�ǲ��ϱ仯��
class Solution_Stack {
	public int[] reversePrint(ListNode head) {
		Stack<Integer> stack = new Stack<Integer>();
		ListNode p = head;
		while (p != null) {
			stack.push(p.val);
			p = p.next;
		}
		int size = stack.size();
		int[] reverselist = new int[size];
		for (int i = 0; i < size; i++) {
			reverselist[i] = stack.pop();
		}
		return reverselist;

	}
}

//�ݹ鷨��ʱ�临�ӵ�Ϊn���ռ临�Ӷ�Ϊn��ArrayList���Զ�̬�޸ĵ�����;�ȱ�����β���ٵݹ鷵�أ�
class Solution_recur {
	ArrayList<Integer> tempArrayList = new ArrayList<Integer>();

	public int[] reversePrint(ListNode head) {
		recur(head);
		int[] reverselist = new int[tempArrayList.size()];
		for (int i = 0; i < reverselist.length; i++) {
			reverselist[i] = tempArrayList.get(i);
		}
		return reverselist;
	}

	void recur(ListNode head) {
		if (head == null) {
			return;
		}
		recur(head.next);
		tempArrayList.add(head.val);
	}
}