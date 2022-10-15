import java.util.Arrays;
import java.util.Stack;

class Solution {
	public int[] nextGreaterElements(int[] nums) {
		int length = nums.length;
		int[] res = new int[nums.length];
		Arrays.fill(res, -1);
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		for (int i = 1; i < 2 * length; i++) {
			if (nums[i % length] <= nums[stack.peek()]) {
				stack.push(i % length);
			} else {
				while (!stack.isEmpty() && nums[i % length] > nums[stack.peek()]) {
					res[stack.peek()] = nums[i % length];
					stack.pop();
				}
				stack.push(nums[i % length]);
			}
		}
		return res;

	}
}