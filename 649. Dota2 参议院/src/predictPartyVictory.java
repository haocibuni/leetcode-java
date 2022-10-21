class Solution {
	public String predictPartyVictory(String senate) {
		char[] senateChars = senate.toCharArray();
//		相互抵消，前面抵消后面
		int flag = 0;
//		表示是否存在
		boolean R = true, D = true;
//		只要两个同时存在就不断循环
		while (R && D) {
			R = false;
			D = false;
			for (int i = 0; i < senateChars.length; i++) {
//				若为r
				if (senateChars[i] == 'R') {
//					前面有d，则改位置设为0，表示跳过
					if (flag < 0) {
//						设为空第二轮跳过
						senateChars[i] = 0;
//                  若前面没有d，则该位置存在r
					} else {
						R = true;

					}
//					有d：d和r抵消，无d：增加r数量
					flag++;

				}
				if (senateChars[i] == 'D') {
					if (flag > 0) {
						senateChars[i] = 0;
					} else {
						D = true;
						flag--;
					}

				}
			}
//			for循环后判断 是否都存在，若都存在则遍历存在的字符
		}
		return R == true ? "Radiant" : "Dire";

	}
}