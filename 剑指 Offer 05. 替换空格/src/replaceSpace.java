//�ָ�������޷��ָ����ո� ��"  "
class Solution_split {
	public String replaceSpace(String s) {
		String[] strs = s.split(" ");
		System.out.println(strs);

		for (int i = 0; i < strs.length - 1; i++) {
			strs[i] = strs[i].concat("%20");
		}
		String newstr = strs[0];
		for (int i = 1; i < strs.length; i++) {
			newstr = newstr.concat(strs[i]);
		}
		return newstr;
	}
}

//�滻��
class Solution_replace {
	public String replaceSpace(String s) {

		return s.replace(" ", "%20");

	}
}

//���취�� StringBuilder�ࣻtoCharArray�����ַ���ת��Ϊһ���µ��ַ����� ��Character�ַ���toString��StringBuilderת��ΪString
class Solution_builder {
	public String replaceSpace(String s) {
		StringBuilder strbuder = new StringBuilder();
		for (Character c : s.toCharArray()) {
			if (c == ' ') {
				strbuder.append("%20");
			} else {
				strbuder.append(c);
			}
		}
		return strbuder.toString();
	}
}
//ԭ���޸ķ���������c++����c++��StringΪ�ɱ����ͣ������޸�string���ȣ�Ȼ��������޸�
//class Solution {
//public:
//    string replaceSpace(string s) {
//        int count = 0, len = s.size();
//        // ͳ�ƿո�����
//        for (char c : s) {
//            if (c == ' ') count++;
//        }
//        // �޸� s ����
//        s.resize(len + 2 * count);
//        // ��������޸�
//        for(int i = len - 1, j = s.size() - 1; i < j; i--, j--) {
//            if (s[i] != ' ')
//                s[j] = s[i];
//            else {
//                s[j - 2] = '%';
//                s[j - 1] = '2';
//                s[j] = '0';
//                j -= 2;
//            }
//        }
//        return s;
//    }
//};
//��ǰ�����Ļ�Ҫ�����滻�ַ��Ƿ����ռԭ���ַ������⣬���������ո����������������
//�����ôӺ���ǰ�����Ļ�������ȷ�������ĵ�һ���ո�֮���λ�ò��ᱻ���ã��˺�Ŀո���Ե��ƣ��ɴ˿��Դﵽ�滻��Ҫ��
//����"  "