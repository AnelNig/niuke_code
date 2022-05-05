package basic_code.basic_class_07;

/**
 * 给你一个二维数组，二维数组中的每个数都是正数，要求从左上角走到右下角，每一步只能向右或者向下。
 * 沿途经过的数字要累加起来。返回最小的路径和。
 */
public class Code_07_MinPath {
	//暴力递归版本
	public static int minPath1(int[][] matrix) {
		return process(matrix, 0, 0);
	}

	//这个函数是返回点(i,j)到矩阵右下角的最短路径，i,j是当前坐标的位置
	public static int process(int[][] matrix, int i, int j) {
		if(i == matrix.length - 1 && j == matrix[0].length - 1){
			return matrix[i][j];
		}

		//如果到了最后一行
		if (i == matrix.length - 1){
			return matrix[i][j] + process(matrix, i, j + 1);
		}

		//如果到了最后一列
		if (j == matrix[0].length - 1){
			return matrix[i][j] + process(matrix, i + 1, j);
		}

		//如果是中间位置
		int down = process(matrix, i + 1, j);
		int right = process(matrix, i, j + 1);
		return matrix[i][j] + Math.min(down,right);
	}

	//动态规划版本，自己写的，测试了应该没问题
	public static int process(int[][] m) {
		if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
			return 0;
		}
		int row = m.length - 1;
		int col = m[0].length - 1;
		int[][] dp = new int[row+1][col+1];
		dp[row][col] = m[row][col];
		for (int i = row-1; i >= 0; i--) {
			dp[i][col] = dp[i+1][col] + m[i][col];
		}
		for (int j = col-1; j >= 0; j--) {
			dp[row][j] = dp[row][j+1] + m[row][j];
		}
		for (int i = row-1; i >= 0; i--) {
			for (int j = col-1; j >= 0; j--) {
				dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + m[i][j];
			}
		}
		return dp[0][0];
	}



   //动态规划版本，可以由暴力递归演变到动态规划，代码似乎是倒着的，有问题
	public static int minPath2(int[][] m) {
		if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
			return 0;
		}
		int row = m.length;
		int col = m[0].length;
		int[][] dp = new int[row][col];
		dp[0][0] = m[0][0];
		for (int i = 1; i < row; i++) {
			dp[i][0] = dp[i - 1][0] + m[i][0];
		}
		for (int j = 1; j < col; j++) {
			dp[0][j] = dp[0][j - 1] + m[0][j];
		}
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
			}
		}
		return dp[row - 1][col - 1];
	}

	// for test
	public static int[][] generateRandomMatrix(int rowSize, int colSize) {
		if (rowSize < 0 || colSize < 0) {
			return null;
		}
		int[][] result = new int[rowSize][colSize];
		for (int i = 0; i != result.length; i++) {
			for (int j = 0; j != result[0].length; j++) {
				result[i][j] = (int) (Math.random() * 10);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[][] m = { { 1, 3, 5, 9 }, { 8, 1, 3, 4 }, { 5, 0, 6, 1 }, { 8, 8, 4, 0 } };
//		System.out.println(minPath1(m));
//		System.out.println(minPath2(m));

//		m = generateRandomMatrix(6, 7);
//		System.out.println(minPath1(m));
//		System.out.println(minPath2(m));
		System.out.println(process(m));
	}
}
