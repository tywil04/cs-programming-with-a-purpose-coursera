public class Ascending {
    public static void main(String[] args) {
        int number1 = Integer.parseInt(args[0]);
        int number2 = Integer.parseInt(args[1]);
        int number3 = Integer.parseInt(args[2]);
        int smallset1 = Math.min(number1, number2);
        int smallset2 = Math.min(number2, number3);
        int smallest = Math.min(smallset1, smallset2);
        int largeset1 = Math.max(number1, number2);
        int largeset2 = Math.max(number2, number3);
        int largest = Math.max(largeset1, largeset2);
        int middle = 0;

        if (number1 != smallest && number1 != largest) {
            middle = number1;
        } else if (number2 != smallest && number2 != largest) {
            middle = number2;
        } else if (number3 != smallest && number3 != largest) {
            middle = number3;
        } 

        System.out.println(smallest);
        System.out.println(middle);
        System.out.println(largest);
    }
}
