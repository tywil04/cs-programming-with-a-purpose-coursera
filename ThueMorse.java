public class ThueMorse { 
    // THIS DOES NOT WORK AS INTENDED USE THUEMORSE2.JAVA
    public static void main(String[] args) { 
        int n = Integer.parseInt(args[0]);
        String thue  = "";
        String morse  = "";

        int[] invert = {1, 0};
        int[] numbers1 = {1, 0, 0, 1};
        int cycle1 = 0;

        for (int i = 0; i < n; i++) {
            if (cycle1 < 4) {
                if (numbers1[cycle1] == 1) {
                    morse += "+  ";
                    thue += "-  ";
                    cycle1++;
                } else if (numbers1[cycle1] == 0) {
                    morse += "-  ";
                    thue += "+  ";
                    cycle1++;
                }
            } else {
                numbers1[0] = invert[numbers1[0]];
                numbers1[1] = invert[numbers1[1]];
                numbers1[2] = invert[numbers1[2]];
                numbers1[3] = invert[numbers1[3]];
                cycle1 = 0;
                i--;
            }
        }

        int[] numbers = {1, 0, 0, 1};
        int cycle = 0;

        for (int i = 0; i < n; i++) {
            if (cycle < 4) {
                if (numbers[cycle] == 1) {
                    System.out.println(morse);
                    cycle++;
                } else if (numbers[cycle] == 0) {
                    System.out.println(thue);
                    cycle++;
                }
            } else {
                numbers[0] = invert[numbers[0]];
                numbers[1] = invert[numbers[1]];
                numbers[2] = invert[numbers[2]];
                numbers[3] = invert[numbers[3]];
                cycle = 0;
                i--;
            }
        }
    }
}