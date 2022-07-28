//短路效应法 时间复杂度n 空间复杂度n
//if(A && B)  // 若 A 为 false ，则 B 的判断不会执行（即短路），直接判定 A && B 为 false
//if(A || B) // 若 A 为 true ，则 B 的判断不会执行（即短路），直接判定 A || B 为 true
//即若前边都不能满足则后面的不会被执行 前面的满足了后面的也不会执行
class Solution {
	public int sumNums(int n) {
		boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
		return n;
	}
}