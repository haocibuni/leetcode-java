import java.util.Stack;

//���������� ��Aջ��ȫ������Bջ��Ȼ��Bջͷ�����ٽ�Bջȫ������Aջ
class CQueue_change {
	Stack<Integer> appendTailstack;
	Stack<Integer> deleteHeadstack;

	public CQueue_change() {
		appendTailstack = new Stack<Integer>();
		deleteHeadstack = new Stack<Integer>();

	}

	public void appendTail(int value) {
		appendTailstack.push(value);

	}

	public int deleteHead() {
		int stacksize = appendTailstack.size();
		for (int i = 0; i < stacksize; i++) {
			deleteHeadstack.push(appendTailstack.pop());

		}
		if (!deleteHeadstack.isEmpty()) {
			int Out = deleteHeadstack.pop();
			int stacksize1 = deleteHeadstack.size();
			for (int i = 0; i < stacksize1; i++) {
				appendTailstack.push(deleteHeadstack.pop());

			}
			return Out;

		} else {
			return -1;
		}

	}
}

/**
 * Your CQueue object will be instantiated and called as such: CQueue obj = new
 * CQueue(); obj.appendTail(value); int param_2 = obj.deleteHead();
 */
//˫ջ�� ��Bջ��Ϊ���ջ����Bջ��Ԫ����ֱ��pop����Bջû����Aջû���򷵻�-1����Bջû��Ԫ����Aջ����Ԫ��push��Bջ��Bջ��pop��
//��Ҫע��˳�����Ƚ�AջԪ��push��Bջ��ֻ��Bջ��ʱ���ܽ�AջԪ��push��Bջ
class CQueue_ff {
	Stack<Integer> A;
	Stack<Integer> B;

	public CQueue_ff() {
		A = new Stack<Integer>();
		B = new Stack<Integer>();
	}

	public void appendTail(int val) {
		A.push(val);
	}

	public int deleteHead() {
		// B��Ϊ�գ���B��ֵ����
		if (!B.isEmpty()) {

			return B.pop();
		}

		// AΪ�գ�����-1
		// ע�⣺�˴�����Ҫ�������棬������ΪStack������ɾ��Ԫ�أ���ʱA�Ѿ��ǿյ���
		if (A.isEmpty()) {
			return -1;
		}

		/*
		 * A B |-| |-| |5| |1| |4| |2| |3| |3| |2| |4| |1| |5|
		 */
		// ���е���˵����BΪ�գ���Ҫ��A��ֵ����B���γ���һ�ε���
		while (!A.isEmpty()) {
			B.push(A.pop());
		}
		return B.pop();
	}
}