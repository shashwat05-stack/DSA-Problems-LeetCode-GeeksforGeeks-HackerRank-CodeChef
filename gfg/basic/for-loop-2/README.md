# Even Positioned Characters

![Difficulty](https://img.shields.io/badge/Difficulty-Basic-red)

## Problem

You are given a  **String S**, you need to print its characters at even indices(index starts at 0).

 **Examples:** 

```
Input: s = "Geeks"
Output: Ges
Explanation: The even indices (0, 2 & 4) characters are printed.
```

```
Input: s = "DoctorPhenomenal"
Output: DcoPeoea
Explanation: The even indices characters are printed.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-07-22T09:41:29.713Z  

```java
class Solution {
    public static void utility(String s) {
        // code here
        for(int i=0;i<s.length();i += 2){
            System.out.print(s.charAt(i));
        }
        return;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/for-loop-2/1)