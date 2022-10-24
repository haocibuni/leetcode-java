import java.util.Arrays;

class Solution1 {
	public int[] getLeastNumbers(int[] arr, int k) {
		Arrays.sort(arr);
		int[] res = new int[k];
		for (int i = 0; i < res.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}
}

class Solution2 {
	public int[] getLeastNumbers(int[] arr, int k) {
		quicksort(arr, 0, arr.length - 1);

		return Arrays.copyOf(arr, k);
	}

	public void quicksort(int[] arr, int l, int r) {
//		终止条件
		if (l >= r) {
			return;
		}
//		左下标和右下标
		int i = l, j = r;
		while (i < j) {
//			一定得比最左小才能最后交换
//			先从右往左找比最左小的数
			while (i < j && arr[j] >= arr[l]) {
				j--;
			}
//			再从左往右找比最左大的数
			while (i < j && arr[i] <= arr[l]) {
				i++;
			}

			swap(arr, i, j);
		}
		swap(arr, l, i);
		quicksort(arr, l, i - 1);
		quicksort(arr, i + 1, r);
	}

	public void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
}

class Solution {
	public int[] getLeastNumbers(int[] arr, int k) {
		if (k >= arr.length) {
			return arr;
		}
		return quicksort(arr, k, 0, arr.length - 1);

	}

	public int[] quicksort(int[] arr, int k, int l, int r) {

//		左下标和右下标
		int i = l, j = r;
		while (i < j) {
//			一定得比最左小才能最后交换
//			先从右往左找比最左小的数
			while (i < j && arr[j] >= arr[l]) {
				j--;
			}
//			再从左往右找比最左大的数
			while (i < j && arr[i] <= arr[l]) {
				i++;
			}
			swap(arr, i, j);
		}
		swap(arr, l, i);
//		若基准数字下标大于k，则递归前面的数
		if (i > k) {
			return quicksort(arr, k, l, i - 1);
		}
//		若基准数字下标小于k，则递归后面的数
		if (i < k) {
			return quicksort(arr, k, i + 1, r);
		}
//		若i==k则i前面有i个比基准数小的数，直接返回
		return Arrays.copyOf(arr, k);

	}

	public void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
}