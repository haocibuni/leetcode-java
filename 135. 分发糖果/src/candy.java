//贪心算法
class Solution {
	public int candy(int[] ratings) {
//		数量数组
		int[] candyVec = new int[ratings.length];
//		默认给第一个一个糖果
		candyVec[0] = 1;
//		从左向右遍历
		for (int i = 1; i < ratings.length; i++) {
//			若当前大于上一个得分，则比上一个多一个糖果，否则给1个
			candyVec[i] = (ratings[i] > ratings[i - 1]) ? candyVec[i - 1] + 1 : 1;

		}
//		从右往左遍历
		for (int i = ratings.length - 2; i >= 0; i--) {
//			如果当前大于上一个得分
			if (ratings[i] > ratings[i + 1]) {
//				则选取上一次赋值和上一个得分加一的最大值
				candyVec[i] = Math.max(candyVec[i], candyVec[i + 1] + 1);
			}
		}
//		累加
		int result = 0;
		for (int num : candyVec) {
			result += num;
		}
		return result;

	}
}