package temp;

import java.util.Arrays;

public class quicksort {
	public static void main(String[] args) {
		int[] nums = { 4, 5, 6, 7, 8, 1, 3, 4 };
		sort(nums, 0, nums.length - 1);
		System.out.println(Arrays.toString(nums));
	}

	public static void sort(int[] nums, int l, int r) {
		if (l >= r) {
			return;
		}
		int i = l, j = r;
		while (i < j) {
			while (i < j && nums[j] >= nums[l]) {
				j--;
			}
			while (i < j && nums[i] <= nums[l]) {
				i++;
			}
			swap(nums, i, j);
		}
		swap(nums, l, i);
		sort(nums, l, i - 1);
		sort(nums, i + 1, r);

	}

	public static void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}
}
