import java.util.PriorityQueue;
import java.util.Queue;

//大顶堆和小顶堆法 时间复杂度查找中位数1 添加数字logn 空间复杂度n
//首先定义大顶堆和小顶堆 小顶堆存放n/2或n/2+1  小顶堆存放n/2或n/2-1
//当长度相等时向小顶堆中添加 长度不相等时向大顶堆添加
//添加时都需要先通过另一个堆
class MedianFinder {
	Queue<Integer> A, B;

	/** initialize your data structure here. */
	public MedianFinder() {
		A = new PriorityQueue<>();
//		大顶堆
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