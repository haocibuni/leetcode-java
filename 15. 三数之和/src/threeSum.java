import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//��ϣ���Ϸ� ʱ�临�Ӷ�n2 �ռ临�Ӷ�n
//����ѭ��ȷ��a+b Ȼ��ʹ�ù�ϣ������ȷ��-(a+b)
class Solution_hash {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
//			��a>0��ֱ���˳�ѭ��
			if (nums[i] > 0) {
				break;
			}
//			����������ͬ��aԪ��
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
//			��ϣ����
			Set<Integer> set = new HashSet<>();
//			��a����һλ��ʼѰ��b
			for (int j = i + 1; j < nums.length; j++) {
				if (j > i + 2 && nums[j] == nums[j - 1] && nums[j - 1] == nums[j - 2]) {
					continue;
				}
				int c = 0 - (nums[i] + nums[j]);
				if (set.contains(c)) {
					res.add(new ArrayList<Integer>(Arrays.asList(c, nums[i], nums[j])));
//					�������е�cԪ��
					set.remove(c);
				} else {
					set.add(nums[j]);
				}
			}
		}

		return res;

	}
}

//˫ָ�뷨 ʱ�临�Ӷ�n2 �ռ临�Ӷ�1
//�ȶ�������п���
//kΪ���ڵ���ʼλ�ã�iΪ���ڵ���߽磬jΪ���ڵ��ұ߽�
//��nums[k]>0 break;
//��nums[k]=nums[k-1] ����
//s<0ʱ i=i+1 �����ظ���nums[i]
//s>0ʱ j=j-1 �����ظ���nums[j]
//s=0ʱ��¼k,i,j
class Solution_doublepoint {
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		for (int k = 0; k < nums.length - 2; k++) {
			if (nums[k] > 0) {
				break;
			}
			if (k > 0 && nums[k] == nums[k - 1]) {
				continue;
			}
			int i = k + 1, j = nums.length - 1;
			while (i < j) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum < 0) {
					while (i < j && nums[i] == nums[++i])
						;
				} else if (sum > 0) {
					while (i < j && nums[j] == nums[--j])
						;
				} else {
					res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
					while (i < j && nums[i] == nums[++i])
						;
					while (i < j && nums[j] == nums[--j])
						;
				}
			}
		}
		return res;

	}
}