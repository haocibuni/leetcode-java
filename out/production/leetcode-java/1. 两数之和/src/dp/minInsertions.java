package dp;

public class minInsertions {
	public static int solution1(String s) {
		int len = s.length();
		int[][] dp = new int[len][len];
		for (int i = len - 2; i >= 0; i--) {
			for (int j = i + 1; j < len; j++) {
				if (s.charAt(i) == s.charAt(j)) {
					dp[i][j] = dp[i + 1][j - 1];
				} else {
					dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
				}
			}
		}
		return dp[0][len - 1];
	}

	public static int solution2(String s) {
		int len = s.length();
		int[] dp = new int[len];
		int pre = 0;
		for (int i = len - 2; i >= 0; i--) {
			for (int j = i + 1; j < len; j++) {
				int temp = dp[j];
				if (s.charAt(i) == s.charAt(j)) {
					dp[j] = pre;
				} else {
					dp[j] = Math.min(dp[j], dp[j - 1]) + 1;
				}
				pre = temp;
			}
		}
		return dp[len - 1];
	}

	public static void main(String[] args) {
		System.out.println(solution2("abcea"));
	}
}
