//分割法，但是无法分割多个空格 如"  "
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

//替换法
class Solution_replace {
	public String replaceSpace(String s) {

		return s.replace(" ", "%20");

	}
}

//构造法， StringBuilder类；toCharArray将此字符串转换为一个新的字符数组 ；Character字符；toString将StringBuilder转化为String
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
//原地修改法，适用于c++，在c++中String为可变类型，可先修改string长度，然后倒序遍历修改
//class Solution {
//public:
//    string replaceSpace(string s) {
//        int count = 0, len = s.size();
//        // 统计空格数量
//        for (char c : s) {
//            if (c == ' ') count++;
//        }
//        // 修改 s 长度
//        s.resize(len + 2 * count);
//        // 倒序遍历修改
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
//从前遍历的话要考虑替换字符是否会抢占原来字符的问题，例如两个空格的情况，这样会出错。
//而采用从后向前遍历的话，可以确保碰到的第一个空格之后的位置不会被乱用，此后的空格可以递推，由此可以达到替换的要求。
//例如"  "