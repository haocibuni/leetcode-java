import java.util.HashMap;

//暴力法 时间复杂度n2
//排序法 时间复杂度nlogn 空间复杂度logn的栈空间
class Solution_sort {
	public int majorityElement(int[] nums) {
		quickSort(nums, 0, nums.length - 1);
		return nums[nums.length / 2];
	}

	void quickSort(int[] arr, int low, int high) {
		int i, j, temp, t;
		if (low > high) {
			return;
		}
		i = low;
		j = high;
		// temp就是基准位
		temp = arr[low];

		while (i < j) {
			// 先看右边，依次往左递减
			while (temp <= arr[j] && i < j) {
				j--;
			}
			// 再看左边，依次往右递增
			while (temp >= arr[i] && i < j) {
				i++;
			}
			// 如果满足条件则交换
			if (i < j) {
				t = arr[j];
				arr[j] = arr[i];
				arr[i] = t;
			}

		}
		// 最后将基准为与i和j相等位置的数字交换
		arr[low] = arr[i];
		arr[i] = temp;
		// 递归调用左半数组
		quickSort(arr, low, j - 1);
		// 递归调用右半数组
		quickSort(arr, j + 1, high);
	}

}

//哈希法 时间复杂度n 空间复杂度n
//数字为键 出现次数为值
//HashMap的containKey和put方法
//entryset时键值对的集合 集合里面的类型为Map.entry 是用来遍历map的一种方法
class Solution_hash {
	private Map<Integer, Integer> countNums(int[] nums) {
		Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
		for (int num : nums) {
			if (!counts.containsKey(num)) {
				counts.put(num, 1);
			} else {
				counts.put(num, counts.get(num) + 1);
			}
		}
		return counts;
	}

	public int majorityElement(int[] nums) {
		Map<Integer, Integer> counts = countNums(nums);

		Map.Entry<Integer, Integer> majorityEntry = null;
		for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
			if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
				majorityEntry = entry;
			}
		}

		return majorityEntry.getKey();
	}
}

//摩尔投票法 时间复杂度n 空间复杂度1
//众数票数为+1 非众数票数为-1 所以所有数字的票数一定大于0
//若前i各数字票数和为0 则后面数字的票数和一定大于0
class Solution_vote {

	public int majorityElement(int[] nums) {
		int votes = 0, x = 0, count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (votes == 0) {
				x = nums[i];
			}
			votes += nums[i] == x ? 1 : -1;
		}
//		判断众数的长度是否大于数组长度的一半
		for (int i = 0; i < nums.length; i++) {
			if (x == nums[i]) {
				count++;
			}
		}
		return count > nums.length / 2 ? x : 0;
	}
}
