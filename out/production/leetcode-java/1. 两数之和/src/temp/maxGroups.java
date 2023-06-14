package temp;

public class maxGroups {
	public static void main(String[] args) {
		int[] nums = { 3, 2, 4, 3, 6 };
		int n = nums.length;
		System.out.println("原数组为：");
		for (int i : nums) {
			System.out.println(i + " ");
		}
		getMax(nums, n);
	}

	public static void getMax(int[] nums, int n) {
		int sum = 0;
		int[] temp = new int[n];
		for (int i : nums) {
			sum += i;
		}
		for (int m = n; m > 1; m--) {
			if (sum % m != 0) {
				continue;
			}
			for (int j = 0; j < n; j++) {
				temp[j] = 0;
			}
			if (test(nums, n, m, sum / m, temp, sum / m, 1)) {
				System.out.println("The Max m is:" + m);
				break;
			}

		}
	}

	public static boolean test(int[] nums, int n, int m, int groupSum, int[] temp, int total, int groupID) {
		if (total < 0) {
			return false;
		}
		if (total == 0) {
			groupID++;
			total = groupSum;
			if (groupID == m + 1) {
				return true;
			}
		}
		for (int i = 0; i < n; i++) {
			if (temp[i] != 0) {
				continue;
			}
			temp[i] = groupID;
			if (test(nums, n, m, groupSum, temp, total - nums[i], groupID)) {
				return true;
			}
			temp[i] = 0;
		}
		return false;
	}
}
