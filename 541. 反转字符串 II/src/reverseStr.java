//ģ�ⷨ ʱ�临�Ӷ�n �ռ临�Ӷ�n
//ͨ�����������Ӵ����з�ת
class Solution {
	public String reverseStr(String s, int k) {
		char[] res = s.toCharArray();
		int n = s.length();
		for (int i = 0; i < res.length; i = i + 2 * k) {
			reverse(res, i, Math.min(i + k, n) - 1);
		}
//		������ת��Ϊ�ַ���
		return new String(res);
	}

	public void reverse(char[] arr, int left, int right) {
		while (left < right) {
			char temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}
}