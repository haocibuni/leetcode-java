import java.util.Stack;

class Solution {
	int largestRectangleArea(int[] heights) {
		Stack<Integer> st = new Stack<Integer>();

		// �������ݣ���ͷ��β������һ��Ԫ��
		int[] newHeights = new int[heights.length + 2];
		newHeights[0] = 0;
		newHeights[newHeights.length - 1] = 0;
		for (int index = 0; index < heights.length; index++) {
			newHeights[index + 1] = heights[index];
		}

		heights = newHeights;

		st.push(0);
		int result = 0;
		// ��һ��Ԫ���Ѿ���ջ�����±�1��ʼ
		for (int i = 1; i < heights.length; i++) {
			// ע��heights[i] �Ǻ�heights[st.top()] �Ƚ� ��st.top()���±�
			if (heights[i] > heights[st.peek()]) {
				st.push(i);
			} else if (heights[i] == heights[st.peek()]) {
				st.pop(); // ������Լӣ����Բ��ӣ�Ч��һ����˼·��ͬ
				st.push(i);
			} else {
				while (heights[i] < heights[st.peek()]) { // ע����while
					int mid = st.peek();
					st.pop();
					int left = st.peek();
					int right = i;
					int w = right - left - 1;
					int h = heights[mid];
					result = Math.max(result, w * h);
				}
				st.push(i);
			}
		}
		return result;
	}
}