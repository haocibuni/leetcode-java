import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//hashmap��¼ֵ�ʹ����Ķ�Ӧ hashset��¼�����ĳ��ִ���
//����ͬ��������Ŀ���ڲ�ͬ�Ĵ�����Ŀ
class Solution {
	public boolean uniqueOccurrences(int[] arr) {
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (!hashMap.containsKey(arr[i])) {
				hashMap.put(arr[i], 1);
			} else {
				hashMap.put(arr[i], hashMap.get(arr[i]) + 1);
			}
		}
		HashSet<Integer> hashSet = new HashSet<>();
		for (Map.Entry<Integer, Integer> x : hashMap.entrySet()) {
			hashSet.add(x.getValue());
		}

		return hashSet.size() == hashMap.size();
	}
}