public class TrinomialDP {
    public static long trinomial(int n, int k) {
        if (n == 0 && k == 0) {
            return 1;
        } else if (k < -n || k > n) {
            return 0;
        } else {
            long[][] computed = new long[n + k + 1][n + k + 1];
            computed[0][0] = 1;

            for (int i = 1; i <= n + k; i++) {
                for (int v = 0; v < n + k; v++) {
                    if (v == 0) {
                        computed[i][v] = 2 * computed[i - 1][v + 1] + computed[i - 1][v];
                    } else {
                        computed[i][v] = computed[i - 1][v - 1] + computed[i - 1][v] + computed[i - 1][v + 1];
                    }
                }
            }
            return computed[n][k];
        }
    }
    
        public static void main(String[] args) {
            int n = Integer.parseInt(args[0]);
            int k = Integer.parseInt(args[1]);
            System.out.println(trinomial(Math.abs(n), Math.abs(k)));
        }
    }
    
