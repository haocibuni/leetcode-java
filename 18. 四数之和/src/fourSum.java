import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//˫ָ�뷨 ʱ�临�Ӷ�n3 
//����������֮�ͣ��ȶ������������
//i��jΪѡ�������������±꣬leftΪ���ڵ���߽磬rightΪ���ڵ��ұ߽�
//��nums[i]>target���� num[i]>0ʱ���ؽ��������target=-10 nums[i]=-6 nums[i+1}=-4 ����˵��numsΪ����ʱ���ܻ�ﵽtarget;
//��nums[i]=nums[i-1] ����
//��nums[j]=nums[j-1] ����
//s<targetʱ left=left+1 �����ظ���nums[left]
//s>0ʱ right=right-1 �����ظ���nums[right]
//s=0ʱ��¼i,j,left,right ��������Ӧ��left��right
class Solution {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < nums.length - 3; i++) {
			if (nums[i] > target && nums[i] > 0) {
				return res;
			}
			if (i > 0 && nums[i - 1] == nums[i]) {
				continue;
			}
			for (int j = i + 1; j < nums.length - 2; j++) {
				if (j > i + 1 && nums[j - 1] == nums[j]) {
					continue;
				}
				int left = j + 1;
				int right = nums.length - 1;
				while (left < right) {
					long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
					if (sum < target) {
						while (left < right && nums[left] == nums[++left])
							;
					} else if (sum > target) {
						while (left < right && nums[right] == nums[--right])
							;
					} else {
						res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
						while (left < right && nums[left] == nums[++left])
							;
						while (left < right && nums[right] == nums[--right])
							;
					}
				}
			}
		}
		return res;
	}
}