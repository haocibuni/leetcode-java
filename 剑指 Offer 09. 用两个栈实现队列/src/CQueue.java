import java.util.Stack;

//暴力交换法 将A栈中全都放入B栈，然后将B栈头出，再将B栈全都放入A栈
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
//双栈法 将B栈作为输出栈，若B栈有元素则直接pop；若B栈没有且A栈没有则返回-1；若B栈没有元素则将A栈所有元素push到B栈，B栈再pop；
//需要注意顺序不能先将A栈元素push到B栈，只有B栈空时才能将A栈元素push到B栈
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
		// B不为空，将B的值弹出
		if (!B.isEmpty()) {

			return B.pop();
		}

		// A为空，返回-1
		// 注意：此处必须要放在下面，这是因为Stack操作会删除元素，此时A已经是空的了
		if (A.isEmpty()) {
			return -1;
		}

		/*
		 * A B |-| |-| |5| |1| |4| |2| |3| |3| |2| |4| |1| |5|
		 */
		// 运行到这说明，B为空，需要将A的值赋给B，形成了一次倒叙
		while (!A.isEmpty()) {
			B.push(A.pop());
		}
		return B.pop();
	}
}