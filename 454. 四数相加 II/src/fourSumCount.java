import java.util.HashMap;
import java.util.Map;

//��ϣӳ�䷨ ʱ�临�Ӷ�n2 �ռ临�Ӷ�n
//key��ʾǰ��������ĸ���֮�ͣ�value��ʾ����֮�͵ĸ���
//Ȼ��������������ĸ���֮�͵��෴����
//��֤�Ƿ������hashmap��
class Solution {
	public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
		Map<Integer, Integer> hasMap = new HashMap<Integer, Integer>();
		int sum;
		int res = 0;
		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				sum = nums1[i] + nums2[j];
				if (hasMap.containsKey(sum)) {
					hasMap.put(sum, hasMap.get(sum) + 1);
				} else {
					hasMap.put(sum, 1);
				}
			}
		}
		for (int i = 0; i < nums3.length; i++) {
			for (int j = 0; j < nums4.length; j++) {
				sum = -(nums3[i] + nums4[j]);
				if (hasMap.containsKey(sum)) {
					res += hasMap.get(sum);
				}
			}
		}
		return res;
	}
}