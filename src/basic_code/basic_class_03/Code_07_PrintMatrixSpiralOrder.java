package basic_code.basic_class_03;

/**
 * 转圈打印矩阵，如1 2 3，打印为1 2 3 6 9 8 7 4 5
 * 				  4 5 6
 * 				  7 8 9
 */
public class Code_07_PrintMatrixSpiralOrder {

	public static void spiralOrderPrint(int[][] matrix) {
		int tR = 0;
		int tC = 0;
		int dR = matrix.length - 1;
		int dC = matrix[0].length - 1;
		while (tR <= dR && tC <= dC) {
			printEdge(matrix, tR++, tC++, dR--, dC--);
		}
	}
	//这个方法每次都是打印这个矩阵的外圈
	public static void printEdge(int[][] m, int tR, int tC, int dR, int dC) {
		if (tR == dR) { //只有一行的矩阵
			for (int i = tC; i <= dC; i++) {
				System.out.print(m[tR][i] + " ");
			}
		} else if (tC == dC) { // 只有一列的矩阵
			for (int i = tR; i <= dR; i++) {
				System.out.print(m[i][tC] + " ");
			}
		} else { //顺时针打印矩阵的外圈
			int curC = tC;
			int curR = tR;
			//先往右打印，直到到头了
			while (curC != dC) {
				System.out.print(m[tR][curC] + " ");
				curC++;
			}
			//再往下打印，直到到头
			while (curR != dR) {
				System.out.print(m[curR][dC] + " ");
				curR++;
			}
			//再往左打印，直到到头
			while (curC != tC) {
				System.out.print(m[dR][curC] + " ");
				curC--;
			}
			//再往上打印，直到到头
			while (curR != tR) {
				System.out.print(m[curR][tC] + " ");
				curR--;
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };
		spiralOrderPrint(matrix);

	}

}
