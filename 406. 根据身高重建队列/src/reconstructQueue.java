import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
	public int[][] reconstructQueue(int[][] people) {
//		先按h从高到低排序 ，若h相同则按id从低到高排序
		Arrays.sort(people, new Comparator<int[]>() {
			public int compare(int[] person1, int[] person2) {
				if (person1[0] != person2[0]) {
					return person2[0] - person1[0];
				} else {
					return person1[1] - person2[1];
				}
			}
		});
//		按身高顺序进行和id进行插入
		List<int[]> ans = new ArrayList<int[]>();
		for (int[] person : people) {
//			index为插入位置，以前占有的元素会往后排
			ans.add(person[1], person);

		}
		return ans.toArray(new int[ans.size()][]);
	}
}