public class Encrypt {
    public static char[] all = {
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
    };

    public static char[] GenerateKey() {
        boolean[] used = new boolean[all.length];
        char[] finished = new char[all.length];
        int count = 0;

        for (int i = 0; i < all.length; i++) {
            int random = (int) Math.round(Math.random() * (all.length - 1));
            
            if (used[random] == false) {
                used[random] = true;
                count++;
                finished[count] += all[random];
            }
        }

        return finished;
    }

    public static String GenerateDecoy(int length, char[] key) {
        String finished = "";
        for (int i = 0; i < length; i++) {
            int random = (int) Math.round(Math.random() * length);
            finished += key[random];
        }
        return finished;
    }

    public static String Interlace(String a, String b) {
        char[] aarray = a.toCharArray();
        char[] barray = b.toCharArray();
        String finished = "";

        for (int i = 0; i < aarray.length; i++) {
            finished += aarray[i] + barray[i];
        }

        return finished;
    }

    public static String Encode(String a, char[] key) {
        String finished = "";

        for (int i = 0; i < a.length(); i++) {
            boolean found = false;
            char current = a.toCharArray()[i];

            for (char ai : all) {
                if (ai == current) {
                    found = true;
                    break;
                }
            }

            if (found == true) {
                finished += key[i];
            }
        }

        return finished;
    }

    public static void main(String[] args) {
        char[] key1 = GenerateKey();
        char[] key2 = GenerateKey();
        char[] key3 = GenerateKey();

        System.out.println(GenerateDecoy(16, key1));
        System.out.println(Encode(args[0], key1));
    }
}
