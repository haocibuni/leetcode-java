import java.util.Arrays;

//̰���㷨
class Solution {
	public int largestSumAfterKNegations(int[] A, int K) {
//		������鳤��Ϊ1��������תż������Ϊ��������ת��������Ϊ�෴��
		if (A.length == 1)
			return K % 2 == 0 ? A[0] : -A[0];
//		��С��������
		Arrays.sort(A);
//		�����
		int sum = 0;
//		�����±�
		int idx = 0;
//		��ת����
		for (int i = 0; i < K; i++) {
//			���ĸ�����ת����Ҫ����i�Ĵ�������i>=A.length-1,��idx���ܻᳬ��
			if (i < A.length - 1 && A[idx] < 0) {
				A[idx] = -A[idx];
//				����ǰֵ������һ��ֵ�ľ���ֵ���±�++���±����λ����С����
				if (A[idx] >= Math.abs(A[idx + 1]))
					idx++;
//				�ж���һ��
				continue;
			}
//			��С��������ת
			A[idx] = -A[idx];
		}
//      ���
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
		}
		return sum;
	}
}