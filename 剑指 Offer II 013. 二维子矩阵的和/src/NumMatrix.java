class NumMatrix {
	int[][] matrix;

	public NumMatrix(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		this.matrix = new int[m + 1][n + 1];
		int count;
		for (int i = 0; i < m; i++) {
			count = 0;
			for (int j = 0; j < n; j++) {
				count += matrix[i][j];
				this.matrix[i + 1][j + 1] = this.matrix[i][j + 1] + count;
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		return this.matrix[row2 + 1][col2 + 1] - this.matrix[row1][col2 + 1] - this.matrix[row2 + 1][col1]
				+ this.matrix[row1][col1];
	}
}