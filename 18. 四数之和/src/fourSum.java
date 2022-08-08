import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//双指针法 时间复杂度n3 
//类似于三数之和，先对数组进行排序
//i和j为选定的两个数的下标，left为窗口的左边界，right为窗口的右边界
//当nums[i]>target并且 num[i]>0时返回结果，例如target=-10 nums[i]=-6 nums[i+1}=-4 所以说当nums为负数时可能会达到target;
//当nums[i]=nums[i-1] 跳过
//当nums[j]=nums[j-1] 跳过
//s<target时 left=left+1 跳过重复的nums[left]
//s>0时 right=right-1 跳过重复的nums[right]
//s=0时记录i,j,left,right 并跳过对应的left和right
class Solution {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < nums.length - 3; i++) {
			if (nums[i] > target && nums[i] > 0) {
				return res;
			}
			if (i > 0 && nums[i - 1] == nums[i]) {
				continue;
			}
			for (int j = i + 1; j < nums.length - 2; j++) {
				if (j > i + 1 && nums[j - 1] == nums[j]) {
					continue;
				}
				int left = j + 1;
				int right = nums.length - 1;
				while (left < right) {
					long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
					if (sum < target) {
						while (left < right && nums[left] == nums[++left])
							;
					} else if (sum > target) {
						while (left < right && nums[right] == nums[--right])
							;
					} else {
						res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
						while (left < right && nums[left] == nums[++left])
							;
						while (left < right && nums[right] == nums[--right])
							;
					}
				}
			}
		}
		return res;
	}
}