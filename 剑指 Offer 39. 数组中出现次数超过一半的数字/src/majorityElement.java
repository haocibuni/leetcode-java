import java.util.HashMap;

//������ ʱ�临�Ӷ�n2
//���� ʱ�临�Ӷ�nlogn �ռ临�Ӷ�logn��ջ�ռ�
class Solution_sort {
	public int majorityElement(int[] nums) {
		quickSort(nums, 0, nums.length - 1);
		return nums[nums.length / 2];
	}

	void quickSort(int[] arr, int low, int high) {
		int i, j, temp, t;
		if (low > high) {
			return;
		}
		i = low;
		j = high;
		// temp���ǻ�׼λ
		temp = arr[low];

		while (i < j) {
			// �ȿ��ұߣ���������ݼ�
			while (temp <= arr[j] && i < j) {
				j--;
			}
			// �ٿ���ߣ��������ҵ���
			while (temp >= arr[i] && i < j) {
				i++;
			}
			// ������������򽻻�
			if (i < j) {
				t = arr[j];
				arr[j] = arr[i];
				arr[i] = t;
			}

		}
		// ��󽫻�׼Ϊ��i��j���λ�õ����ֽ���
		arr[low] = arr[i];
		arr[i] = temp;
		// �ݹ�����������
		quickSort(arr, low, j - 1);
		// �ݹ�����Ұ�����
		quickSort(arr, j + 1, high);
	}

}

//��ϣ�� ʱ�临�Ӷ�n �ռ临�Ӷ�n
//����Ϊ�� ���ִ���Ϊֵ
//HashMap��containKey��put����
//entrysetʱ��ֵ�Եļ��� �������������ΪMap.entry ����������map��һ�ַ���
class Solution_hash {
	private Map<Integer, Integer> countNums(int[] nums) {
		Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
		for (int num : nums) {
			if (!counts.containsKey(num)) {
				counts.put(num, 1);
			} else {
				counts.put(num, counts.get(num) + 1);
			}
		}
		return counts;
	}

	public int majorityElement(int[] nums) {
		Map<Integer, Integer> counts = countNums(nums);

		Map.Entry<Integer, Integer> majorityEntry = null;
		for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
			if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
				majorityEntry = entry;
			}
		}

		return majorityEntry.getKey();
	}
}

//Ħ��ͶƱ�� ʱ�临�Ӷ�n �ռ临�Ӷ�1
//����Ʊ��Ϊ+1 ������Ʊ��Ϊ-1 �����������ֵ�Ʊ��һ������0
//��ǰi������Ʊ����Ϊ0 ��������ֵ�Ʊ����һ������0
class Solution_vote {

	public int majorityElement(int[] nums) {
		int votes = 0, x = 0, count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (votes == 0) {
				x = nums[i];
			}
			votes += nums[i] == x ? 1 : -1;
		}
//		�ж������ĳ����Ƿ�������鳤�ȵ�һ��
		for (int i = 0; i < nums.length; i++) {
			if (x == nums[i]) {
				count++;
			}
		}
		return count > nums.length / 2 ? x : 0;
	}
}
