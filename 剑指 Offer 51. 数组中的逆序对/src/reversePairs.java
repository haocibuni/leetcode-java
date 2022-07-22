//������ ʱ�临�Ӷ�n2
class Solution_force {
	public int reversePairs(int[] nums) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] > nums[j]) {
					count++;
				}
			}
		}
		return count;

	}
}

//�鲢���� ʱ�临�Ӷ�nlogn �ռ临�Ӷ�n
class Solution_mergesort {
	int[] nums, temp;

	public int reversePairs(int[] nums) {
		this.nums = nums;
		temp = new int[nums.length];
		return mergesort(0, nums.length - 1);

	}

//  �鲢����
//	��ֹ����:�����������ڵ���������ʱ,��ֹ����
//	���������ص�m���л��� left-m m+1-right
//	�ݴ�����left-right����ʱ����temp
//	��������������,ָ��iָ����������,ָ��jָ����������,ָ��kָ��nums����
//	��iָ����������,������������Ѿ������,ֻ����������鵽��ǰλ��
//	��jָ����right+1,������������Ѿ�������,ֻ����������鵽��ǰλ��
//	��iָ���Ԫ��С�ڵ���jָ���Ԫ��,�����iָ���Ԫ�ص���ǰλ��
//	��iָ���Ԫ�ش���jָ���Ԫ��,�����jָ���Ԫ�ص���ǰλ��
//  ��Ϊ���Ҷ˵�Ԫ��Ϊ��������С��,�����������б�������Ԫ�ش������Ϊm+1-i
	public int mergesort(int left, int right) {
		if (left >= right) {
			return 0;
		}
		int m = (left + right) / 2;
		int res = mergesort(left, m) + mergesort(m + 1, right);
		int i = left, j = m + 1;
		for (int k = left; k <= right; k++) {
			temp[k] = nums[k];
		}
		for (int k = left; k <= right; k++) {
			if (i == m + 1) {
				nums[k] = temp[j++];
			} else if (j == right + 1) {
				nums[k] = temp[i++];
			} else if (temp[i] <= temp[j]) {
				nums[k] = temp[i++];
			} else {
				nums[k] = temp[j++];
				res = res + m - i + 1;
			}
		}
		return res;
	}
}