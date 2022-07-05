import java.util.ArrayList;
import java.util.Stack;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
//堆栈法，将链表放入栈中，时间复杂度为n，空间复杂度为n，注意不能将栈的size作为for循环条件时，在pop或push的过程，size是不断变化的
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

//递归法，时间复杂的为n，空间复杂度为n，ArrayList可以动态修改的数组;先遍历到尾，再递归返回；
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