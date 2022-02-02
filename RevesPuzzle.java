import java.io.CharConversionException;

public class RevesPuzzle {
    private static void reves(int n, char A, char B, char C, char D) {
        if (n == 1) {
            System.out.println("Move disc " + n + " from " + Character.toUpperCase(A) + " to " + Character.toUpperCase(D));
            return;
        }
        int k = (int) Math.round(1.0 + n - Math.sqrt(1.0 + 2 * n));
        reves(k, A, D, C, B);
        hanoi(n - k, A, C, D, n);
        reves(k, B, A, C, D);
    }

    private static void hanoi(int n, char start, char mid, char end, int disk) {
        if (n > 0) {
            hanoi(n - 1, start, end, mid, disk - 1);
            System.out.println("Move disc " + disk + " from " + Character.toUpperCase(start) + " to " + Character.toUpperCase(end));
            hanoi(n - 1, mid, start, end, disk - 1);
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        reves(n, 'a', 'b', 'c', 'd');
    }
}