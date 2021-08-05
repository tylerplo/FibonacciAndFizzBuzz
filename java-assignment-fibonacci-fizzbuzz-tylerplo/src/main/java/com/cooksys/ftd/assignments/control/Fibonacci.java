package com.cooksys.ftd.assignments.control;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * The Fibonacci sequence is simply and recursively defined: the first two elements are `1`, and
 * every other element is equal to the sum of its two preceding elements. For example:
 * <p>
 * [1, 1] =>
 * [1, 1, 1 + 1]  => [1, 1, 2] =>
 * [1, 1, 2, 1 + 2] => [1, 1, 2, 3] =>
 * [1, 1, 2, 3, 2 + 3] => [1, 1, 2, 3, 5] =>
 * ...etc
 */
public class Fibonacci {
	public static long fibonacci1(int n) {
		if (n == 0 ) {
			return 0;
		}else if (n == 1) {
			return 1;
		}
		long nMinus1 = 1;
		long nMinus2 = 0;
		long fib = 0;
		for(int i =1; i<n; i++) {
			fib = (nMinus2 + nMinus1);
			nMinus2 = nMinus1;
			nMinus1 = fib;
		}
		return fib;
	}

    /**
     * Calculates the value in the Fibonacci sequence at a given index. For example,
     * `atIndex(0)` and `atIndex(1)` should return `1`, because the first two elements of the
     * sequence are both `1`.
     *
     * @param i the index of the element to calculate
     * @return the calculated element
     * @throws IllegalArgumentException if the given index is less than zero
     */
    public static int atIndex(int i) throws IllegalArgumentException {
        if (i < 0) {
        	throw new IllegalArgumentException();
        }else if (i == 0 || i == 1) {
        	return 1;
        }
        int[] answer = fibonacci(i + 1);
        return answer[i];
    }

    /**
     * Calculates a slice of the fibonacci sequence, starting from a given start index (inclusive) and
     * ending at a given end index (exclusive).
     *
     * @param start the starting index of the slice (inclusive)
     * @param end   the ending index of the slice(exclusive)
     * @return the calculated slice as an array of int elements
     * @throws IllegalArgumentException if either the given start or end is negative, or if the
     *                                  given end is less than the given start
     */
    public static int[] slice(int start, int end) throws IllegalArgumentException {
        if (start < 0 || end < 0 || end < start) {
        	throw new IllegalArgumentException();
        }
        int[] sequence = fibonacci(end);
        int[] answer = new int[end - start];
        for(int i= 0; i<answer.length; i++) {
        	answer[i] = sequence[start + i];
        }
        return answer;
        
    }

    /**
     * Calculates the beginning of the fibonacci sequence, up to a given count.
     *
     * @param count the number of elements to calculate
     * @return the beginning of the fibonacci sequence, up to the given count, as an array of int elements
     * @throws IllegalArgumentException if the given count is negative
     */
    public static int[] fibonacci(int count) throws IllegalArgumentException {
        if (count < 0) {
        	throw new IllegalArgumentException();
        }
        int[] sequence = new int[count];
        for (int i = 0; i<count; i++) {
        	if (i<2) {
        		sequence[i] = 1;
        	}else {
        		sequence[i] = sequence[i-1] + sequence[i-2];
        	}
        }
        return sequence;
    }
}
