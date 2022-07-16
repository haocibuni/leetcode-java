import java.util.HashMap;

class Node {
	int val;
	Node next;
	Node random;

	public Node(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}
}

class Solution_notrandom {
	public Node copyRandomList(Node head) {
//		新建空表头，前节点指向表头
		Node newheadNode = new Node(0), beforeNode = newheadNode, curNode = head;
		while (curNode != null) {
//			复制当前节点
			Node newNode = new Node(curNode.val);
//			前驱节点-》当前复制节点
			beforeNode.next = newNode;
//			前驱节点遍历到新链表节点
			beforeNode = newNode;
//			当前节点遍历旧链表下一节点
			curNode = curNode.next;
		}
		return null;

	}
}

//哈希表法 时间复杂度n 空间复杂度n
//首先通过哈希字典记录 新链表节点和旧链表节点的对应关系
//然后再遍历一边进行赋值
class Solution_Hash {
	public Node copyRandomList(Node head) {
		Node cur = head;
		java.util.Map<Node, Node> map = new HashMap<>();
		while (cur != null) {
			map.put(cur, new Node(cur.val));
			cur = cur.next;
		}
		cur = head;
		while (cur != null) {
			map.get(cur).next = map.get(cur.next);
			map.get(cur).random = map.get(cur.random);
			cur = cur.next;
		}
		return map.get(head);

	}
}

//拼接拆分法 时间复杂度n 空间复杂度1
//将新旧节点依次连接后再遍历获取新节点random指向
//然后拆分获取next指向
class Solution_joint {
	public Node copyRandomList(Node head) {
		if (head == null) {
			return null;
		}
		Node cur = head;
//		1、创建新链表，并与旧链表连接
		while (cur != null) {
			Node node = new Node(cur.val);
//			先连接后面
			node.next = cur.next;
//			再连接前面
			cur.next = node;
//			跳到下一个旧节点
			cur = node.next;
		}
//		2、构建新节点的random指向
		cur = head;
		while (cur != null) {
//			如果就节点random指向存在
			if (cur.random != null) {
//				则将新节点的random赋值为旧节点random指向的next
//				这样新节点就跟新节点连接
				cur.next.random = cur.random.next;
			}
//			遍历下一个旧节点
			cur = cur.next.next;
		}
//		3、拆分链表
		cur = head.next;
		Node preNode = head, res = head.next;
//		新旧一起遍历判断是否还有旧节点
		while (cur.next != null) {
			preNode.next = preNode.next.next;
			cur.next = cur.next.next;
//			下一个旧节点
			preNode = preNode.next;
//			下一个新节点
			cur = cur.next;
		}
//		旧节点后面为null 若不赋值null则旧节点的next为新节点
//		新节点后面默认为null
		preNode.next = null;
		return res;

	}
}