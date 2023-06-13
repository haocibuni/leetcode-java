package dp;

public class longestPalindromeSubseq {
	public static int soluton1(String s) {
		int len = s.length();
		int[][] dp = new int[len][len];
		for (int i = 0; i < len; i++) {
			dp[i][i] = 1;
		}
		for (int i = len - 2; i >= 0; i--) {
			for (int j = i + 1; j < len; j++) {
				if (s.charAt(i) == s.charAt(j)) {
					dp[i][j] = dp[i + 1][j - 1] + 2;
				} else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[0][len - 1];
	}

	public static int soluton2(String s) {
		int len = s.length();
		int[] dp = new int[len];
		for (int i = 0; i < len; i++) {
			dp[i] = 1;
		}
		int pre = 0;
		for (int i = len - 2; i >= 0; i--) {
			for (int j = i + 1; j < len; j++) {
				int temp = dp[j];
				if (s.charAt(i) == s.charAt(j)) {
					dp[j] = pre + 2;
				} else {
					dp[j] = Math.max(dp[j], dp[j - 1]);
				}
				pre = temp;
			}
		}
		return dp[len - 1];
	}

	public static void main(String[] args) {
		System.out.println(soluton2("aecda"));
	}
}
