public class Minesweeper {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);

        int[][] array = new int[n][m];

        for (int i = 0; i < k; i++) {
            int r = (int) (n * Math.random());
            int r2 = (int) (m * Math.random());

            if (array[r][r2] == -1) {
                while (true) {
                    int r3 = (int) (n * Math.random());
                    int r4 = (int) (m * Math.random());
                    if (array[r3][r4] == 0) {
                        array[r3][r4] = -1;
                        break;
                    }
                }
            } else array[r][r2] = -1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (array[i][j] != -1) {
                    if (i != 0) {
                        if (array[i-1][j] == -1) {
                            array[i][j]++;
                        }
                    }

                    if (i != n - 1) {
                        if (array[i+1][j] == -1) {
                            array[i][j]++;
                        }
                    }

                    if (j != 0) {
                        if (array[i][j-1] == -1) {
                            array[i][j]++;
                        }
                    }

                    if (j != m - 1) {
                        if (array[i][j+1] == -1) {
                            array[i][j]++;
                        }

                    }
                    if (i != 0 && j != 0) {
                        if (array[i-1][j-1] == -1) {
                            array[i][j]++;
                        }
                    }
                    if (i != 0 && j != m - 1) {
                        if (array[i-1][j+1] == -1) {
                            array[i][j]++;
                        }
                    }
                    if (i != n - 1 && j != 0) {
                        if (array[i+1][j-1] == -1) {
                            array[i][j]++;
                        }
                    }
                    if (i != n - 1 && j != m - 1) {
                        if (array[i+1][j+1] == -1) {
                            array[i][j]++;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (array[i][j] == 0) System.out.print("0  ");
                else if (array[i][j] == -1) System.out.print("*  ");
                else System.out.print(array[i][j] + "  ");
            }
            System.out.println();
        }
    }
}