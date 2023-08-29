//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
//
// Related Topics 字符串 👍 542 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                str.append("  ");
            }
        }
        if (str.length() == 0) {
            return s;
        }
        int left = s.length() - 1;
        s = s + str.toString();
        int right = s.length() - 1;
        char[] res = s.toCharArray();
//        此处可变
        while (left < right) {
            if (res[left] == ' ') {
                res[right--] = '0';
                res[right--] = '2';
                res[right] = '%';
            } else {
                res[right] = res[left];
            }
            left--;
            right--;
        }
        return new String(res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
