package com.example.easy;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed.
 * If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 *
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 *
 *
 *
 * Example 1:
 *
 * Input: x = 123
 * Output: 321
 * Example 2:
 *
 * Input: x = -123
 * Output: -321
 * Example 3:
 *
 * Input: x = 120
 * Output: 21
 * Example 4:
 *
 * Input: x = 0
 * Output: 0
 *
 *
 * Constraints:
 *
 * -231 <= x <= 231 - 1
 */
public class ReverseInteger {
    public int reverse2(long x) {
        if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) {
            return 0;
        }
        int sign = x >= 0 ? 1 : -1;
        String value = String.valueOf(Math.abs(x));
        StringBuffer stringBuffer = new StringBuffer(value);
        long rl = Long.parseLong(stringBuffer.reverse().toString()) * sign;
        if (rl > Integer.MAX_VALUE || rl < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) rl;
    }

    public int reverse(long x) {
        long result = 0;
        while (true) {
            result = result * 10  + x % 10;
            x = x / 10;
            if (x == 0)
                break;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            result = 0;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        long x = 321;
        ReverseInteger revers = new ReverseInteger();

        System.out.println(x);
        System.out.println(revers.reverse(x));

        System.out.println(-x);
        System.out.println(revers.reverse(-x));

        x = 320;
        System.out.println(x);
        System.out.println(revers.reverse(x));

        x = 0;
        System.out.println(x);
        System.out.println(revers.reverse(x));

        x = 1534236469;
        System.out.println(x);
        System.out.println(revers.reverse(x));

        x = -1534236469;
        System.out.println(x);
        System.out.println(revers.reverse(x));
    }
}
