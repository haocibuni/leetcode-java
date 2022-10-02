import java.util.ArrayList;
import java.util.LinkedList;

class Solution {
//	一维结果链表
	private LinkedList<String> res;
//	一维路径链表
	private LinkedList<String> path = new LinkedList<>();

	public List<String> findItinerary(List<List<String>> tickets) {
//		按目的地对机票进行排序
		Collections.sort(tickets, (a, b) -> a.get(1).compareTo(b.get(1)));
//		添加路径的首节点
		path.add("JFK");
//		每张机票是否使用过
		boolean[] used = new boolean[tickets.size()];
//		将集合转化为数组进行递归
		backTracking((ArrayList) tickets, used);
		return res;
	}

	public boolean backTracking(ArrayList<List<String>> tickets, boolean[] used) {
//		当路径长度等于机票数量加1，则进行深拷贝返回
		if (path.size() == tickets.size() + 1) {
			res = new LinkedList(path);
			return true;
		}
//		遍历没用过的机票且机票的起始地等于路径的最后位置
		for (int i = 0; i < tickets.size(); i++) {
			if (!used[i] && tickets.get(i).get(0).equals(path.getLast())) {
//				将机票的目的地添加到路径，且标记为使用
				path.add(tickets.get(i).get(1));
				used[i] = true;
//				继续递归
				if (backTracking(tickets, used)) {
					return true;
				}
//				回溯
				used[i] = false;
				path.removeLast();
			}
		}
		return false;
	}
}