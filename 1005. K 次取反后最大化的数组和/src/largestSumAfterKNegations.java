import java.util.Arrays;

//贪心算法
class Solution {
	public int largestSumAfterKNegations(int[] A, int K) {
//		如果数组长度为1，则若反转偶数次则为本身，若反转奇数次则为相反数
		if (A.length == 1)
			return K % 2 == 0 ? A[0] : -A[0];
//		自小到大排序
		Arrays.sort(A);
//		数组和
		int sum = 0;
//		数组下标
		int idx = 0;
//		反转次数
		for (int i = 0; i < K; i++) {
//			最大的负数反转，需要限制i的次数，若i>=A.length-1,则idx可能会超限
			if (i < A.length - 1 && A[idx] < 0) {
				A[idx] = -A[idx];
//				若当前值大于下一个值的绝对值则下标++，下标最后位于最小的数
				if (A[idx] >= Math.abs(A[idx + 1]))
					idx++;
//				判断下一个
				continue;
			}
//			最小的正数反转
			A[idx] = -A[idx];
		}
//      求和
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
		}
		return sum;
	}
}