//迭代法 时间复杂度为n
class Solution_iter {
	public int minArray(int[] numbers) {
		int min = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] < numbers[i - 1]) {
				return numbers[i];
			}
		}
		return min;
	}
}

//二分查找法 时间复杂度logn
//因为low+high在low和high特别大的时候可能会造成溢出，使用减法避免了溢出发生
class Solution_dichotomy {
	public int minArray(int[] numbers) {
		int left = 0;
		int right = numbers.length - 1;

		while (left < right) {
			int mid = left + (right - left) / 2;
			if (numbers[mid] < numbers[right]) {
				right = mid;
			} else if (numbers[mid] > numbers[right]) {
				left = mid + 1;
			} else {
				right = right - 1;
			}

		}
		return numbers[left];
	}
}