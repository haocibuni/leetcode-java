package dp;

import java.util.Arrays;

public class lengthOfLIS {
	public static int solution1(int[] nums) {
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}

			}
		}
		int res = 0;
		for (int i = 0; i < dp.length; i++) {
			res = Math.max(res, dp[i]);
		}
		return res;
	}

	public static int solution2(int[] nums) {
		int[] top = new int[nums.length];
		int piles = 0;
		for (int i = 0; i < nums.length; i++) {
			int left = 0, right = piles;
			while (left < right) {
				int mid = (left + right) / 2;
				if (top[mid] > nums[i]) {
					right = mid;
				} else if (top[mid] < nums[i]) {
					left = mid + 1;
				} else {
					right = mid;
				}
			}
			if (left == piles) {
				piles++;
			}
			top[left] = nums[i];
		}
		return piles;
	}

	public static void main(String[] args) {
		System.out.println(solution2(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }));
	}

}
