//˫ָ�뷨 ʱ�临�Ӷ�n �ռ临�Ӷ�1
//��ָ��ָ��Ŀ��Ԫ�� ��ָ��ָ����µ��±�
class Solution {
	public int removeElement(int[] nums, int val) {
		int fastindex = 0;
		int slowindex;
		for (slowindex = 0; fastindex < nums.length; fastindex++) {
			if (nums[fastindex] != val) {
				nums[slowindex] = nums[fastindex];
				slowindex++;
			}
		}
		return slowindex;

	}
}