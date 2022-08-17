//反转两次法 时间复杂度n 空间复杂度1
class Solution {
	/**
	 * 思路： ①反转字符串 "the sky is blue " => " eulb si yks eht" ②遍历 " eulb si yks
	 * eht"，每次先对某个单词进行反转再移位 这里以第一个单词进行为演示：" eulb si yks eht" ==反转=> " blue si yks
	 * eht" ==移位=> "blue si yks eht"
	 */
	public String reverseWords(String s) {
		// 步骤1：字符串整体反转（此时其中的单词也都反转了）
		char[] initialArr = s.toCharArray();
		reverse(initialArr, 0, s.length() - 1);
		int k = 0;
		for (int i = 0; i < initialArr.length; i++) {
//			跳过单词前的空格，tempcur为单词开始的索引
			if (initialArr[i] == ' ') {
				continue;
			}
//			跳过对应的单词，i为获取单词最后的索引
			int tempCur = i;
			while (i < initialArr.length && initialArr[i] != ' ') {
				i++;
			}
//			遍历从单词的开始到结束
			for (int j = tempCur; j < i; j++) {
//				首先对指定范围内的单词进行反转
				if (j == tempCur) { // 步骤二：二次反转
					reverse(initialArr, tempCur, i - 1);// 对指定范围字符串进行反转，不反转从后往前遍历一个个填充有问题
				}
				// 将反转后的字母添加到对应的位置
				initialArr[k++] = initialArr[j];
				if (j == i - 1) { // 遍历结束
					// 避免越界情况，例如=> "asdasd df f"，不加判断最后就会数组越界
					if (k < initialArr.length) {
						initialArr[k++] = ' ';
					}
				}
			}
		}
		if (k == 0) {
			return "";
		} else {
			// 参数三：以防出现如"asdasd df f"=>"f df asdasd"正好凑满不需要省略空格情况
			return new String(initialArr, 0, (k == initialArr.length) && (initialArr[k - 1] != ' ') ? k : k - 1);
		}
	}

	public void reverse(char[] chars, int begin, int end) {
		for (int i = begin, j = end; i < j; i++, j--) {
			chars[i] ^= chars[j];
			chars[j] ^= chars[i];
			chars[i] ^= chars[j];
		}
	}
}