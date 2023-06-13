package temp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class graph {
	public static List<Character> topological_sort(char[][] edge) {
		Queue<Character> queue = new LinkedList<Character>();
//		统计节点
		HashSet<Character> hashSet = new HashSet<>();
		for (int i = 0; i < edge.length; i++) {
			hashSet.add(edge[i][0]);
			hashSet.add(edge[i][1]);
		}
//		将节点字符转化为数组字符
		LinkedList<Character> linkedList = new LinkedList<>(hashSet);
//		定义结果数组
		LinkedList<Character> result = new LinkedList<>();
//		定义入度的hashmap
		HashMap<Character, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < edge.length; i++) {
			hashMap.put(edge[i][0], hashMap.getOrDefault(edge[i][0], 0));
			hashMap.put(edge[i][1], hashMap.getOrDefault(edge[i][0], 0) + 1);
		}
//		将入度为0的节点添加到队列中去
		for (int i = 0; i < linkedList.size(); i++) {
			if (hashMap.get(linkedList.get(i)) == 0) {
				queue.add(linkedList.get(i));
			}
		}
		while (!queue.isEmpty()) {
//			入度为0的节点出队
			char t = queue.poll();
//			添加到结果数组
			result.add(t);
//			遍历边数组若开始节点为入度为0的节点，则将结束节点的入度-1
//			若结束节点的入度为0则将结束节点添加到队列中
			for (int i = 0; i < edge.length; i++) {
				if (edge[i][0] == t) {
					hashMap.put(edge[i][1], hashMap.get(edge[i][1]) - 1);
					if (hashMap.get(edge[i][1]) == 0) {
						queue.add(edge[i][1]);
					}
				}
			}

		}
//		若结果数组等于节点个数则返回结果数组
		if (result.size() == hashSet.size()) {
			return result;
		}
//		不等于则表示图中存在环返回空数组
		return new LinkedList<>();
	}

	public static void main(String[] args) {
		char[][] edge = { { 'A', 'B' }, { 'B', 'C' }, { 'C', 'A' } };
		System.out.println(topological_sort(edge));
	}
}
