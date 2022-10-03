class Solution {
	public int canCompleteCircuit(int[] gas, int[] cost) {
//		当前剩余油量总和
		int curSum = 0;
//		加油站总共剩余油量
		int totalSum = 0;
		int index = 0;
		for (int i = 0; i < gas.length; i++) {
			curSum += gas[i] - cost[i];
			totalSum += gas[i] - cost[i];
			if (curSum < 0) {
//				下标转向下一个加油站，并重置当前剩余油量总和
				index = (i + 1) % gas.length;
				curSum = 0;
			}
		}
		if (totalSum < 0)
			return -1;
		return index;
	}
}