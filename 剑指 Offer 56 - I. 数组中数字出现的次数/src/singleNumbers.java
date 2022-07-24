import java.util.HashSet;

//��ϣ���Ϸ� ʱ�临�Ӷ�n �ռ临�Ӷ�n
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

//������㷨 ʱ�临�Ӷ�n �ռ临�Ӷ�1
//�������Ԫ�ؽ���������㣬��ʼΪ0����Ϊ0������������������㶼��������
//����������㽻���ɣ��������ó���ֵΪx��y�����������ֵ
//x��y�����������ֵ���϶���1���ڣ�ͨ������Ԫ�ض����ֵ���������� �ҵ����λ��1 ���������Ĳ�ͬ
//��Ϊ����ÿһλֻ��0��1����ѡ����Կɸ������λ��1�������Ϊ����������
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
