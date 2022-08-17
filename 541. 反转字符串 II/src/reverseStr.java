//模拟法 时间复杂度n 空间复杂度n
//通过遍历各个子串进行反转
class Solution {
	public String reverseStr(String s, int k) {
		char[] res = s.toCharArray();
		int n = s.length();
		for (int i = 0; i < res.length; i = i + 2 * k) {
			reverse(res, i, Math.min(i + k, n) - 1);
		}
//		将数组转化为字符串
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