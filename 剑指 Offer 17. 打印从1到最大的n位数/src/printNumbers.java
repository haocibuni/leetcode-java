//pow����end�� ʱ�临�Ӷ�10n
class Solution_end {
	public int[] printNumbers(int n) {
		int end = (int) Math.pow(10, n) - 1;
		int[] numbers = new int[end];
		for (int i = 0; i < end; i++) {
			numbers[i] = i + 1;
		}
		return numbers;

	}
}

//������ �ַ���ģ��ӷ�
//stringbuilder��һ���ɱ���ַ�����
//substring() ���������ַ��������ַ���  ����Ϊ beginIndex -- ��ʼ������������, ������ 0 ��ʼ�� endIndex -- ��������������������
class Solution_bigdata {
//	�ַ���ģ��int����
	StringBuilder resBuilder;
//	��������num �� �ַ�������
	char[] num, loop = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
//	λ��n��num������ʼ�±꣬num�ĵ�ǰλ��-1
	int n, start, nine = 0;

	public String printNumbers(int n) {
		this.n = n;
		this.start = n - 1;
		resBuilder = new StringBuilder();
		num = new char[n];
		DFS(0);
//		ɾ�����Ķ���
		resBuilder.deleteCharAt(resBuilder.length() - 1);
		return resBuilder.toString();
	}

//������������Ϊλ��n
	public void DFS(int x) {
		if (x == n) {
//			ȡ��num�ַ�����ķ��㲿��
			String s = String.valueOf(num).substring(start);
			if (!s.equals("0")) {
//				����ǰλ�� == ��λ��n-0��λ��
				if (n - start == nine) {
					start--;
				}
				resBuilder.append(s + ',');
			}
			return;
		}
		for (char i : loop) {
//			����ǰλΪ9 ���λ
			if (i == '9') {
				nine++;
			}
			num[x] = i;
//			���������һλ
			DFS(x + 1);
		}
		nine--;
	}
}