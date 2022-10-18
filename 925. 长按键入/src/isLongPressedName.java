//错误
class Solution1 {
	public boolean isLongPressedName(String name, String typed) {
		char[] nameChars = name.toCharArray();
		char[] typedChars = typed.toCharArray();
		int j = 0;
		for (int i = 0; i < nameChars.length; i++) {
			if (nameChars[i] != typedChars[j]) {
				return false;
			}
			if (nameChars[i] == nameChars[i + 1] && i < nameChars.length - 1) {
				i++;
				continue;
			}
			while (nameChars[i] == typedChars[j] && j < typedChars.length && i < nameChars.length) {
				j++;
			}
		}
		return true;

	}
}

class Solution {
	public boolean isLongPressedName(String name, String typed) {
		char[] nameChars = name.toCharArray();
		char[] typedChars = typed.toCharArray();
		int i = 0, j = 0, n = nameChars.length, m = typedChars.length;
		while (i < n && j < m) {
			if (nameChars[i] == typedChars[j]) {
				i++;
				j++;
			} else {
				if (j == 0) {
					return false;
				}
//				"kikcxmvzi"
//				"kiikcxxmmvvzz"
//				跳过重复字符,边界为m-1，因为j要加1，必须满足加1后小于m
				while (typedChars[j] == typedChars[j - 1] && j < m - 1) {
					j++;
				}
				if (nameChars[i] == typedChars[j]) {
					j++;
					i++;
				} else {
					return false;
				}
			}
		}
		if (i < n) {
			return false;
		}
		while (j < m) {
			if (typedChars[j] == typedChars[j - 1]) {
				j++;
			} else {
				return false;
			}
		}
		return true;

	}
}