public class Test {
    public static int Q4(int n, int count)
    {
      if (n <= 0) return 0;
      StdOut.println(n);
      Q4(n-2);
      Q4(n-3);
      StdOut.println(n);
      return count++;
    }
    public static void main(String[] args) {
      int Count = 0;
      Count = Q4(7, Count);
    }
}
