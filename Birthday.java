import java.util.Arrays;

public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        double fraction = 0;
        double sum = 0;
        int i = 1;
        boolean[] hasBirthday = new boolean[n];

        while (fraction < 0.5) {
            int count = 0;
            for (int t = 1; t <= trials; t++) {
                Arrays.fill(hasBirthday, false);
                int people = 0;

                while (true) {
                    people++;
                    int d = (int) (n * Math.random());
                    if (hasBirthday[d] && i == people) {
                        count++;
                        break;
                    }
                    else if (hasBirthday[d]) break;
                    else hasBirthday[d] = true;
                }
            }
            sum += count;
            fraction = sum / trials;
            System.out.println(i + "\t" + count + "\t" + fraction);
            i++;
            if (i > n + 3) break;
        }
    }
}