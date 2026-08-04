# Maximum Product of Three Numbers

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given an integer array `nums`,  *find three numbers whose product is maximum and return the maximum product*.

 

 **Example 1:** 

```
Input: nums = [1,2,3]
Output: 6

```

 **Example 2:** 

```
Input: nums = [1,2,3,4]
Output: 24

```

 **Example 3:** 

```
Input: nums = [-1,-2,-3]
Output: -6

```

 

 **Constraints:** 

- 3 <= nums.length <= 104
- -1000 <= nums[i] <= 1000

## Solution

**Language:** Java  
**Runtime:** 17 ms (beats 7.38%)  
**Memory:** 48.1 MB (beats 34.26%)  
**Submitted:** 2026-08-04T17:11:17.461Z  

```java
class Solution {
    public int maximumProduct(int[] n) {
        Arrays.sort(n);
        return Math.max(n[n.length - 1] * n[n.length - 2] * n[n.length - 3],
        n[n.length - 1] * n[0] * n[1]);
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/maximum-product-of-three-numbers/)