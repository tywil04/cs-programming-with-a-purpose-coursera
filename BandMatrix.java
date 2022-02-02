public class BandMatrix {
    public static void main(String[] args) {
        int width = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        
        for (int i = 0; i < width; i++) {
            String string = "";
            for (int a = 0; a < width; a++) {
                if (a < n + 1 + i && a > i - (n + 1)) {
                    string += " * ";
                } else {
                    string += " 0 ";
                }
            }
            System.out.println(string.substring(1, string.length() - 1));
        }
    }
}