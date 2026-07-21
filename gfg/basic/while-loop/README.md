# While Loop

![Difficulty](https://img.shields.io/badge/Difficulty-Basic-red)

## Problem

Given a number  **x**, the task is to print the numbers from  **x**  to 0 in decreasing order in a single line.

 **Example:** 

```
Input: x = 3
Output: 3 2 1 0
Explanation: Numbers in decreasing order from 3 are 3 2 1 0.
```

```
Input: x = 5
Output: 5 4 3 2 1 0
Explanation: Numbers in decreasing order from 5 are 5 4 3 2 1 0.
```

**Constraints:
**0 ≤ x ≤ 100

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-07-21T20:24:14.716Z  

```java
class Solution {
    public static void utility(int x) {
        // code here
        while(x>=0){
            System.out.print(x+" ");
            x--;
        }
        
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/while-loop/1)