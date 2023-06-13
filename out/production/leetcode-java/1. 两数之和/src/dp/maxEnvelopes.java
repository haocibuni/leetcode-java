package dp;

import java.util.Arrays;
import java.util.Comparator;

public class maxEnvelopes {
	public int solution(int[][] envelopes) {
		Arrays.sort(envelopes, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
			}
		});
		int[] h = new int[envelopes.length];
		for (int i = 0; i < h.length; i++) {
			h[0] = envelopes[i][1];
		}
		return solution1(h);
	}

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

}
