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
//		�½��ձ�ͷ��ǰ�ڵ�ָ���ͷ
		Node newheadNode = new Node(0), beforeNode = newheadNode, curNode = head;
		while (curNode != null) {
//			���Ƶ�ǰ�ڵ�
			Node newNode = new Node(curNode.val);
//			ǰ���ڵ�-����ǰ���ƽڵ�
			beforeNode.next = newNode;
//			ǰ���ڵ������������ڵ�
			beforeNode = newNode;
//			��ǰ�ڵ������������һ�ڵ�
			curNode = curNode.next;
		}
		return null;

	}
}

//��ϣ�� ʱ�临�Ӷ�n �ռ临�Ӷ�n
//����ͨ����ϣ�ֵ��¼ ������ڵ�;�����ڵ�Ķ�Ӧ��ϵ
//Ȼ���ٱ���һ�߽��и�ֵ
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

//ƴ�Ӳ�ַ� ʱ�临�Ӷ�n �ռ临�Ӷ�1
//���¾ɽڵ��������Ӻ��ٱ�����ȡ�½ڵ�randomָ��
//Ȼ���ֻ�ȡnextָ��
class Solution_joint {
	public Node copyRandomList(Node head) {
		if (head == null) {
			return null;
		}
		Node cur = head;
//		1�������������������������
		while (cur != null) {
			Node node = new Node(cur.val);
//			�����Ӻ���
			node.next = cur.next;
//			������ǰ��
			cur.next = node;
//			������һ���ɽڵ�
			cur = node.next;
		}
//		2�������½ڵ��randomָ��
		cur = head;
		while (cur != null) {
//			����ͽڵ�randomָ�����
			if (cur.random != null) {
//				���½ڵ��random��ֵΪ�ɽڵ�randomָ���next
//				�����½ڵ�͸��½ڵ�����
				cur.next.random = cur.random.next;
			}
//			������һ���ɽڵ�
			cur = cur.next.next;
		}
//		3���������
		cur = head.next;
		Node preNode = head, res = head.next;
//		�¾�һ������ж��Ƿ��оɽڵ�
		while (cur.next != null) {
			preNode.next = preNode.next.next;
			cur.next = cur.next.next;
//			��һ���ɽڵ�
			preNode = preNode.next;
//			��һ���½ڵ�
			cur = cur.next;
		}
//		�ɽڵ����Ϊnull ������ֵnull��ɽڵ��nextΪ�½ڵ�
//		�½ڵ����Ĭ��Ϊnull
		preNode.next = null;
		return res;

	}
}