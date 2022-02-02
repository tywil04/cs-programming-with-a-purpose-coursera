public class WorldMap {
    public static void main(String[] args) {
        String[] trueargs = StdIn.readAllStrings();
        int bound1 = Integer.parseInt(trueargs[0]);
        int bound2 = Integer.parseInt(trueargs[1]);

        StdDraw.setCanvasSize(bound1, bound2);
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, bound1);
        StdDraw.setYscale(0, bound2);

        for (int i = 0; i < trueargs.length; i++) {
            boolean hasletter = false;
            for (char c : trueargs[i].toCharArray()) {
                if (Character.isLetter(c)) {
                    hasletter = true;
                }
            }
            if (hasletter == true) {
                int n = Integer.parseInt(trueargs[i + 1]);
                double[] x = new double[n];
                double[] y = new double[n];
                int countX = 0;
                int countY = 0;
                for (int a = 1; a <= (n * 2); a++) {
                    if (a % 2 == 0) {
                        y[countY] = Double.parseDouble(trueargs[i + 1 + a]);
                        countY++;
                    } else if (a % 2 != 0) {
                        x[countX] = Double.parseDouble(trueargs[i + 1 + a]);
                        countX++;
                    }
                }  
                StdDraw.polygon(x, y);
                i += n;
            }
        }
        StdDraw.show();
    }
}
