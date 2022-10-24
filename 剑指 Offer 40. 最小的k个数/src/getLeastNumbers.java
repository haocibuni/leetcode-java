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
//		��ֹ����
		if (l >= r) {
			return;
		}
//		���±�����±�
		int i = l, j = r;
		while (i < j) {
//			һ���ñ�����С������󽻻�
//			�ȴ��������ұ�����С����
			while (i < j && arr[j] >= arr[l]) {
				j--;
			}
//			�ٴ��������ұ���������
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

//		���±�����±�
		int i = l, j = r;
		while (i < j) {
//			һ���ñ�����С������󽻻�
//			�ȴ��������ұ�����С����
			while (i < j && arr[j] >= arr[l]) {
				j--;
			}
//			�ٴ��������ұ���������
			while (i < j && arr[i] <= arr[l]) {
				i++;
			}
			swap(arr, i, j);
		}
		swap(arr, l, i);
//		����׼�����±����k����ݹ�ǰ�����
		if (i > k) {
			return quicksort(arr, k, l, i - 1);
		}
//		����׼�����±�С��k����ݹ�������
		if (i < k) {
			return quicksort(arr, k, i + 1, r);
		}
//		��i==k��iǰ����i���Ȼ�׼��С������ֱ�ӷ���
		return Arrays.copyOf(arr, k);

	}

	public void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
}