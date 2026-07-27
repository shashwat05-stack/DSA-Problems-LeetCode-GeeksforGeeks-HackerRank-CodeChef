# Next Prime Number

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an integer **n**  **.** Write a program to find the first prime number greater than  **n.** 

 **Examples:** 

```
Input: n = 15
Output: 17
Explanation: 17 is next prime number.
```

```
Input: n = 7
Output: 11
Explanation: 11 is the prime number next to 7.
```

 **Constraints:** 
1 <= n <= 500

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-07-27T07:14:20.265Z  

```java
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
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/next-prime-number/1)