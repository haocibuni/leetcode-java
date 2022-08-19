import java.util.ArrayDeque;

//堆栈法 时间复杂度n 空间复杂度n
class Solution {
	public String removeDuplicates(String S) {
		// ArrayDeque会比LinkedList在除了删除元素这一点外会快一点
		// 参考：https://stackoverflow.com/questions/6163166/why-is-arraydeque-better-than-linkedlist
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
		// 剩余的元素即为不重复的元素
		while (!deque.isEmpty()) {
			str = deque.pop() + str;
		}
		return str;
	}
}

class Solution_buffer {
	public String removeDuplicates(String s) {
		// 将 res 当做栈
		StringBuffer res = new StringBuffer();
		// top为 res 的长度
		int top = -1;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			// 当 top > 0,即栈中有字符时，当前字符如果和栈中字符相等，弹出栈顶字符，同时 top--
			if (top >= 0 && res.charAt(top) == c) {
				res.deleteCharAt(top);
				top--;
				// 否则，将该字符 入栈，同时top++
			} else {
				res.append(c);
				top++;
			}
		}
		return res.toString();
	}
}