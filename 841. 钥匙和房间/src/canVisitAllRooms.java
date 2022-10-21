import java.util.List;

class Solution {
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		boolean[] visited = new boolean[rooms.size()];
		dfs(0, rooms, visited);
		for (boolean visit : visited) {
			if (!visit) {
				return false;
			}
		}
		return true;
	}

	public void dfs(int k, List<List<Integer>> rooms, boolean[] visited) {
//		若已经访问则返回
		if (visited[k]) {
			return;
		}
		visited[k] = true;
		for (int n : rooms.get(k)) {
			// 深度优先搜索遍历
			dfs(n, rooms, visited);
		}
	}
}