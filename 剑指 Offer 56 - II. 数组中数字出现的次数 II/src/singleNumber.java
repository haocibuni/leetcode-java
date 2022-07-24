//�����Զ����� ʱ�临�Ӷ�n �ռ临�Ӷ�1
class Solution_binary {
	public int singleNumber(int[] nums) {
		int ones = 0, twos = 0;
		for (int num : nums) {
			ones = ones ^ num & ~twos;
			twos = twos ^ num & ~ones;
		}
		return ones;

	}
}

//ѭ�������� ʱ�临�Ӷ�n �ռ临�Ӷ�1
//ʹ��������1��ȡ�������һλ�Ƿ�Ϊ1��Ȼ����ڶ�Ӧλ�ϣ���������һλ����ѭ��
//count��ʾ�����������ƴ�λ��ͷΪ1������
//Ȼ��ʹ������һλ�ͻ������ȡres ������1����1֮���������Ľ����Ϊ0
class Solution_for {
	public int singleNumber(int[] nums) {
		int[] count = new int[32];
		for (int num : nums) {
			for (int j = 0; j < 32; j++) {
				count[j] += num & 1;
				num >>>= 1;
			}
		}
		int res = 0, m = 3;
		for (int i = 0; i < 32; i++) {
			res <<= 1;
			res |= count[31 - i] % m;
		}
		return res;

	}
}