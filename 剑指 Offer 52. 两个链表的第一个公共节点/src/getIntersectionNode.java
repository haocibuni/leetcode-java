
public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

//������ ʱ�临�Ӷ�n2 �ռ临�Ӷ�1
class Solution_force {
	ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		while (headA != null) {
			while (headB != null) {
				if (headA.equals(headB)) {
					return headA;
				}
				headB = headB.next;
			}
			headA = headA.next;
		}
		return null;
	}
}

//˫ָ�뷨 ʱ�临�Ӷ�m+n �ռ临�Ӷ�1
//������ͬβ���������ջ�����
//aΪa������ bΪb������ cΪa��b�Ĺ�ͬβ��
//a+(b-c)==b+(a-c)
//�����������û�й����ڵ����null�������ǵĹ����ڵ�
class Solution_doublelink {
	ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode a = headA, b = headB;
		while (a != b) {
			a = a == null ? headB : a.next;
			b = b == null ? headA : b.next;
		}
		return a;
	}
}
//�����߹��ҵ����磬�ٴ����������һ�顱
//�����߹�������磬�ٴ��ҵ�������һ�顱
//���������ǽ�������������;�У������ڵ㣩�������ڽ�β��null����