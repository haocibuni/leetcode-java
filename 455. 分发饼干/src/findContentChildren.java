import java.util.Arrays;

class Solution {
	public int findContentChildren(int[] g, int[] s) {
//		对胃口g和饼干s进行从小到大排序
		Arrays.sort(g);
		Arrays.sort(s);
//		学生下标
		int index = 0;
//		喂饱学生的数量
		int count = 0;
//		小饼干先喂给小胃口
		for (int i = 0; i < s.length && index < g.length; i++) {
			if (g[index] <= s[i]) {
				index++;
				count++;
			}
		}
		return count;
	}
}