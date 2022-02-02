public class GeneralizedHarmonic {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int r = Integer.parseInt(args[1]);
        double finished = 0.0;

        for (int i = 0; i < n; i++) {
            finished = finished + (1 / Math.pow(i+1, r));
        }
        System.out.println(finished);
    }
}