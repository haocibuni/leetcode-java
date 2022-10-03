class Solution {
	public int canCompleteCircuit(int[] gas, int[] cost) {
//		��ǰʣ�������ܺ�
		int curSum = 0;
//		����վ�ܹ�ʣ������
		int totalSum = 0;
		int index = 0;
		for (int i = 0; i < gas.length; i++) {
			curSum += gas[i] - cost[i];
			totalSum += gas[i] - cost[i];
			if (curSum < 0) {
//				�±�ת����һ������վ�������õ�ǰʣ�������ܺ�
				index = (i + 1) % gas.length;
				curSum = 0;
			}
		}
		if (totalSum < 0)
			return -1;
		return index;
	}
}