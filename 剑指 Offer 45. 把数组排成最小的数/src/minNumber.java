import java.util.ArrayList;
import java.util.Comparator;

//拆分法 错误 每个数字不能拆开 如20不能变为02
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

//自定义排序法 时间复杂度nlogn 空间复杂度n
//通过自定义排序来获取正确的次序
//x+y和y+x相比较来确定x在y的右方还是左方
class Solution_sort {
	public String minNumber(int[] nums) {
//		将整型数组转换位字符串数组
		String[] strings = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			strings[i] = String.valueOf(nums[i]);
		}
//		对字符串数组进行排序
		quicksort(strings, 0, nums.length - 1);
//		将字符串数组通过stringbuilder进行连接返回
		StringBuilder res = new StringBuilder();
		for (String str : strings) {
			res.append(str);
		}
		return res.toString();

	}

	void quicksort(String[] strings, int left, int right) {
//		递归条件
		if (right <= left) {
			return;
		}

		int i = left, j = right;
//		定义哨兵字符串
		String temp = strings[i];
//		一次迭代条件
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
