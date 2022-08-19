import java.util.Deque;
import java.util.LinkedList;

//堆栈法 时间复杂度n 空间复杂度n
//若碰到运算符则出栈并入栈
//若碰到数字则入栈
class Solution {
	public int evalRPN(String[] tokens) {
		Deque<Integer> stack = new LinkedList();
		for (String s : tokens) {
			if ("+".equals(s)) { // leetcode 内置jdk的问题，不能使用==判断字符串是否相等
				stack.push(stack.pop() + stack.pop()); // 注意 - 和/ 需要特殊处理
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