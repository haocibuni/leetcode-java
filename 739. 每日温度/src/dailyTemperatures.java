import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//暴力法
class Solution1 {
	public int[] dailyTemperatures(int[] temperatures) {
		int length = temperatures.length;
//		回答数组
		int[] ans = new int[length];
//		记录每个温度第一次出现的下标
		int[] next = new int[101];
//		初始化为最大
		Arrays.fill(next, Integer.MAX_VALUE);
		for (int i = length - 1; i >= 0; --i) {
			int warmerIndex = Integer.MAX_VALUE;
			for (int t = temperatures[i] + 1; t <= 100; ++t) {
//				找下一个最高温度下标
				if (next[t] < warmerIndex) {
					warmerIndex = next[t];
				}
			}
//			如果最高温度下标不是最大值
			if (warmerIndex < Integer.MAX_VALUE) {
//				则返回最大下标-当前温度下标
				ans[i] = warmerIndex - i;
			}
//			当前温度的值为下标i
			next[temperatures[i]] = i;
		}
		return ans;
	}
}

//单调栈法
class Solution {
	public int[] dailyTemperatures(int[] temperatures) {
		int length = temperatures.length;
//		回答数组
		int[] ans = new int[length];
//		定义栈
		Deque<Integer> queue = new LinkedList<Integer>();
//		下标进栈，因为要记录最高温和当前气温的差值
		queue.add(0);
		for (int i = 1; i < temperatures.length; i++) {
//			栈顶元素大于等于当前元素，则进栈
			if (temperatures[i] <= temperatures[queue.peek()]) {
				queue.push(i);
			} else {
//				否则，对小于当前元素的进行出栈
				while (!queue.isEmpty() && temperatures[queue.peek()] < temperatures[i]) {
//					下标对应的回答为当前下标-下标
					ans[queue.peek()] = i - queue.peek();
					queue.poll();
				}
//				最高温入栈
				queue.push(i);
			}
		}
		return ans;
	}
}
