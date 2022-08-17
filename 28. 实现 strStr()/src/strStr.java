//�������ڷ� ʱ�临�Ӷ�mn �ռ临�Ӷ�1
class Solution_doublepoint {
	/**
	 * ���ڴ��ڻ������㷨
	 * <p>
	 * ʱ�临�Ӷȣ�O(m*n) �ռ临�Ӷȣ�O(1) ע��nΪhaystack�ĳ��ȣ�mΪneedle�ĳ���
	 */
	public int strStr(String haystack, String needle) {
		int m = needle.length();
		// �� needle �ǿ��ַ���ʱ����Ӧ������ 0
		if (m == 0) {
			return 0;
		}
//		��ģʽ�������ַ���ʱ ����-1
		int n = haystack.length();
		if (n < m) {
			return -1;
		}
//		i�����ַ����±꣬j����ģʽ���±�
		int i = 0;
		int j = 0;
		while (i < n - m + 1) {
			// �ҵ�����ĸ���
			while (i < n && haystack.charAt(i) != needle.charAt(j)) {
				i++;
			}
			// û������ĸ��ȵ�ʱ�� ����-1
			if (i == n) {
				return -1;
			}
			// ���������ַ����ж��Ƿ����
			i++;
			j++;
			while (i < n && j < m && haystack.charAt(i) == needle.charAt(j)) {
				i++;
				j++;
			}
			// ���ҵ���ģʽ��������ͷ�������±��ֵ
			if (j == m) {
				return i - j;
				// ��δ�ҵ����ַ����±귵���ϴ�jλ�ã�ģʽ���±귵��0
			} else {
				i -= j - 1;
				j = 0;
			}
		}
		return -1;
	}
}

//ǰ׺�� ʱ�临�Ӷ�mn �ռ临�Ӷ�1
class Solution_next {
	public void getNext(int[] next, String s) {
//		ǰ׺�±�j��׺�±�i
		int j = -1;
		next[0] = j;
//		��1��ʼ����
		for (int i = 1; i < s.length(); i++) {
//			��ǰ��׺���ȣ���j�±����
			while (j >= 0 && s.charAt(i) != s.charAt(j + 1)) {
				j = next[j];
			}
// 			��ǰ��׺��ȣ���j++
			if (s.charAt(i) == s.charAt(j + 1)) {
				j++;
			}
//			Ȼ���j���Ƶ�i
			next[i] = j;
//			i++
		}
	}

	public int strStr(String haystack, String needle) {
//		��ģʽ������Ϊ0�򷵻�0
		if (needle.length() == 0) {
			return 0;
		}
//      ����next���飬��С����ģʽ����С
		int[] next = new int[needle.length()];
//		��ȡnext����
		getNext(next, needle);
		int j = -1;
//		�����ַ���
		for (int i = 0; i < haystack.length(); i++) {
//			����ĸ�������ģʽ���±����next������л���
			while (j >= 0 && haystack.charAt(i) != needle.charAt(j + 1)) {
				j = next[j];
			}
//			����ĸ�����ģʽ���±�j++
			if (haystack.charAt(i) == needle.charAt(j + 1)) {
				j++;
			}
//			��j����ģʽ��β���򷵻س���
			if (j == needle.length() - 1) {
				return (i - needle.length() + 1);
			}
		}

		return -1;
	}
}