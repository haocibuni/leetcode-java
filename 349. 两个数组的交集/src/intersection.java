import java.util.HashSet;
import java.util.Set;

//��ϣ���Ϸ� ʱ�临�Ӷ�n �ռ临�Ӷ�n
//ͨ��������ϣ��������ȡ��������Ľ��� ��һ������Ϊ��һ������Ľ���
class Solution {
	public int[] intersection(int[] nums1, int[] nums2) {
		if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
			return new int[0];
		}
		Set<Integer> set1 = new HashSet<>();
		Set<Integer> res = new HashSet<>();
		for (int i : nums1) {
			set1.add(i);
		}
		for (int i : nums2) {
			if (set1.contains(i)) {
				res.add(i);
			}
		}
		return res.stream().mapToInt(x -> x).toArray();
	}
}