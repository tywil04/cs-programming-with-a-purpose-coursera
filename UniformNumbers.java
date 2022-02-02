public class UniformNumbers {
    public static void main(String[] args) {
        double number1 = Math.random();
        double number2 = Math.random();
        double number3 = Math.random();
        double number4 = Math.random();
        double number5 = Math.random();
        double average = (number1 + number2 + number3 + number4 + number5) / 5;
        double smallset1 = Math.min(number1, number2);
        double smallset2 = Math.min(number2, number3);
        double smallset3 = Math.min(number3, number4);
        double smallset4 = Math.min(number4, number5);
        double smallset5 = Math.min(smallset1, smallset2);
        double smallset6 = Math.min(smallset2, smallset3);
        double smallset7 = Math.min(smallset3, smallset4);
        double smallset8 = Math.min(smallset5, smallset6);
        double smallset9 = Math.min(smallset6, smallset7);
        double smallest = Math.min(smallset8, smallset9);
        double largeset1 = Math.max(number1, number2);
        double largeset2 = Math.max(number2, number3);
        double largeset3 = Math.max(number3, number4);
        double largeset4 = Math.max(number4, number5);
        double largeset5 = Math.max(largeset1, largeset2);
        double largeset6 = Math.max(largeset2, largeset3);
        double largeset7 = Math.max(largeset3, largeset4);
        double largeset8 = Math.max(largeset5, largeset6);
        double largeset9 = Math.max(largeset6, largeset7);
        double largest = Math.max(largeset8, largeset9);
        
        System.out.println("Number 1: " + number1);
        System.out.println("Number 2: " + number2);
        System.out.println("Number 3: " + number3);
        System.out.println("Number 4: " + number4);
        System.out.println("Number 5: " + number5);
        System.out.println("Smallest Number: " + smallest);
        System.out.println("Largest Number: " + largest);
        System.out.println("Average Number: " + average);
    }
}
