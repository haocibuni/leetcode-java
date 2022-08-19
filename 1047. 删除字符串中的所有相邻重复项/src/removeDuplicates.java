import java.util.ArrayDeque;

//��ջ�� ʱ�临�Ӷ�n �ռ临�Ӷ�n
class Solution {
	public String removeDuplicates(String S) {
		// ArrayDeque���LinkedList�ڳ���ɾ��Ԫ����һ������һ��
		// �ο���https://stackoverflow.com/questions/6163166/why-is-arraydeque-better-than-linkedlist
		ArrayDeque<Character> deque = new ArrayDeque<>();
		char ch;
		for (int i = 0; i < S.length(); i++) {
			ch = S.charAt(i);
			if (deque.isEmpty() || deque.peek() != ch) {
				deque.push(ch);
			} else {
				deque.pop();
			}
		}
		String str = "";
		// ʣ���Ԫ�ؼ�Ϊ���ظ���Ԫ��
		while (!deque.isEmpty()) {
			str = deque.pop() + str;
		}
		return str;
	}
}

class Solution_buffer {
	public String removeDuplicates(String s) {
		// �� res ����ջ
		StringBuffer res = new StringBuffer();
		// topΪ res �ĳ���
		int top = -1;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			// �� top > 0,��ջ�����ַ�ʱ����ǰ�ַ������ջ���ַ���ȣ�����ջ���ַ���ͬʱ top--
			if (top >= 0 && res.charAt(top) == c) {
				res.deleteCharAt(top);
				top--;
				// ���򣬽����ַ� ��ջ��ͬʱtop++
			} else {
				res.append(c);
				top++;
			}
		}
		return res.toString();
	}
}