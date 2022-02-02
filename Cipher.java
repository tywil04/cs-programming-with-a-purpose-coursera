import sun.jvm.hotspot.utilities.BitMap;

public class Cipher {
    public static char[] allchars = {
        'a',
        'b',
        'c',
        'd',
        'e',
        'f',
        'g',
        'h',
        'i',
        'j',
        'k',
        'l',
        'm',
        'n',
        'o',
        'p',
        'q',
        'r',
        's',
        't',
        'u',
        'v',
        'w',
        'x',
        'y',
        'z',
        '1',
        '2',
        '3',
        '4',
        '5',
        '6',
        '7',
        '8',
        '9',
        '0',
    };

    public static void main(String[] args) {
        String phrase = args[0];
        boolean[][][] cells = new boolean[phrase.length()][8][8];
        char[] phrasechars = phrase.toCharArray();

        for (int i = 0; i < phrase.length(); i++) {
            int numberof = 0;
            for (int c = 0; c < allchars.length; c++) {
                if (phrasechars[i] == allchars[c]) {
                    numberof = c;
                }
            }
            boolean[][] temp = new boolean[8][8];
            for (int a = 0; a < numberof + 1; a++) {
                int random = (int) (Math.round(Math.random() * 7));
                int random2 = (int) (Math.round(Math.random() * 7));
                if (temp[random][random2] == false) {
                    temp[random][random2] = true;
                } else a--;
            }
            cells[i] = temp;
        }

        for (int i = 0 ; i < cells.length; i++) {
            for (int j = 0; j < 8; j++) {
                String almost = "";
                for (int v = 0; v < 8; v++) {
                    if (cells[i][j][v] == true) {
                        almost += " + ";
                    } else {
                        almost += " - ";
                    }
                }
                System.out.println(almost);
            }
            System.out.println("");
            System.out.println("------------------------");
            System.out.println("");

        }

        Bitmap image = BitmapFactory.decodeStream(cells);
        imageView.setImageBitmap(image);
    }
}
