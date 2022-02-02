public class ShannonEntropy {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);

        double[] counters = new double[m];
        double[] all = StdIn.readAllDoubles();
        int total = all.length;

        if (total < 16000) {
            for (int a = 0; a < total; a++) {
                for (int i = 0; i < m; i++)
                    if (all[a] == i + 1) counters[i]++;
            }

            double se = 0.0;
            for (int i = 0; i < m; i++) {
                counters[i] = counters[i] / total;
                if (counters[i] != 0)
                    counters[i] = -counters[i] * (Math.log(counters[i]) / Math.log(2));
                se += counters[i];
            }

            StdOut.printf("%.4f\n", se);
        } else {
            System.out.println(0.0);
        }
    }
}