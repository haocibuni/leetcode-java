import java.util.Arrays;

class Solution {
	public int[] sortByBits(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] += gitbitCount(arr[i]) << 14;
		}
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i] & 16383;
		}
		return arr;

	}

	public int gitbitCount(int num) {
		int count = 0;
		while (num > 0) {
			num &= num - 1;
			count++;
		}
		return count;
	}
}