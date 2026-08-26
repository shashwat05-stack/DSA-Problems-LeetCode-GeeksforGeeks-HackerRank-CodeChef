# Intersection of Two Arrays

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given two integer arrays `nums1` and `nums2`, return  *an array of their intersection*. Each element in the result must be  **unique**  and you may return the result in  **any order**.

 

 **Example 1:** 

```
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]

```

 **Example 2:** 

```
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.

```

 

 **Constraints:** 

- 1 <= nums1.length, nums2.length <= 1000
- 0 <= nums1[i], nums2[i] <= 1000

## Solution

**Language:** Java  
**Runtime:** 3 ms (beats 46.85%)  
**Memory:** 45.3 MB (beats 5.61%)  
**Submitted:** 2026-08-26T13:13:32.272Z  

```java
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();

        for(int num : nums1){
            s1.add(num);
        }
        for(int num : nums2){
            s2.add(num);
        }

        int[] res = new int[s1.size()];

        int k = 0;

        for(int num : s1){
            if(s2.contains(num)){
                res[k] = num;
                k = k + 1;
            }
        }

        return Arrays.copyOfRange(res, 0, k);
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/intersection-of-two-arrays/)