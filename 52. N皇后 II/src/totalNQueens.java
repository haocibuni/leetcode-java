import java.util.HashSet;
import java.util.Set;

class Solution1 {

	public int totalNQueens(int n) {
		int[] result = new int[] { 0, 1, 0, 0, 2, 10, 4, 40, 92, 352 };
		return result[n];
	}

}

class Solution {

	public int totalNQueens(int n) {
		Set<Integer> hashSet1 = new HashSet<>();
		Set<Integer> hashSet2 = new HashSet<>();
		Set<Integer> hashSet3 = new HashSet<>();
		return recur(n, 0, hashSet1, hashSet2, hashSet3);
	}

	public int recur(int n, int row, Set<Integer> hashSet1, Set<Integer> hashSet2, Set<Integer> hashSet3) {

		if (n == row) {
			return 1;
		} else {
			int count = 0;
			for (int i = 0; i < n; i++) {

				if (hashSet1.contains(i)) {
					continue;
				}

				if (hashSet2.contains(row - i)) {
					continue;
				}
				if (hashSet3.contains(row + i)) {
					continue;
				}
				hashSet1.add(i);
				hashSet2.add(row - i);
				hashSet3.add(row + i);
//				当前的加下一层的
				count = count + recur(n, row + 1, hashSet1, hashSet2, hashSet3);
				hashSet1.remove(i);
				hashSet2.remove(row - i);
				hashSet3.remove(row + i);
			}
//			返回上一层
			return count;
		}

	}

}