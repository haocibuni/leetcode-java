import java.util.Arrays;
import java.util.HashMap;

//��ϣ���Ϸ�
class Solution1 {
	public int[] smallerNumbersThanCurrent(int[] nums) {
//		�����ϣӳ��
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		int[] res = new int[nums.length];
//		�����鸴�ƽ������򣬲���ֱ������
		res = Arrays.copyOf(nums, nums.length);
		Arrays.sort(res);
//		��ֵ���±���ӵ�ӳ��
		for (int i = 0; i < res.length; i++) {
//			��С���������������
			if (!hashMap.containsKey(res[i])) {
				hashMap.put(res[i], i);
			}

		}
//		��ȡnums��ֵ��Ӧ���±�
		for (int i = 0; i < res.length; i++) {
			res[i] = hashMap.get(nums[i]);
		}

		return res;

	}
}

//������
//˫��ѭ�� ʱ�临�Ӷ�n2
class Solution {
	public int[] smallerNumbersThanCurrent(int[] nums) {
		int[] res = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			res[i] = 0;
			for (int j = 0; j < nums.length; j++) {
				if (nums[j] < nums[i]) {
					res[i]++;
				}
			}
		}
		return res;

	}
}