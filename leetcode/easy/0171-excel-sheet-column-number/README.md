# Excel Sheet Column Number

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given a string `columnTitle` that represents the column title as appears in an Excel sheet, return  *its corresponding column number*.

For example:

```
A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 
...

```

 

 **Example 1:** 

```
Input: columnTitle = "A"
Output: 1

```

 **Example 2:** 

```
Input: columnTitle = "AB"
Output: 28

```

 **Example 3:** 

```
Input: columnTitle = "ZY"
Output: 701

```

 

 **Constraints:** 

- 1 <= columnTitle.length <= 7
- columnTitle consists only of uppercase English letters.
- columnTitle is in the range ["A", "FXSHRXW"].

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 91.08%)  
**Memory:** 43.4 MB (beats 86.68%)  
**Submitted:** 2026-08-24T16:11:54.711Z  

```java
class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        for(int i = 0; i< columnTitle.length(); i++){
            char ch = columnTitle.charAt(i);
            int value = ch - 'A' + 1;
            result = result * 26 + value;
        }
        return result;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/excel-sheet-column-number/)