import java.util.Stack;

class Solution {
	public int trap(int[] height) {
		int size = height.length;

		if (size <= 2)
			return 0;

		// in the stack, we push the index of array
		// using height[] to access the real height
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);

		int sum = 0;
		for (int index = 1; index < size; index++) {
			int stackTop = stack.peek();
			if (height[index] < height[stackTop]) {
				stack.push(index);
			} else if (height[index] == height[stackTop]) {
				// 因为相等的相邻墙，左边一个是不可能存放雨水的，所以pop左边的index, push当前的index
				stack.pop();
				stack.push(index);
			} else {
				// pop up all lower value
				int heightAtIdx = height[index];
				while (!stack.isEmpty() && (heightAtIdx > height[stackTop])) {
					int mid = stack.pop();

					if (!stack.isEmpty()) {
						int left = stack.peek();

						int h = Math.min(height[left], height[index]) - height[mid];
						int w = index - left - 1;
						int hold = h * w;
						if (hold > 0)
							sum += hold;
						stackTop = stack.peek();
					}
				}
				stack.push(index);
			}
		}

		return sum;
	}
}