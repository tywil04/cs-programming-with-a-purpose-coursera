import java.io.FileWriter;
import java.io.IOException;

public class CodeEncrypt {
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
    
    public static String rotorsettings = "";
    public static char[][] rotors = new char[2][charactertemplate.length];
    
    public static void initRotors() {
        int random = (int) (Math.round(Math.random() * (charactertemplate.length - 1)));
        for (char[] rotor : rotors) {
            for (int i = 0; i < rotor.length; i++) {
                rotor[i] = charactertemplate[i];
            }
        }

        for (int i = 0; i < rotors.length; i++) {
            rotors[i] = shuffle(String.valueOf(rotors[i]), random + i).toCharArray();
        }

        String part1 = "";
        if (random < 10) {
            part1 += "00" + String.valueOf(random);
        } else if (random < 100 && random >= 10) {
            part1 += "0" + String.valueOf(random);
        } else {
            part1 += String.valueOf(random);
        }

        String part2 = "";
        if (Integer.parseInt(String.valueOf(String.valueOf(rotors.length).toCharArray().length)) < 10) {
            part2 = String.valueOf(rotors.length) + String.valueOf("0") + String.valueOf(String.valueOf(rotors.length).toCharArray().length);
        } else {
            part2 = String.valueOf(rotors.length) + String.valueOf(String.valueOf(rotors.length).toCharArray().length);
        }

        rotorsettings += part1 + part2;      
        String temp = "";
        for (char c : rotorsettings.toCharArray()) {
            temp += charactertemplate[Integer.parseInt(String.valueOf(c))];
        }
        rotorsettings = temp;

        boolean where = Math.random() <= 0.5;
        String finishedrotors = "";
        String randomstring2 = generateRandomString(rotorsettings.length());
        if (where == true) {
            finishedrotors = "0" + interlaceString(rotorsettings, randomstring2);
        } else if (where == false) {
            finishedrotors = "1" + interlaceString(randomstring2, rotorsettings);
        }

        String part3 = "";
        if (finishedrotors.length() < 10) {
            part3 = "00" + String.valueOf(finishedrotors.length());
        } else if (finishedrotors.length() < 100 && finishedrotors.length() >= 10) {
            part3 = "0" + String.valueOf(finishedrotors.length());
        } else {
            part3 = String.valueOf(finishedrotors.length());
        }

        rotorsettings = finishedrotors + part3;
    }

    public static String generateKey() {
        int keyshuffle = Math.abs((int) (Math.round(Math.random() * (charactertemplate.length - 1))));
        boolean[] used = new boolean[charactertemplate.length];
        char[] finished = new char[charactertemplate.length];
        int count = 0;

        for (int i = 0; i < charactertemplate.length; i++) {
            int random = (int) Math.round(Math.random() * (charactertemplate.length - 1));
            
            if (used[random] == false) {
                used[random] = true;
                finished[count] += charactertemplate[random];
                count++;
            } else i--;
        }

        String finishedstring = shuffle(String.valueOf(finished), keyshuffle);
        boolean pos = Math.random() < 0.5;

        if (keyshuffle < 10) {
            if (pos == true) {
                finishedstring = "00" + keyshuffle + finishedstring;
            } else if (pos == false) {
                finishedstring += "00" + keyshuffle;
            }
        } else if (keyshuffle < 100 && keyshuffle >= 10) {
            if (pos == true) {
                finishedstring = "0" + keyshuffle + finishedstring;
            } else if (pos == false) {
                finishedstring += "0" + keyshuffle;
            }
        } else {
            if (pos == true) {
                finishedstring = keyshuffle + finishedstring;
            } else if (pos == false) {
                finishedstring += keyshuffle;
            }
        }

        if (pos == true) {
            finishedstring = "1" + finishedstring;
        } else if (pos == false) {
            finishedstring = "0" + finishedstring;
        }

        return finishedstring;
    }

    public static String generateRandomString(int length) {
        String finished = "";
        for (int i = 0; i < length; i++) {
            int random = (int) (Math.round(Math.random() * (charactertemplate.length - 1)));
            finished += charactertemplate[random];
        }
        return finished;
    }

    public static String interlaceString(String a, String b) {
        char[] aarray = a.toCharArray();
        char[] barray = b.toCharArray();
        String finished = "";
        for (int i = 0; i < aarray.length; i++) {
            finished += String.valueOf(aarray[i]) + String.valueOf(barray[i]);
        }
        return finished;
    }

    public static int findIndex(char[] arr, char t) { 
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == t) {
                return i;
            }
        }
        return -1;
    } 
 
    public static String decodeKey(String key) {
        boolean pos = Integer.parseInt(key.substring(0, 1)) == 1;
        String bulk = "";
        int keyshufflelength = 0;

        if (pos == true) {
            bulk = key.substring(4, key.length());
            keyshufflelength = Integer.parseInt(key.substring(1, 4));
        } else if (pos == false) {
            bulk = key.substring(1, key.length() - 3);
            keyshufflelength = Integer.parseInt(key.substring(key.length() - 3, key.length()));
        }

        String finished = shuffle(bulk, charactertemplate.length - keyshufflelength);
        return finished;
    }

    public static String encodeRotorPhrase(String phrase) {
        String codeword = generateRandomString(phrase.length());
        char[][] encodearray = new char[charactertemplate.length][charactertemplate.length];
        char[] phrasearray = phrase.toCharArray();
        char[] codewordarray = codeword.toCharArray();

        for (int i = 0; i < charactertemplate.length; i++) {
            for (int j = 0; j < charactertemplate.length; j++) {
                String tosplit = String.valueOf(charactertemplate);
                tosplit = shuffle(tosplit, tosplit.length() - 1 - i);
                encodearray[i][j] = tosplit.toCharArray()[j];
            }
        }

        String phrasebuild = "";
        for (int i = 0; i < phrasearray.length; i++) {
            int index1 = findIndex(charactertemplate, phrasearray[i]);
            int index2 = findIndex(charactertemplate, codewordarray[i]);
            phrasebuild += encodearray[index1][index2];
        }
        phrasebuild += codeword;
        System.out.println(phrasebuild);
        return phrasebuild;
    }

    public static String encodePhrase(String a, String key) {
        String finished = "";
        char[] aarray = a.toCharArray();
        char[] keyarray = decodeKey(key).toCharArray();

        for (int i = 0; i < aarray.length; i++) {
            if (findIndex(charactertemplate, aarray[i]) != -1) {
                finished += keyarray[findIndex(charactertemplate, aarray[i])];
            } else if (findIndex(charactertemplate, aarray[i]) == -1 && aarray[i] == '¬') {
                finished += '¬';
            }
        }
        return finished;
    }


    public static void main(String[] args) {
        initRotors();

        System.out.println(charactertemplate.length);

        String phrase = args[0];
        String randomkey = generateKey();
        String randomkey2 = generateKey();
        String randomkey3 = generateKey();

        int count = 0;
        int[] pos = new int[4];
        boolean[] used = new boolean[pos.length];
        for (int i = 0; i < 3; i++) {
            int random = (int) (Math.round(Math.random() * 2));
            if (used[random] == false) {
                pos[count] = random;
                used[random] = true;
                count++;
            } else i--;
        }

        String tempphrase = encodePhrase(encodeRotorPhrase(phrase), randomkey3);
        String tempphrase2 = "";
        boolean tempkeypos = (Math.random() <= 0.5);
        if (tempkeypos == true) {
            tempphrase2 = "1" + tempphrase + randomkey3 + String.valueOf(randomkey3.length());
        } else if (tempkeypos == false) {
            tempphrase2 = "0" + String.valueOf(randomkey3.length()) + randomkey3 + tempphrase;
        }

        System.out.println("");
        System.out.println("Rotor: " + tempphrase2);

        phrase = encodePhrase(tempphrase2, randomkey);
        boolean keypos = (Math.random() <= 0.5);
        String tempphrase3 = "";
        if (keypos == true) {
            tempphrase3 = "1" + phrase + randomkey + String.valueOf(randomkey.length());
        } else if (keypos == false) {
            tempphrase3 = "0" + String.valueOf(randomkey.length()) + randomkey + phrase;
        }
        phrase = tempphrase3;

        System.out.println("");
        System.out.println("Phrase Encode1: " + phrase);

        String tempphrase4 = "";
        String randomstring = generateRandomString(phrase.length());
        boolean interpos = (Math.random() <= 0.5);
        if (interpos == true) {
            tempphrase4 = "0" + interlaceString(phrase, randomstring);
        } else if (interpos == false) {
            tempphrase4 = "1" + interlaceString(randomstring, phrase);
        }
        phrase = tempphrase4;

        System.out.println("");
        System.out.println("Interlace Random1: " + phrase);

        String tempphrase5 = encodePhrase(phrase, randomkey2);
        String tempphrase6 = "";
        boolean keypos2 = (Math.random() <= 0.5);
        if (keypos2 == true) {
            tempphrase6 = "1" + tempphrase5 + randomkey2 + String.valueOf(randomkey2.length());
        } else if (keypos2 == false) {
            tempphrase6 = "0" + String.valueOf(randomkey2.length()) + randomkey2 + tempphrase5;
        }
        phrase = tempphrase6;

        System.out.println("");
        System.out.println("Phrase Encode2: " + phrase);

        String tempphrase7 = "";
        String randomstring2 = generateRandomString(phrase.length());
        boolean interpos2 = (Math.random() <= 0.5);
        if (interpos2 == true) {
            tempphrase7 = "0" + interlaceString(phrase, randomstring2);
        } else if (interpos2 == false) {
            tempphrase7 = "1" + interlaceString(randomstring2, phrase);
        }
        phrase = tempphrase7;

        System.out.println("");

        System.out.println(phrase);
        System.out.println("");
        System.out.println("1 Encoded: " + randomkey);
        System.out.println("");
        System.out.println("1 Decoded: " + decodeKey(randomkey));
        System.out.println("");
        System.out.println("2 Encoded: " + randomkey2);
        System.out.println("");
        System.out.println("2 Decoded: " + decodeKey(randomkey2));
        //String[] temp = new String[3];
        //int randomint = (int) (Math.round(Math.random() * phrase.length()));
        //int randomint2 = (int) (Math.round(Math.random() * phrase.length()));
        //String randomintString = "";
        //String randomint2String = "";
        //temp[0] = generateRandomString(randomint);
        //temp[1] = encodedcharfinished;
        //temp[2] = generateRandomString(randomint2);

        //if (randomint < 10) {
        //    randomintString = "00" + String.valueOf(randomint);
        //} else if (randomint < 100 && randomint >= 10) {
        //    randomintString = "0" + String.valueOf(randomint);
        //} else {
        //    randomintString = String.valueOf(randomint);
        //}

        //if (randomint2 < 10) {
        //    randomint2String = "00" + String.valueOf(randomint2);
        //} else if (randomint2 < 100 && randomint2 >= 10) {
        //    randomint2String = "0" + String.valueOf(randomint2);
        //} else if (randomint2 < 1000 && randomint2 >= 100) {
        //    randomint2String = String.valueOf(randomint2);
        //}

        //part1 = String.valueOf(pos[0]) + String.valueOf(pos[1]) + String.valueOf(pos[2]) + temp[pos[0]] + temp[pos[1]] + temp[pos[2]] + randomintString + randomint2String;
        //part1 = interlaceString(generateRandomString(part1.length()), part1);
        //part1 = encodePhrase(part1, randomkey);
        //boolean posbool = (Math.random() < 0.5);
        //if (posbool == false) {
        //    mainfinished = interlaceString(generateRandomString((randomkey + String.valueOf(whitespaces) + part1 + generateRandomString(part1.length() / 2)).length()), (randomkey + String.valueOf(whitespaces)) + part1 + generateRandomString(part1.length() / 2));
        //} else if (posbool == true) {
        //    mainfinished = interlaceString(generateRandomString((randomkey + String.valueOf(whitespaces) + part1 + generateRandomString(part1.length() / 2)).length()), generateRandomString(part1.length() / 2) + (randomkey + String.valueOf(whitespaces)) + part1);
        //}
        //if (posbool == false) {
        //    mainfinished = "1" + mainfinished;
        //} else if (posbool == true) {
        //    mainfinished = "0" + mainfinished;
        //}
        
        //try {
        //    FileWriter keyfile = new FileWriter("code.keyfile");
        //    keyfile.write(rotorsettings);
        //    keyfile.close();
        //} catch (IOException e) {}


        //String actuallyfinished = "";
        //for (char c : mainfinished.toCharArray()) {
        //    if (Character.isWhitespace(c) == true) {
        //        int random = (int) (Math.round(Math.random() * (whitespaces.length - 1)));
        //        char randomletter = whitespaces[random];
        //        actuallyfinished += String.valueOf(randomletter);
        //    } else {
        //        actuallyfinished += String.valueOf(c);
        //    }
        //}

        //System.out.println(actuallyfinished);
    }
}