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
//		���Ѿ������򷵻�
		if (visited[k]) {
			return;
		}
		visited[k] = true;
		for (int n : rooms.get(k)) {
			// ���������������
			dfs(n, rooms, visited);
		}
	}
}