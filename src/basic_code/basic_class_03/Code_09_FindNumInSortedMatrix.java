package basic_code.basic_class_03;

/**
 * 行和列都排好序的矩阵中找到num
 */
public class Code_09_FindNumInSortedMatrix {

	public static boolean isContains(int[][] matrix, int K) {
		int row = 0;
		int col = matrix[0].length - 1;
		//第一次从右上角的数开始，右上角的数是靠中间的数，不要让行加过边界，不要让列减过边界
		while (row < matrix.length && col > -1) {
			if (matrix[row][col] == K) {
				return true;
				//如果当前值比num大，肯定在这个值的左边，否则，肯定在这个值的下边
			} else if (matrix[row][col] > K) {
				col--;
			} else {
				row++;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 0, 1, 2, 3, 4, 5, 6 },// 0
				{ 10, 12, 13, 15, 16, 17, 18 },// 1
				{ 23, 24, 25, 26, 27, 28, 29 },// 2
				{ 44, 45, 46, 47, 48, 49, 50 },// 3
				{ 65, 66, 67, 68, 69, 70, 71 },// 4
				{ 96, 97, 98, 99, 100, 111, 122 },// 5
				{ 166, 176, 186, 187, 190, 195, 200 },// 6
				{ 233, 243, 321, 341, 356, 370, 380 } // 7
		};
		int K = 233;
		System.out.println(isContains(matrix, K));
	}

}
