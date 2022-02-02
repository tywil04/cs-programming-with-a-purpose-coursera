public class Ramanujan {
    public static boolean isRamanujan(long n) {
        long i = 1;
        long j = (long) Math.floor(Math.pow(n, 1.0 / 3));
        int count = 0;
        long sum;
        
        while (i < j) {
            sum = (long) (i * i * i) + (long) (j * j * j);
            
            if (sum > n) {
                j += -1;
            } else if (sum < n) {
                i += 1;
            } else {  
                count++;
                i += 1;
            }
        }
        return (count >= 2);
    }
    
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        System.out.println(isRamanujan(n));
    }    
}    