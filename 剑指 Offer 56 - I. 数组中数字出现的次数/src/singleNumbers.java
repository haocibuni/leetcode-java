import java.util.HashSet;

//哈希集合法 时间复杂度n 空间复杂度n
class Solution_hashset {
	public int[] singleNumbers(int[] nums) {
		HashSet<Integer> sites = new HashSet<Integer>();

		for (int i = 0; i < nums.length; i++) {
			if (sites.contains(nums[i])) {
				sites.remove(nums[i]);
			} else {
				sites.add(nums[i]);
			}
		}
		int[] res = sites.stream().mapToInt(Integer::intValue).toArray();
		return res;
	}
}

//异或运算法 时间复杂度n 空间复杂度1
//对数组各元素进行异或运算，初始为0，因为0与任意数进行异或运算都是数本身，
//异或运算满足交换律，所以最后得出的值为x与y两个数的异或值
//x与y两个数的异或值，肯定有1存在，通过辅助元素对异或值进行与运算 找到最低位的1 即两个数的不同
//因为各数每一位只有0与1两个选项，所以可根据最低位的1把数组分为两个子数组
class Solution_exclusive_or {
	public int[] singleNumbers(int[] nums) {
		int z = 0, m = 1, x = 0, y = 0;
		for (int num : nums) {
			z = z ^ num;
		}
		while ((m & z) == 0) {
			m <<= 1;
		}
		for (int num : nums) {
			if ((num & m) == 0) {
				x = x ^ num;
			} else {
				y = y ^ num;
			}
		}
		return new int[] { x, y };
	}
}
