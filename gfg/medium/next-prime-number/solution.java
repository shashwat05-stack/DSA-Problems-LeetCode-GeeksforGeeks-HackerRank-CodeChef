class Solution {

    static boolean isPrime(int n) {

        if (n <= 1)
            return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }

        return true;
    }

    public static int nextPrime(int n) {

        n++;

        while (!isPrime(n)) {
            n++;
        }

        return n;
    }
}