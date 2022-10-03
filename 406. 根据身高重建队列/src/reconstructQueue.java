import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
	public int[][] reconstructQueue(int[][] people) {
//		�Ȱ�h�Ӹߵ������� ����h��ͬ��id�ӵ͵�������
		Arrays.sort(people, new Comparator<int[]>() {
			public int compare(int[] person1, int[] person2) {
				if (person1[0] != person2[0]) {
					return person2[0] - person1[0];
				} else {
					return person1[1] - person2[1];
				}
			}
		});
//		�����˳����к�id���в���
		List<int[]> ans = new ArrayList<int[]>();
		for (int[] person : people) {
//			indexΪ����λ�ã���ǰռ�е�Ԫ�ػ�������
			ans.add(person[1], person);

		}
		return ans.toArray(new int[ans.size()][]);
	}
}