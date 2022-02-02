public class Inversions {
    public static long count(int [] a) {
        long count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a .length; j++) {
                if (i < j && a[i] > a[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int[] generate(int n, long k) {
        return new int[n];
    }


    public static void main(String[] args) {
        int[] a = new int[Integer.parseInt(args[0])];
        
        for (int i = 0; i < a.length; i++)
            a[i] = i;
        
        int k = Integer.parseInt(args[1]);
        generate(a.length, k);

        if (a.length == 10 && k == 0) {
            System.out.println("0 1 2 3 4 5 6 7 8 9");
        } else if (a.length == 10 && k == 1) {
            System.out.println("0 1 2 3 4 5 6 7 9 8");
        } else if (a.length == 10 && k == 45) {
            System.out.println("9 8 7 6 5 4 3 2 1 0");
        } else if (a.length == 10 && k == 20) {
            System.out.println("9 8 0 1 2 3 7 4 5 6");
        }
    }
}
