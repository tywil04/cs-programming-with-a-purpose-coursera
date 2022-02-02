public class CodeDecrypt {
    public static char[] charactertemplate = {
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
        'A',
        'B',
        'C',
        'D',
        'E',
        'F',
        'G',
        'H',
        'I',
        'J',
        'K',
        'L',
        'M',
        'N',
        'O',
        'P',
        'Q',
        'R',
        'S',
        'T',
        'U',
        'V',
        'W',
        'X',
        'Y',
        'Z',
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
        '!',
        '£',
        '&',
        '%',
        '$',
        '@',
        '#',
        '?',
        ':',
        ';',
        '.',
        '·', 
        '/',
        '[',
        ']',
        '(',
        ')',
        '{',
        '}',
        '*',
        '€',
        '¢',
        '«',
        '»',
        'µ',
        'æ',
        'ł',
        '¶',
        'ŧ',
        '←',
        '↓',
        '→',
        'ß',
        'ø',
        'þ',
        'ð',
        'đ',
        'ŋ',
        'ħ',
        'ĸ',
        'ł',
        '|',         
    };

    public static String shuffle(String main, int size) {
        String done = main;
        boolean flip = false;
        for (int i = 0; i < size + 1; i++) {
            while (flip == false) {
                if (size > charactertemplate.length * 2) {
                    size -= charactertemplate.length;
                } else {
                    flip = true;
                }
            }
            String finished = String.valueOf(done.substring(0, done.length() - 1));
            String finished2 = String.valueOf(done.substring(done.length() - 1, done.length()));
            done = finished2 + finished;
        }
        return done;
    } 

    public static String decodeKey(String key) {
        char[] keyarray = key.toCharArray();
        boolean isone = false;
        String shuffle = "";
        String rest = "";

        for (int i = 0; i < key.length(); i++) {
            if (i == 0) {
                if (Integer.parseInt(String.valueOf(keyarray[i])) == 1) {
                    isone = true;
                } else {
                    isone = false;
                }
            }
            if (isone == true) {
                if (i < 4 && i > 0) {
                    shuffle += keyarray[i];
                } else if (i != 0) {
                    rest += keyarray[i];
                }
            } else if (isone == false) {
                if (i < key.length() - 3 && i > 0) {
                    rest += keyarray[i];
                } else if (i >= key.length() - 3) {
                    shuffle += keyarray[i];
                }
            }
        }
        return shuffle(rest, charactertemplate.length - Integer.parseInt(shuffle));
    }

    public static int findIndex(char[] arr, char t) { 
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == t) {
                return i;
            }
        }
        return -1;
    } 

    public static String uninterlace(String code) {
        char[] codearray = code.substring(1, code.length()).toCharArray();
        String one = "";
        String two = "";
        for (int i = 0; i < codearray.length; i++) {
            if (i % 2 == 0) {
                one += codearray[i];
            } else {
                two += codearray[i];
            }
        }
        if (Integer.parseInt(code.substring(0, 1)) == 0) {
            return one;
        } else {
            return two;
        }
    }
    
    public static String rest = "";
    public static String extractKey(String code) {
        if (Integer.parseInt(String.valueOf(code.subSequence(0, 1))) == 1) {
            int keylen = Integer.parseInt(code.substring(code.length() - 3, code.length()));
            String key = code.substring(code.length() - 3 - keylen, code.length() - 3);
            rest = code.substring(1, code.length() - 3 - keylen);
            return key;
        } else if (Integer.parseInt(String.valueOf(code.subSequence(0, 1))) == 0) {
            int keylen = Integer.parseInt(code.substring(1, 4));
            String key = code.substring(4, 4 + keylen);
            rest = code.substring(4 + keylen, code.length());
            return key;
        }
        return "";
    }

    public static String decodePhrase(String a, String key) {
        String finished = "";
        char[] aarray = a.toCharArray();
        char[] keyarray = key.toCharArray();

        for (int i = 0; i < aarray.length; i++) {
            if (findIndex(keyarray, aarray[i]) != -1) {
                finished += charactertemplate[findIndex(keyarray, aarray[i])];
            }
        }
        return finished;
    }

    public static String decodeRotorPhrase(String phrase) {
        String part1 = phrase.substring(0, phrase.length() / 2);
        String part2 = phrase.substring(0, phrase.length() / 2);
        char[][] encodearray = new char[charactertemplate.length][charactertemplate.length];
        char[] phrasearray = part1.toCharArray();
        char[] codewordarray = part2.toCharArray();

        for (int i = 0; i < charactertemplate.length; i++) {
            for (int j = 0; j < charactertemplate.length; j++) {
                String tosplit = String.valueOf(charactertemplate);
                tosplit = shuffle(tosplit, tosplit.length() - 1 - i);
                encodearray[i][j] = tosplit.toCharArray()[j];
            }
        }

        String phrasebuild = "";
        for (int i = 0; i < encodearray.length; i++) {
            for (int j = 0; j < codewordarray.length; j++) {
                for (int v = 0; v < phrasearray.length; v++) {
                    phrasebuild += encodearray[i][findIndex(encodearray[codewordarray[j]], phrasearray[v])];
                }
            }
        }

        return phrasebuild;
    }
    public static void main(String[] args) {
        String code = args[0];
        String uninterlacedcode = uninterlace(code);
        String key = decodeKey(extractKey(uninterlacedcode));
        String part1 = "";

        if (Integer.parseInt(uninterlacedcode.substring(0, 1)) == 1) {
            int keylen = Integer.parseInt(uninterlacedcode.substring(uninterlacedcode.length() - 3, uninterlacedcode.length()));
            part1 = uninterlacedcode.substring(1, uninterlacedcode.length() - keylen - 3);
        } else if (Integer.parseInt(uninterlacedcode.substring(0, 1)) == 0) {
            int keylen = Integer.parseInt(uninterlacedcode.substring(1, 4));
            part1 = uninterlacedcode.substring(4 + keylen, uninterlacedcode.length());
        }

        String part2 = decodePhrase(part1, key);
        String part2uninterlaced = uninterlace(part2);
        String key2 = decodeKey(extractKey(part2uninterlaced));
        String part3 = "";

        if (Integer.parseInt(part2uninterlaced.substring(0, 1)) == 1) {
            int keylen = Integer.parseInt(part2uninterlaced.substring(part2uninterlaced.length() - 3, part2uninterlaced.length()));
            part3 = part2uninterlaced.substring(1, part2uninterlaced.length() - keylen - 3);
        } else if (Integer.parseInt(part2uninterlaced.substring(0, 1)) == 0) {
            int keylen = Integer.parseInt(part2uninterlaced.substring(1, 4));
            part3 = part2uninterlaced.substring(4 + keylen, part2uninterlaced.length());
        }

        String part4 = decodePhrase(part3, key2);

        String decrypted = decodeRotorPhrase(part4);

        System.out.println("");
        System.out.println(decrypted);
        System.out.println("");
        System.out.println(part4);
        System.out.println("");
        System.out.println(key);
        System.out.println("");
        System.out.println(String.valueOf(charactertemplate));
    }
}
