import java.util.Deque;
import java.util.LinkedList;

//��ջ�� ʱ�临�Ӷ�n �ռ临�Ӷ�n
//��������������ջ����ջ
//��������������ջ
class Solution {
	public int evalRPN(String[] tokens) {
		Deque<Integer> stack = new LinkedList();
		for (String s : tokens) {
			if ("+".equals(s)) { // leetcode ����jdk�����⣬����ʹ��==�ж��ַ����Ƿ����
				stack.push(stack.pop() + stack.pop()); // ע�� - ��/ ��Ҫ���⴦��
			} else if ("-".equals(s)) {
				stack.push(-stack.pop() + stack.pop());
			} else if ("*".equals(s)) {
				stack.push(stack.pop() * stack.pop());
			} else if ("/".equals(s)) {
				int temp1 = stack.pop();
				int temp2 = stack.pop();
				stack.push(temp2 / temp1);
			} else {
				stack.push(Integer.valueOf(s));
			}
		}
		return stack.pop();
	}
}