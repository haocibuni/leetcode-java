//������ ʱ�临�Ӷ�Ϊn
class Solution_iter {
	public int minArray(int[] numbers) {
		int min = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] < numbers[i - 1]) {
				return numbers[i];
			}
		}
		return min;
	}
}

//���ֲ��ҷ� ʱ�临�Ӷ�logn
//��Ϊlow+high��low��high�ر���ʱ����ܻ���������ʹ�ü����������������
class Solution_dichotomy {
	public int minArray(int[] numbers) {
		int left = 0;
		int right = numbers.length - 1;

		while (left < right) {
			int mid = left + (right - left) / 2;
			if (numbers[mid] < numbers[right]) {
				right = mid;
			} else if (numbers[mid] > numbers[right]) {
				left = mid + 1;
			} else {
				right = right - 1;
			}

		}
		return numbers[left];
	}
}