//双指针临时变量法 时间复杂度n 空间复杂度1
//通过临时变量来交换变量
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

//双指针异或运算法 时间复杂度n 空间复杂度1
//通过三次异或运算来交换变量
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