import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			hashMap.put(nums[i], i);
		}
		List<Integer> temp = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {

			temp.add(nums[i]);
			for (int j = i + 1; j < nums.length; j++) {
				temp.add(nums[j]);
				if (hashMap.containsKey(-nums[i] - nums[j]) && hashMap.get(-nums[i] - nums[j]) != i
						&& hashMap.get(-nums[i] - nums[j]) != j) {
					temp.add(nums[hashMap.get(-nums[i] - nums[j])]);
					res.add(new ArrayList<>(temp));
					temp.remove(temp.size() - 1);

				}
				temp.remove(temp.size() - 1);

			}
			temp.remove(temp.size() - 1);
		}
		return res;

	}
}

class Solution1 {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			hashMap.put(nums[i], i);
		}
		List<Integer> temp = new ArrayList<>();
		Arrays.sort(nums);
		int left = 0, right = nums.length - 1, sum;

		while (left < right) {
			temp.add(nums[left]);
			temp.add(nums[right]);
			sum = -nums[left] - nums[right];
			if (hashMap.containsKey(sum) && hashMap.get(sum) != left && hashMap.get(sum) != right) {
				temp.add(sum);
				res.add(new ArrayList<>(temp));

			}
			temp.clear();
			if (-sum < 0) {
				left++;
			} else if (-sum > 0) {
				right--;
			} else {
				break;
			}
		}

		return res;

	}
}

class Solution2 {
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> resArrayList = new ArrayList<>();
		int j, k, sum;
		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			j = i + 1;
			k = nums.length - 1;
			while (j < k) {
				while (j > i + 1 && j < nums.length && nums[j] == nums[j - 1]) {
					j++;
				}
				if (j >= k) {
					break;
				}
				sum = nums[i] + nums[j] + nums[k];
				if (sum == 0) {
					resArrayList.add(Arrays.asList(nums[i], nums[j], nums[k]));
					j++;
				} else if (sum > 0) {
					k--;
				} else {
					j++;
				}

			}
		}
		return resArrayList;

	}
}