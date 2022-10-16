//˫ָ�뷨
class Solution {
	public boolean validMountainArray(int[] arr) {
//		������С��2 �϶�����������
		if (arr.length <= 2) {
			return false;
		}
//		��������ָ���±�
		int left = 0;
		int right = arr.length - 1;
//		�߽�����
		while (left + 1 < arr.length - 1 && arr[left] < arr[left + 1]) {
			left++;
		}
		while (right > 0 && arr[right - 1] > arr[right]) {
			right--;
		}
//		��ͬһλ�ã��Ҳ����������������
		if (left == right && left != 0 && right != arr.length - 1) {
			return true;
		}
		return false;
	}
}