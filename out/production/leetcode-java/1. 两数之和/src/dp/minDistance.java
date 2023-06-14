package dp;

class Node {
	int val;
	int choice;

	public Node(int val, int choice) {
		// TODO Auto-generated constructor stub
		this.val = val;
		this.choice = choice;
	}
}

public class minDistance {
	public static int soluton(String s1, String s2) {
		Node[][] dp = new Node[s1.length() + 1][s2.length() + 1];
		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = new Node(i, 2);
		}
		for (int j = 1; j < dp[0].length; j++) {
			dp[0][j] = new Node(j, 1);
		}
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = new Node(dp[i - 1][j - 1].val, 0);
				} else {
					dp[i][j] = minnode(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]);
					dp[i][j].val++;
				}
			}
		}
		return dp[s1.length()][s2.length()].val;
	}

	public static Node minnode(Node node1, Node node2, Node node3) {
		// TODO Auto-generated method stub
		Node res = new Node(node1.val, 2);
		if (res.val > node2.val) {
			res.val = node2.val;
			res.choice = 1;
		}
		if (res.val > node3.val) {
			res.val = node3.val;
			res.choice = 3;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(soluton("intention", "execution"));
	}
}
