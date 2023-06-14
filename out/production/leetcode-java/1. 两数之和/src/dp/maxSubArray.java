package dp;

public class maxSubArray {
	public static int solution(int[] nums) {

		int a = nums[0], b = 0;
		int res = nums[0];
		for (int i = 1; i < nums.length; i++) {
			b = Math.max(nums[i], nums[i] + a);
			a = b;
			res = Math.max(res, b);
		}

		return res;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] { -3, 1, 3, -1, 2, -4, 2 }));
	}
}
