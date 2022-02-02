public class MaximumSquareSubmatrix {
	public static int size(int[][] arrA) {
        int row = arrA.length;
        int cols = arrA[0].length;
		int[][] sub = new int[row][cols];
		for (int i = 0; i < cols; i++) {
			sub[0][i] = arrA[0][i];
		}

		for (int i = 0; i < row; i++) {
			sub[i][0] = arrA[i][0];
        }
        
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < cols; j++) {
				if (arrA[i][j] == 1) {
					sub[i][j] = Math.min(sub[i - 1][j - 1],
							Math.min(sub[i][j - 1], sub[i - 1][j])) + 1;
				} else {
					sub[i][j] = 0;
				}
			}
		}

		int maxSize = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < cols; j++) {
				if (sub[i][j] > maxSize) {
					maxSize = sub[i][j];
				}
			}
		}
		return maxSize;
	}
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
             for (int j = 0; j < n; j++) {
                 a[i][j] = StdIn.readInt();
             }
        }
        System.out.println(size(a));
     }
}