public class RandomWalker {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int cord1 = 0;
        int cord2 = 0;
        int steps = 0;
        double north = 0.25;
        double east = 0.5;
        double south = 0.75;
        System.out.println("(" + cord1 + ", " + cord2 + ")");
        while (r != Math.abs(cord1) + Math.abs(cord2)) {
            double chance = Math.random();
            if (chance <= north) {
                cord2 += 1;
                System.out.println("(" + cord1 + ", " + cord2 + ")");
                steps += 1;
            } else if (chance >= north && chance <= east) {
                cord1 += 1;
                System.out.println("(" + cord1 + ", " + cord2 + ")");
                steps += 1;
            } else if (chance >= east && chance <= south) {
                cord2 += -1;
                System.out.println("(" + cord1 + ", " + cord2 + ")");
                steps += 1;
            } else if (chance >= south && chance <= 1) {
                cord1 += -1;
                System.out.println("(" + cord1 + ", " + cord2 + ")");
                steps += 1;
            }
        }
        System.out.println("steps = " + steps);
    }
}