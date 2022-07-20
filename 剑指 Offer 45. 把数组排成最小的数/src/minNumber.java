import java.util.ArrayList;
import java.util.Comparator;

//��ַ� ���� ÿ�����ֲ��ܲ� ��20���ܱ�Ϊ02
class Solution {
	public String minNumber(int[] nums) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		int i = 0;
		int num;
		for (int j = 0; j < nums.length; j++) {
			while (nums[j] != 0) {
				num = nums[j] % 10;
				nums[j] = nums[j] / 10;
				arrayList.add(num);
			}
		}
		arrayList.sort(Comparator.naturalOrder());
		boolean flag = false;
		int j;
		for (j = 0; j < arrayList.size(); j++) {
			if (arrayList.get(j) == 0 && arrayList.get(j + 1) != 0) {
				flag = true;
				break;
			}
		}
		StringBuilder res = new StringBuilder();
		if (flag) {
			res.append(arrayList.get(j + 1));
			for (int k = 0; k <= j; k++) {
				res.append(0);
			}
			for (int k = j + 2; k < arrayList.size(); k++) {
				res.append(arrayList.get(k));
			}
		} else {
			for (int k = 0; k < arrayList.size(); k++) {
				res.append(arrayList.get(k));
			}
		}

		return res.toString();

	}
}

//�Զ������� ʱ�临�Ӷ�nlogn �ռ临�Ӷ�n
//ͨ���Զ�����������ȡ��ȷ�Ĵ���
//x+y��y+x��Ƚ���ȷ��x��y���ҷ�������
class Solution_sort {
	public String minNumber(int[] nums) {
//		����������ת��λ�ַ�������
		String[] strings = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			strings[i] = String.valueOf(nums[i]);
		}
//		���ַ��������������
		quicksort(strings, 0, nums.length - 1);
//		���ַ�������ͨ��stringbuilder�������ӷ���
		StringBuilder res = new StringBuilder();
		for (String str : strings) {
			res.append(str);
		}
		return res.toString();

	}

	void quicksort(String[] strings, int left, int right) {
//		�ݹ�����
		if (right <= left) {
			return;
		}

		int i = left, j = right;
//		�����ڱ��ַ���
		String temp = strings[i];
//		һ�ε�������
		while (i < j) {
			while ((strings[j] + strings[left]).compareTo(strings[left] + strings[j]) >= 0 && i < j) {
				j--;
			}
			while ((strings[i] + strings[left]).compareTo(strings[left] + strings[i]) <= 0 && i < j) {
				i++;
			}
			temp = strings[i];
			strings[i] = strings[j];
			strings[j] = temp;
		}
		strings[i] = strings[left];
		strings[left] = temp;
		quicksort(strings, left, i - 1);
		quicksort(strings, i + 1, right);
	}

}
