import java.util.HashSet;

//穷举法 时间复杂度o2
class Solution_exhaustion {
	private Integer integer;

	public int findRepeatNumber(int[] nums) {
		for (int i = 0; i < nums.length; i = i + 1) {
			for (int j = i + 1; j < nums.length; j = j + 1) {
				if (nums[i] == nums[j]) {
					return nums[i];
				} else {
					continue;
				}

			}

		}
		integer = (Integer) null;
		return integer;
	}
}

//哈希集合法 时间复杂度n 空间复杂度n；HashSet集合
class Solution_set {

	public int findRepeatNumber(int[] nums) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int num : nums) {
			if (!set.add(num)) {
				return num;
			}
		}
		return -1;
	}
}

//原地交换法 时间复杂度n 空间复杂度1 交换元素时等号两边不能同时出现i
class Solution_swap {

	public static int findRepeatNumber(int[] nums) {
		int i = 0;
		while (i < nums.length) {
			if (nums[i] == i) {
				i++;
				continue;
			}
			if (nums[nums[i]] == nums[i]) {
				return nums[i];
			} else {
				int temp = nums[i];
				nums[i] = nums[temp];
				nums[temp] = temp;
			}

		}
		return -1;

	}

	public static void main(String[] args) {
		int[] a = { 2, 3, 1, 0, 2, 5, 3 };
		int b;
		b = findRepeatNumber(a);
		System.out.println(b);
	}
}
