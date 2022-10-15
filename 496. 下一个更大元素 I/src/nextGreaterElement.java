import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

//暴力法 时间复杂度n3
class Solution1 {
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int[] res = new int[nums1.length];
		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				if (nums1[i] == nums2[j]) {
					res[i] = -1;
					for (int k = j + 1; k < nums2.length; k++) {
						if (nums2[j] < nums2[k]) {
							res[i] = nums2[k];
							break;
						}
					}
				}
			}
		}
		return res;
	}
}

//单调栈法
class Solution {
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//		以-1初始化
		int[] res = new int[nums1.length];
		Arrays.fill(res, -1);
		Stack<Integer> stack = new Stack<>();
//		使用哈希集合记录
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < res.length; i++) {
			hashMap.put(nums1[i], i);
		}
//		对nums2选取最大值
		stack.push(nums2[0]);
		for (int i = 1; i < nums2.length; i++) {
//			若小于等于栈顶则进栈
			if (nums2[i] <= stack.peek()) {
				stack.push(nums2[i]);
			} else {
//				若大于栈顶则出栈，并记录过程
				while (!stack.isEmpty() && nums2[i] > stack.peek()) {
//					若num1包含出栈元素于下标对齐
					if (hashMap.containsKey(stack.peek())) {
						res[hashMap.get(stack.peek())] = nums2[i];

					}
					stack.pop();
				}
//				进栈
				stack.push(nums2[i]);
			}
		}
		return res;
	}
}