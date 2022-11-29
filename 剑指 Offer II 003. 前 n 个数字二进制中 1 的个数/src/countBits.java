//Î»ÔËËã·¨
class Solution {
	public int[] countBits(int n) {
		int[] res = new int[n + 1];
		int t;
		for (int i = 0; i <= n; i++) {
			res[i] = 0;
			t = i;

			while (t != 0) {
				t = t & (t - 1);
				res[i]++;

			}

		}
		return res;

	}
}

class Solution1 {
	public int[] countBits(int n) {
		int[] res = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			if (i % 2 == 0) {
				res[i] = res[i / 2];
			} else {
				res[i] = res[i - 1] + 1;
			}
		}
		return res;
	}
}

class Solution2 {
	public int[] countBits(int n) {
		int[] res = new int[n + 1];
		int hight = 0;
		for (int i = 1; i <= n; i++) {
			if ((i & (i - 1)) == 0) {
				hight = i;
			}
			res[i] = res[i - hight] + 1;
		}
		return res;
	}
}