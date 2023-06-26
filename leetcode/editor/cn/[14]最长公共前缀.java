//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
//
// Related Topics 字典树 字符串 👍 2817 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int min = Integer.MAX_VALUE;
        for (String str : strs){
            if (str.length()<min){
                min = str.length();
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i<min;i++){
            for (int j=1;j<strs.length;j++){
                if (strs[j].charAt(i)!=strs[j-1].charAt(i)){
                    return stringBuilder.toString();
                }
            }
            stringBuilder.append(strs[0].charAt(i));
        }
        return stringBuilder.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
