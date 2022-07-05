import java.util.HashSet;

//��ٷ� ʱ�临�Ӷ�o2
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

//��ϣ���Ϸ� ʱ�临�Ӷ�n �ռ临�Ӷ�n��HashSet����
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

//ԭ�ؽ����� ʱ�临�Ӷ�n �ռ临�Ӷ�1 ����Ԫ��ʱ�Ⱥ����߲���ͬʱ����i
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
