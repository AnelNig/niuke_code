package basic_code.basic_class_03;

/**
 * 正方形矩阵顺时针旋转90度
 */
public class Code_16_RotateMatrix {

    public static void rotate(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR < dR){
            rotateEdge(matrix , tR++ , tC++ , dR-- , dC--);
        }
    }

    public static void rotateEdge(int[][] m , int tR , int tC ,int dR , int dC) {
        //循环次数就是从列1到最后一列
        int times = dC-tC;
        int tmp = 0 ;
        for (int i = 0; i != times; i++) {
            //四个边的相应位置进行移动
            tmp = m[tR][tC + i];
            m[tR][tC + i] = m[dR - i][tC];
            m[dR - i][tC] = m[dR][dC - i];
            m[dR][dC - i] = m[tR + i][dC];
            m[tR + i][dC] = tmp;
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        rotate(matrix);
        printMatrix(matrix);
    }
}
