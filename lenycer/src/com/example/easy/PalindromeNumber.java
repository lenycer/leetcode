package com.example.easy;

/**
 * PalindromeNumber is like 121, 1331, 43234
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        int org = x;
        int result = 0;
        while (x > 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        if (result == org)
            return true;

        return false;
    }

    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();

        System.out.println(palindromeNumber.isPalindrome(121));
        System.out.println(palindromeNumber.isPalindrome(1211));
        System.out.println(palindromeNumber.isPalindrome(1001));
        System.out.println(palindromeNumber.isPalindrome(0));
        System.out.println(palindromeNumber.isPalindrome(7));
    }
}
