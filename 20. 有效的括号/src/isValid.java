import java.util.Deque;
import java.util.LinkedList;

//��ջ�� ʱ�临�Ӷ�n �ռ临�Ӷ�n
class Solution {
	public boolean isValid(String s) {
		Deque<Character> deque = new LinkedList<>();
		char ch;
		for (int i = 0; i < s.length(); i++) {
			ch = s.charAt(i);
			// ���������ţ��Ͱ���Ӧ����������ջ
			if (ch == '(') {
				deque.push(')');
			} else if (ch == '{') {
				deque.push('}');
			} else if (ch == '[') {
				deque.push(']');
			} else if (deque.isEmpty() || deque.peek() != ch) {
				return false;
			} else {// ������������ж��Ƿ��ջ��Ԫ��ƥ��
				deque.pop();
			}
		}
		// ����ж�ջ��Ԫ���Ƿ�ƥ��
		return deque.isEmpty();
	}
}