import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//暴力法 错误 滑动窗口大小不确定
class Solution_force {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums.length == 0||k=0) {
			return new int[0];
		}
		int i = 0, j = k - 1;
		List<Integer> res = new ArrayList<>();
		while (j < nums.length) {
			res.add(Math.max(nums[i], Math.max(nums[i + 1], nums[j])));
			i++;
			j++;
		}
		int[] arr = new int[res.size()];
		for (int l = 0; l < res.size(); l++) {
			arr[l] = res.get(l);
		}
		return arr;
	}
}

//队列法 
//左边界从1-k开始 右边界从0开始
//如果窗口已经填满且移了一位，则判断队列最大值是否是左边界的前一个元素，若是则移除队列的这个元素
//不论窗口是否填满，都把比当前值小的元素去除，然后添加当前元素，形成一个左大右小的队列
//如果窗口已经填满，则将左边界元素添加到res数组
class Solution_queue {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums.length == 0 || k == 0) {
			return new int[0];
		}
		Deque<Integer> deque = new LinkedList<>();
		int[] res = new int[nums.length - k + 1];
		for (int j = 0, i = 1 - k; j < nums.length; j++, i++) {
			if (i > 0 && deque.peekFirst() == nums[i - 1]) {
				deque.removeFirst();
			}
			while (!deque.isEmpty() && deque.peekLast() < nums[j]) {
				deque.removeLast();
			}
			deque.addLast(nums[j]);
			if (i >= 0) {
				res[i] = deque.peekFirst();
			}
		}
		return res;

	}
}