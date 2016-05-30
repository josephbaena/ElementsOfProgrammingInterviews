package Chapter6;

import Utilities.Util;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Write a function that takes an array A of length n and an index i into into A,
 * and rearranges the elements such that all elements less than A[i] appear first,
 * followed by elements equal to A[i], followed by elements greater than A[i].
 * Your algorithm should have O(1) space complexity and O(n) time complexity.
 */
public class Problem1 {

    public static void main(String[] args) throws IllegalArgumentException {
        final int n = 10;
        final int[] A = getSampleArray(n);

        final int i = 4; // index into A, "pivot"

        if ((i < 0) || (i >= n))
            throw new IllegalArgumentException("value for i should be between 0 and " + (n-1));

        System.out.println("pivot index = " + i + " value = " + A[i]);
        Util.printArray(A);
        rearrangeArray(A, i);
        Util.printArray(A);
    }

    private static void rearrangeArray(int[] A, int pivotIndex) {
        int smaller = 0, current = 0, larger = A.length-1;

        while (current <= larger) {
            if (A[current] < A[pivotIndex]) {
                swap(A, smaller, current);
                smaller++;
                current++;
            } else if (A[current] > A[pivotIndex]) {
                swap(A, current, larger);
                larger--;
            } else if (A[current] == A[pivotIndex]) {
                current++;
            }
        }
    }

    private static void swap(int[] A, int left, int right) {
        int temp = A[left];
        A[left] = A[right];
        A[right] = temp;
    }

    private static int[] getSampleArray(int n) {
        int[] A = new int[n];
        for (int i = 0; i < A.length; i++) {
            A[i] = ThreadLocalRandom.current().nextInt(1, 10);
        }
        return A;
    }

}
