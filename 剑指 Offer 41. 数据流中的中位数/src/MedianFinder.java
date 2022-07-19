import java.util.PriorityQueue;
import java.util.Queue;

//�󶥶Ѻ�С���ѷ� ʱ�临�ӶȲ�����λ��1 �������logn �ռ临�Ӷ�n
//���ȶ���󶥶Ѻ�С���� С���Ѵ��n/2��n/2+1  С���Ѵ��n/2��n/2-1
//���������ʱ��С��������� ���Ȳ����ʱ��󶥶����
//���ʱ����Ҫ��ͨ����һ����
class MedianFinder {
	Queue<Integer> A, B;

	/** initialize your data structure here. */
	public MedianFinder() {
		A = new PriorityQueue<>();
//		�󶥶�
		B = new PriorityQueue<>((x, y) -> (y - x));
	}

	public void addNum(int num) {
		if (A.size() != B.size()) {
			A.add(num);
			B.add(A.poll());

		} else {
			B.add(num);
			A.add(B.poll());
		}

	}

	public double findMedian() {
		return A.size() == B.size() ? (A.peek() + B.peek()) / 2 : A.peek();

	}
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder(); obj.addNum(num); double param_2 =
 * obj.findMedian();
 */