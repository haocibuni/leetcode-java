import java.util.Stack;

//辅助栈法 时间复杂度为n 空间复杂度为n
//将push序列逐个加入辅助栈，然后判断栈顶元素是否等于pop序列，若等于则j++且出栈，若最后辅助栈为空则返回true
class Solution {
	public boolean validateStackSequences(int[] pushed, int[] popped) {
		Stack<Integer> stack = new Stack<Integer>();
		int j = 0;
		for (int i = 0; i < pushed.length; i++) {
			stack.push(pushed[i]);
			while (!stack.isEmpty() && popped[j] == stack.peek()) {
				j++;
				stack.pop();
			}
		}
		if (stack.isEmpty()) {
			return true;
		}
		return false;
	}
}