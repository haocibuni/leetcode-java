import java.util.Arrays;

//Ë«Ö¸Õë·¨ ´íÎó
class Solution1 {
	public int pivotIndex(int[] nums) {
		int i = 0, j = nums.length - 1;
		int leftsum = 0, rightsum = nums[j];
		j--;

		while (i < j) {
			while (i < j && leftsum > rightsum) {
				rightsum += nums[j];
				j--;
			}
			if (leftsum == rightsum) {
				return j;
			}
			while (i < j && leftsum < rightsum) {
				leftsum += nums[i];
				i++;
			}
			if (leftsum == rightsum) {
				return i;
			}

		}
		return -1;

	}
}

class Solution {
	public int pivotIndex(int[] nums) {
		int total = Arrays.stream(nums).sum();
		int sum = 0;
		for (int i = 0; i < nums.length; ++i) {
			if (2 * sum + nums[i] == total) {
				return i;
			}
			sum += nums[i];
		}
		return -1;
	}
}