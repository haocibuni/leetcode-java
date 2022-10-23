import java.util.Stack;

class Solution1 {
	public boolean judgeCircle(String moves) {
		Stack<Character> stack1 = new Stack<>();
		Stack<Character> stack2 = new Stack<>();
		for (char c : moves.toCharArray()) {
			if (c == 'U' || c == 'D') {
				if (stack1.isEmpty()) {
					stack1.add(c);
					continue;
				} else {
					if ((stack1.peek() == 'U' && c == 'D') || (stack1.peek() == 'D' && c == 'U')) {
						stack1.pop();
					} else {
						stack1.push(c);
					}
				}
			} else {
				if (stack2.isEmpty()) {
					stack2.add(c);
					continue;
				} else {
					if ((stack2.peek() == 'L' && c == 'R') || (stack2.peek() == 'R' && c == 'L')) {
						stack2.pop();
					} else {
						stack2.push(c);
					}
				}
			}

		}
		return stack1.isEmpty() && stack2.isEmpty();

	}
}

class Solution {
	public boolean judgeCircle(String moves) {
		int x = 0;
		int y = 0;
		for (char c : moves.toCharArray()) {
			if (c == 'U')
				y++;
			if (c == 'D')
				y--;
			if (c == 'L')
				x++;
			if (c == 'R')
				x--;
		}
		return x == 0 && y == 0;
	}

}