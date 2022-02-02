public class ActivationFunction {
    public static double heaviside(double x) {
        if (x == Double.NaN) return Double.NaN;
        if (x < 0.0) {
            return 0.0;
        } else if (x == 0.0) {
            return 0.5;
        } else if (x > 0.0) {
            return 1.0;
        } else {
            return Double.NaN;
        }
    }

    public static double sigmoid(double x) {
        if (x == Double.NaN) return Double.NaN;
        double e = 2.7182818284590452353602874713527;
        return 1 / (1 + Math.pow(e, -x));
    }

    public static double tanh(double x) {
        if (x == Double.NaN) return Double.NaN;
        double e = 2.7182818284590452353602874713527;
        return (Math.pow(e, x) - Math.pow(e, -x)) / (Math.pow(e, x) + Math.pow(e, -x));
    }

    public static double softsign(double x) {
        if (x == Double.NaN) return Double.NaN;
        return x / (1 + Math.abs(x));
    }

    public static double sqnl(double x) {
        if (x == Double.NaN) return Double.NaN;
        if (x <= -2) {
            return -1;
        } else if (x > -2 && x < 0) {
            return x + (Math.pow(x, 2) / 4);
        } else if (x >= 0 && x < 2) {
            return x - (Math.pow(x, 2) / 4);
        } else if (x >= 2) {
            return 1;
        } else {
            return Double.NaN;
        }
    }

    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        System.out.println("heaviside(" + x + ") = " + heaviside(x));
        System.out.println("  sigmoid(" + x + ") = " + sigmoid(x));
        System.out.println("     tanh(" + x + ") = " + tanh(x));
        System.out.println(" softsign(" + x + ") = " + softsign(x));
        System.out.println("     sqnl(" + x + ") = " + sqnl(x));
    }
}