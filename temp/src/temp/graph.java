package temp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class graph {
	public static List<Character> topological_sort(char[][] edge) {
		Queue<Character> queue = new LinkedList<Character>();
//		ͳ�ƽڵ�
		HashSet<Character> hashSet = new HashSet<>();
		for (int i = 0; i < edge.length; i++) {
			hashSet.add(edge[i][0]);
			hashSet.add(edge[i][1]);
		}
//		���ڵ��ַ�ת��Ϊ�����ַ�
		LinkedList<Character> linkedList = new LinkedList<>(hashSet);
//		����������
		LinkedList<Character> result = new LinkedList<>();
//		������ȵ�hashmap
		HashMap<Character, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < edge.length; i++) {
			hashMap.put(edge[i][0], hashMap.getOrDefault(edge[i][0], 0));
			hashMap.put(edge[i][1], hashMap.getOrDefault(edge[i][0], 0) + 1);
		}
//		�����Ϊ0�Ľڵ���ӵ�������ȥ
		for (int i = 0; i < linkedList.size(); i++) {
			if (hashMap.get(linkedList.get(i)) == 0) {
				queue.add(linkedList.get(i));
			}
		}
		while (!queue.isEmpty()) {
//			���Ϊ0�Ľڵ����
			char t = queue.poll();
//			��ӵ��������
			result.add(t);
//			��������������ʼ�ڵ�Ϊ���Ϊ0�Ľڵ㣬�򽫽����ڵ�����-1
//			�������ڵ�����Ϊ0�򽫽����ڵ���ӵ�������
			for (int i = 0; i < edge.length; i++) {
				if (edge[i][0] == t) {
					hashMap.put(edge[i][1], hashMap.get(edge[i][1]) - 1);
					if (hashMap.get(edge[i][1]) == 0) {
						queue.add(edge[i][1]);
					}
				}
			}

		}
//		�����������ڽڵ�����򷵻ؽ������
		if (result.size() == hashSet.size()) {
			return result;
		}
//		���������ʾͼ�д��ڻ����ؿ�����
		return new LinkedList<>();
	}

	public static void main(String[] args) {
		char[][] edge = { { 'A', 'B' }, { 'B', 'C' }, { 'C', 'A' } };
		System.out.println(topological_sort(edge));
	}
}
