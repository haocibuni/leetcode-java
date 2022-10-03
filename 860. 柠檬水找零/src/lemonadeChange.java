class Solution {
	public boolean lemonadeChange(int[] bills) {
		int five = 0;
		int ten = 0;
		for (int i = 0; i < bills.length; i++) {
			if (bills[i] == 5) {
				five++;
				continue;
			}
			if (bills[i] == 10) {
				ten++;
				if (five > 0) {
					five--;
				} else {
					return false;
				}
				continue;
			}
			if (bills[i] == 20) {
				if (five > 0 && ten > 0) {
					five--;
					ten--;

				} else if (five >= 3) {
					five -= 3;
				} else
					return false;
			}
		}
		return true;

	}
}