import java.util.HashSet;
import java.util.Set;

//hashset法 时间复杂度n
//只有两种可能 要么进入循环即出现重复的数 要么数为1
class Solution {
	public boolean isHappy(int n) {
		Set<Integer> seen = new HashSet<>();
		while (n != 1 && !seen.contains(n)) {
			seen.add(n);
			n = getNext(n);
		}
		return n == 1;
	}

	public int getNext(int n) {
		int totalsum = 0;
		while (n > 0) {
			int d = n % 10;
			n = n / 10;
			totalsum += d * d;
		}
		return totalsum;
	}
}