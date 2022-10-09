import java.util.HashSet;
import java.util.List;

class Solution {
	public boolean wordBreak(String s, List<String> wordDict) {
//		�������ϣ�ȥ���ظ�����Ʒ
		HashSet<String> set = new HashSet<>(wordDict);
//		����dp���飬��ʾ�ַ�������Ϊi�Ļ����Ƿ�ɲ��Ϊ��Ʒ
		boolean[] valid = new boolean[s.length() + 1];
//		����ʼ״̬����Ϊtrue
		valid[0] = true;
//		��������
		for (int i = 1; i <= s.length(); i++) {
//			������Ʒ����״̬Ϊfalse�ı���
			for (int j = 0; j < i && !valid[i]; j++) {
//				����Ʒ�ְ������ַ�����ǰj���ַ���Ϊtrue������iΪtrue
				if (set.contains(s.substring(j, i)) && valid[j]) {
					valid[i] = true;
				}
			}
		}

		return valid[s.length()];
	}
}