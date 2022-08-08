import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//哈希集合法 时间复杂度n2 空间复杂度n
//两层循环确定a+b 然后使用哈希集合来确定-(a+b)
class Solution_hash {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
//			若a>0则直接退出循环
			if (nums[i] > 0) {
				break;
			}
//			跳过所有相同的a元素
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
//			哈希集合
			Set<Integer> set = new HashSet<>();
//			从a的下一位开始寻找b
			for (int j = i + 1; j < nums.length; j++) {
				if (j > i + 2 && nums[j] == nums[j - 1] && nums[j - 1] == nums[j - 2]) {
					continue;
				}
				int c = 0 - (nums[i] + nums[j]);
				if (set.contains(c)) {
					res.add(new ArrayList<Integer>(Arrays.asList(c, nums[i], nums[j])));
//					跳过所有的c元素
					set.remove(c);
				} else {
					set.add(nums[j]);
				}
			}
		}

		return res;

	}
}

//双指针法 时间复杂度n2 空间复杂度1
//先对数组进行快排
//k为窗口的起始位置，i为窗口的左边界，j为窗口的右边界
//当nums[k]>0 break;
//当nums[k]=nums[k-1] 跳过
//s<0时 i=i+1 跳过重复的nums[i]
//s>0时 j=j-1 跳过重复的nums[j]
//s=0时记录k,i,j
class Solution_doublepoint {
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		for (int k = 0; k < nums.length - 2; k++) {
			if (nums[k] > 0) {
				break;
			}
			if (k > 0 && nums[k] == nums[k - 1]) {
				continue;
			}
			int i = k + 1, j = nums.length - 1;
			while (i < j) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum < 0) {
					while (i < j && nums[i] == nums[++i])
						;
				} else if (sum > 0) {
					while (i < j && nums[j] == nums[--j])
						;
				} else {
					res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
					while (i < j && nums[i] == nums[++i])
						;
					while (i < j && nums[j] == nums[--j])
						;
				}
			}
		}
		return res;

	}
}