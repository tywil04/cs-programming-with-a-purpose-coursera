public class ThueMorse2 {
    public static void main(String[] args) {
        int size = Integer.parseInt(args[0]);
        int[] invert = {1, 0};
        String firstline = "0";
        String invertfirst = "";

        for (int a = 0; a < size; a++) {
            String before = "";
            for (int i = 0; i < firstline.length() && firstline.length() != size; i++) {
                before += invert[Integer.parseInt(firstline.substring(i, i+1))];
            }
            firstline += before;
        }
        
        for (int i = 0; i < firstline.length(); i++) {
            invertfirst += invert[Integer.parseInt(firstline.substring(i, i+1))];
        }

        firstline = firstline.substring(0, size);
        invertfirst = invertfirst.substring(0, size);

        String[] characters = new String[invertfirst.length() + 1];

        for (int i = 0; i < invertfirst.length(); i++) {
            characters[i] = invertfirst.substring(i, i+1);
        }

        String symbols = "";
        String inversedsymbols = "";
        
        for (int a = 0; a < characters.length - 1; a++) {
            if (Integer.parseInt(characters[a]) == 1) {
                inversedsymbols += "+ ";
            } else if (Integer.parseInt(characters[a]) == 0) {
                inversedsymbols += "- ";
            }
        }

        for (int a = 0; a < characters.length - 1; a++) {
            if (Integer.parseInt(characters[a]) == 1) {
                symbols += "- ";
            } else if (Integer.parseInt(characters[a]) == 0) {
                symbols += "+ ";
            }
        }

        for (int b = 0; b < size; b++) {
            if (Integer.parseInt(characters[b]) == 1) {
                System.out.println(inversedsymbols);
            } else if (Integer.parseInt(characters[b]) == 0) {
                System.out.println(symbols);
            }
        }
    }
}