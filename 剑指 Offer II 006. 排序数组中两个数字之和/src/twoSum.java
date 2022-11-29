class Solution {
	public int[] twoSum(int[] numbers, int target) {
		int left = 0, right = numbers.length - 1;
		int sum;
		while (left < right) {
			sum = numbers[left] + numbers[right];
			if (sum > target) {
				right--;
			} else if (sum < target) {
				left++;
			} else {
				return new int[] { left, right };
			}
		}
		return new int[] {};

	}
}