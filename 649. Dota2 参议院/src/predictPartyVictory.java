class Solution {
	public String predictPartyVictory(String senate) {
		char[] senateChars = senate.toCharArray();
//		�໥������ǰ���������
		int flag = 0;
//		��ʾ�Ƿ����
		boolean R = true, D = true;
//		ֻҪ����ͬʱ���ھͲ���ѭ��
		while (R && D) {
			R = false;
			D = false;
			for (int i = 0; i < senateChars.length; i++) {
//				��Ϊr
				if (senateChars[i] == 'R') {
//					ǰ����d�����λ����Ϊ0����ʾ����
					if (flag < 0) {
//						��Ϊ�յڶ�������
						senateChars[i] = 0;
//                  ��ǰ��û��d�����λ�ô���r
					} else {
						R = true;

					}
//					��d��d��r��������d������r����
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
//			forѭ�����ж� �Ƿ񶼴��ڣ�����������������ڵ��ַ�
		}
		return R == true ? "Radiant" : "Dire";

	}
}