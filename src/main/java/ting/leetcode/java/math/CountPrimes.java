package ting.leetcode.java.math;

import java.util.Arrays;

public class CountPrimes {
    public int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i * i <= n; i++)
            if (isPrime(i)) count++;
        return count;
    }

    private boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}

class Eratosthenes {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int res = 0;
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) res++;
        }
        return res;
    }
}