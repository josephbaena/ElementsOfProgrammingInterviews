package Chapter5;

/**
 * Compute parity of large number of 64-bit integers
 */
public class Problem1 {
    public static void main(String[] args) {
        long num = 246;
        System.out.println(Long.toBinaryString(num));
        System.out.println("parity = " + computeParity(num));
    }

    private static int computeParity(long num) {
        int result = 0;
        while (num != 0) {
            result += (num & 1);
            num >>= 1;
        }
        return result;
    }
}
