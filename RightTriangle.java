public class RightTriangle {
    public static void main(String[] args) {
        int number1 = Integer.parseInt(args[0]);
        int number2 = Integer.parseInt(args[1]);
        int number3 = Integer.parseInt(args[2]);
        boolean istrue = (Math.max(number3, 0) * Math.max(number3, 0)) == (Math.max(number1, 0) * Math.max(number1, 0)) + (Math.max(number2, 0) * Math.max(number2, 0));
        
        System.out.println(istrue);
    }
}
