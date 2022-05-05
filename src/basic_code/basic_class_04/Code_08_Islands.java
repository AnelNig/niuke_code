package basic_code.basic_class_04;
//岛问题，单cpu单内存解决这个问题
//如果是特别大的矩阵涉及到了大数据，只会在面试时说，不会写代码，说思路，在合并时就要使用并查集，在感染时将第一个感染的作为并查集的head，
//然后将不同矩阵合并时，只考虑边界，用并查集记录每一个块的感染中心，将边界的感染中心不同的合为一个集合，随之岛数量减一即可
public class Code_08_Islands {

	public static int countIslands(int[][] m) {
		if (m == null || m[0] == null) {
			return 0;
		}
		int N = m.length;
		int M = m[0].length;
		int res = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (m[i][j] == 1) {
					res++;
					infect(m, i, j, N, M);
				}
			}
		}
		return res;
	}

	public static void infect(int[][] m, int i, int j, int N, int M) {
		if (i < 0 || i >= N || j < 0 || j >= M || m[i][j] != 1) {
			return;
		}
		m[i][j] = 2;
		infect(m, i + 1, j, N, M);
		infect(m, i - 1, j, N, M);
		infect(m, i, j + 1, N, M);
		infect(m, i, j - 1, N, M);
	}

	public static void main(String[] args) {
		int[][] m1 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				        { 0, 1, 1, 1, 0, 1, 1, 1, 0 }, 
				        { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
				        { 0, 1, 1, 0, 0, 0, 0, 0, 0 }, 
				        { 0, 0, 0, 0, 0, 1, 1, 0, 0 }, 
				        { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
				        { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
		System.out.println(countIslands(m1));

		int[][] m2 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
						{ 0, 1, 1, 1, 1, 1, 1, 1, 0 }, 
						{ 0, 1, 1, 1, 0, 0, 0, 1, 0 },
						{ 0, 1, 1, 0, 0, 0, 1, 1, 0 }, 
						{ 0, 0, 0, 0, 0, 1, 1, 0, 0 }, 
						{ 0, 0, 0, 0, 1, 1, 1, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
		System.out.println(countIslands(m2));

	}

}
