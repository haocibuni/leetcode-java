import java.util.Stack;

//�ݹ���η� ʱ�临�Ӷ�n2 �ռ临�Ӷ�n
//�����������Ķ���Ϊ ���������нڵ�<���ڵ� ���������нڵ�>���ڵ� ��������Ϊ���������� �����һλΪ���ڵ�
class Solution_recur {
	public boolean verifyPostorder(int[] postorder) {
		return recur(postorder, 0, postorder.length - 1);
	}

	public boolean recur(int[] postorder, int i, int j) {
//		��i>=j ������Ϊ�ջ�ֻ��һ���ڵ� ����Ҫ�ж���ȷ��
		if (i >= j) {
			return true;
		}
		int p = i;
		while (postorder[p] < postorder[j]) {
			p++;
		}
		int m = p;
		while (postorder[p] > postorder[j]) {
			p++;
		}
//		p==jΪ�жϺ�������Ƿ���ȷ������
//		�����ܱ��������Ľڵ�˵���������д��ڸ��ڵ�����������������С�ڸ��ڵ�����
		return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
	}
}

//����ջ�� ʱ�临�Ӷ�n �ռ临�Ӷ�n
//��ȡ��������ĵ��� 
//�Ƚ������ٽ��Ľڵ� ��Ϊ������Ϊ�ҽڵ�
//��Ϊ�������丸�ڵ�Ϊ���ڸýڵ�����ӽ��ýڵ�Ľڵ㣬���Ҹýڵ�����Ľڵ㶼С�ڸýڵ�ĸ��ڵ�
//����ջΪ�����Ľڵ�
class Solution_stack {
	public boolean verifyPostorder(int[] postorder) {
		Stack<Integer> stack = new Stack<>();
		int root = Integer.MAX_VALUE;
		for (int i = postorder.length - 1; i >= 0; i--) {
			if (postorder[i] > root)
				return false;
//			�ݼ��Ĵ�ջ�л�ȡ���ڵ� ջ�ӵ����ϵ��� ���Բ��ϳ�ջ��ȡ��ýڵ�����Ҵ��ڸýڵ��ֵ
			while (!stack.isEmpty() && stack.peek() > postorder[i])
				root = stack.pop();
//			��ÿ���ڵ㶼��ջ��ÿ���ҽڵ㶼����Ϊ�����ڵ�ĸ��ڵ�
			stack.add(postorder[i]);
		}
		return true;
	}
}