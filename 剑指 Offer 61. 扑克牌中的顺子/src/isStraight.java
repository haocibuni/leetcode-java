import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//�����ӷ� ʱ�临�Ӷ�nlogn �ռ临�Ӷ�1
class Solution_sort {
	public boolean isStraight(int[] nums) {
		Arrays.sort(nums);
		int count = 0;
		int i;
		for (i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				count++;
			} else {
				break;
			}
		}
		for (int j = i + 1; j < nums.length; j++) {
			if (nums[j] == nums[j - 1] + 1) {
				continue;
			} else if (nums[j] == nums[j - 1]) {
				return false;
			} else {
				count = count - (nums[j] - nums[j - 1] - 1);
			}
		}
		if (count < 0) {
			return false;
		}
		return true;

	}
}

//���Ϸ� ʱ�临�Ӷ�n �ռ临�Ӷ�n
class Solution_set {
	public boolean isStraight(int[] nums) {
		Set<Integer> repeat = new HashSet<>();
		int max = 0, min = 14;
		for (int num : nums) {
			if (num == 0)
				continue; // ������С��
			max = Math.max(max, num); // �����
			min = Math.min(min, num); // ��С��
			if (repeat.contains(num))
				return false; // �����ظ�����ǰ���� false
			repeat.add(num); // ��Ӵ����� Set
		}
		return max - min < 5; // ����� - ��С�� < 5 ��ɹ���˳��
	}
}

//�����෨
class Solution {
	public boolean isStraight(int[] nums) {
		int joker = 0;
		Arrays.sort(nums); // ��������
		for (int i = 0; i < 4; i++) {
			if (nums[i] == 0)
				joker++; // ͳ�ƴ�С������
			else if (nums[i] == nums[i + 1])
				return false; // �����ظ�����ǰ���� false
		}
		return nums[4] - nums[joker] < 5; // ����� - ��С�� < 5 ��ɹ���˳��
	}
}
