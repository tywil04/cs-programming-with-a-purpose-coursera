public class Divisors {
    public static int gcd(int a, int b) {
        int last1 = Math.abs(a);
        int last2 = Math.abs(b);
        int holder1 = 0;
        int holder2 = 0;
        while (last2 > 0) {
            holder1 = last1;
            holder2 = last2;
            last1 = holder2;
            last2 = holder1 % holder2;
        }
        return last1;
    }

    public static int lcm(int a, int b) {
        if (a == 0 && b == 0) return 0;
        return Math.abs((a / gcd(a, b)) * b);
    }

    public static boolean areRelativelyPrime(int a, int b) {
        return gcd(a, b) == 1;
    }

    public static int totient(int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (areRelativelyPrime(n, i) == true) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        System.out.println("gcd(" + a + ", " + b + ") = " + gcd(a, b));
        System.out.println("lcm(" + a + ", " + b + ") = " + lcm(a, b));
        System.out.println("areRelativelyPrime(" + a + ", " + b + ") = " + areRelativelyPrime(a, b));
        System.out.println("totient(" + a + ") = " + totient(a));
        System.out.println("totient(" + b + ") = " + totient(b));
    }
}
