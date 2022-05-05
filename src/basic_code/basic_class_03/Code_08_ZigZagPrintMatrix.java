package basic_code.basic_class_03;

/**
 * 之字形打印矩阵，如	1 2 3，打印为1 2 4 7 5 3 6 8 9
 *  				4 5 6
 *  				7 8 9
 */
public class Code_08_ZigZagPrintMatrix {

	public static void printMatrixZigZag(int[][] matrix) {
		//坐标（R,C）R是行号，C是列号，t指针先往右走，到头之后向下，d指针先往下走，到头之后向右
		int tR = 0;
		int tC = 0;
		int dR = 0;
		int dC = 0;
		int endR = matrix.length - 1;//最后的行号
		int endC = matrix[0].length - 1;//最后的列号
		boolean fromUp = false;
		while (tR != endR + 1) {
			printLevel(matrix, tR, tC, dR, dC, fromUp);
			//t先右再下，d先下再右
			tR = tC == endC ? tR + 1 : tR;//如果t的列号到了最右边，就加行号
			tC = tC == endC ? tC : tC + 1;//如果t的列号没到最右边，就加列号
			dC = dR == endR ? dC + 1 : dC;//如果d的行号到了最下边，就加列号
			dR = dR == endR ? dR : dR + 1;//如果d的行号没到最下边，就加行号
			fromUp = !fromUp;
		}
		System.out.println();
	}
	//打印对角线
	public static void printLevel(int[][] m, int tR, int tC, int dR, int dC, boolean f) {
		if (f) {
			//dR+1是d点下面的行，t打印完d这个点后行号加一就等于d的行号加一了
			while (tR != dR + 1) {
				//t是向左下角打印的
				System.out.print(m[tR++][tC--] + " ");
			}
		} else {
			//tR-1是t上面的一行，d打印完t后行号减一就等于tR-1了
			while (dR != tR - 1) {
				//d是向右上角打印的
				System.out.print(m[dR--][dC++] + " ");
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		printMatrixZigZag(matrix);

	}

}
