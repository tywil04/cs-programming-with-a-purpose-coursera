public class DiscreteDistribution {
    public static void main(String[] args) {
        int n = args.length;
        int amount = Integer.parseInt(args[0]);
        int[] freq = new int[n];
        for (int i = 0; i < n; i++) {
            freq[i] = Integer.parseInt(args[i]);
        }

        int total = 0;
        for (int i = 0; i < n; i++) {
            total += freq[i];
        }

        int[] finished = new int[amount];
        int total2 = -1;
        for (int c = 0; c < amount; c++) {
            int r = (int) (total * Math.random());
            int sum = 0;
            int event = -1;
            for (int i = 1; i < n && sum <= r; i++) {
                sum += freq[i];
                event = i;
            }
            total2 += 1;
            finished[total2] = event;
        }

        for (int i = 1; i <= finished.length; i++) {
            System.out.print(finished[i-1] + " ");
            if (i % 25 == 0) {
               System.out.print("\n");
            }
         }
    }  
} 