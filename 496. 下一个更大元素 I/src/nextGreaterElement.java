import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

//������ ʱ�临�Ӷ�n3
class Solution1 {
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int[] res = new int[nums1.length];
		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				if (nums1[i] == nums2[j]) {
					res[i] = -1;
					for (int k = j + 1; k < nums2.length; k++) {
						if (nums2[j] < nums2[k]) {
							res[i] = nums2[k];
							break;
						}
					}
				}
			}
		}
		return res;
	}
}

//����ջ��
class Solution {
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//		��-1��ʼ��
		int[] res = new int[nums1.length];
		Arrays.fill(res, -1);
		Stack<Integer> stack = new Stack<>();
//		ʹ�ù�ϣ���ϼ�¼
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < res.length; i++) {
			hashMap.put(nums1[i], i);
		}
//		��nums2ѡȡ���ֵ
		stack.push(nums2[0]);
		for (int i = 1; i < nums2.length; i++) {
//			��С�ڵ���ջ�����ջ
			if (nums2[i] <= stack.peek()) {
				stack.push(nums2[i]);
			} else {
//				������ջ�����ջ������¼����
				while (!stack.isEmpty() && nums2[i] > stack.peek()) {
//					��num1������ջԪ�����±����
					if (hashMap.containsKey(stack.peek())) {
						res[hashMap.get(stack.peek())] = nums2[i];

					}
					stack.pop();
				}
//				��ջ
				stack.push(nums2[i]);
			}
		}
		return res;
	}
}