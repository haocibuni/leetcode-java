class Solution {
	public int balancedStringSplit(String s) {
		char[] sChars = s.toCharArray();
		int count = 0;
		int flag = 0;
		for (int i = 0; i < sChars.length; i++) {
			if (sChars[i] == 'L') {
				flag++;
			} else if (sChars[i] == 'R') {
				flag--;
			}
			if (flag == 0) {
				count++;
			}
		}
		return count;
	}
}