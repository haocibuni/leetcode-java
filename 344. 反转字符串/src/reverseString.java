//˫ָ����ʱ������ ʱ�临�Ӷ�n �ռ临�Ӷ�1
//ͨ����ʱ��������������
class Solution_temp {
	public void reverseString(char[] s) {
		int left = 0;
		int right = s.length - 1;
		while (left < right) {
			char temp = s[left];
			s[left] = s[right];
			s[right] = temp;
			left++;
			right--;
		}
	}
}

//˫ָ��������㷨 ʱ�临�Ӷ�n �ռ临�Ӷ�1
//ͨ�����������������������
class Solution_or {
	public void reverseString(char[] s) {
		int left = 0;
		int right = s.length - 1;
		while (left < right) {
			s[left] ^= s[right];
			s[right] ^= s[left];
			s[left] ^= s[right];
			left++;
			right--;
		}
	}
}