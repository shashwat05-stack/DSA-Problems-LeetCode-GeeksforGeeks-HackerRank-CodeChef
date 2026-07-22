# Type Conversion

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given a double value  **d**, typecast it to an  **integer**  value and print it.

 **Example:** 

```
Input: d = 10.23
Output: 10
Explanation: The integer value of 10.23 is 10
```

```
Input: d = 19.1
Output: 19
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-07-22T19:22:53.583Z  

```java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        double d = sc.nextDouble();

        // code here
        int i = (int)d;
        
        System.out.println(i);
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/type-conversion--151956/1)