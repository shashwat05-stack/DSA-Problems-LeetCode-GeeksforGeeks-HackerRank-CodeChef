# Single Element in a Sorted Array

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return  *the single element that appears only once*.

Your solution must run in `O(log n)` time and `O(1)` space.

 

 **Example 1:** 

```
Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2

```

 **Example 2:** 

```
Input: nums = [3,3,7,7,10,11,11]
Output: 10

```

 

 **Constraints:** 

- 1 <= nums.length <= 105
- 0 <= nums[i] <= 105

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 53 MB (beats 39.30%)  
**Submitted:** 2026-07-26T22:17:54.109Z  

```java
class Solution {
    public int singleNonDuplicate(int[] nums) {
      int start = 0;
        int end = nums.length - 1;

        while(start < end){
            int mid = start +(end - start)/2;
            //mid is even
            if(mid%2==0){
            if(nums[mid]==nums[mid+1]){
                start = mid + 2;
            }
            else{
                end = mid;
            }
            }
            //mid is odd
            else{
                if(nums[mid] == nums[mid-1]){
                    start = mid + 1;
                }
                else{
                end = mid - 1;
            }
            }
            
        }
        return nums[start];
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/single-element-in-a-sorted-array/)