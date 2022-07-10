import java.util.Stack;

//����ջ�� ʱ�临�Ӷ�Ϊn �ռ临�Ӷ�Ϊn
//��push����������븨��ջ��Ȼ���ж�ջ��Ԫ���Ƿ����pop���У���������j++�ҳ�ջ���������ջΪ���򷵻�true
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