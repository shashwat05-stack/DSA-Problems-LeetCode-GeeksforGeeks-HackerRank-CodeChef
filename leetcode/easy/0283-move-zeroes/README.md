# Move Zeroes

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given an integer array `nums`, move all `0`'s to the end of it while maintaining the relative order of the non-zero elements.

 **Note**  that you must do this in-place without making a copy of the array.

 

 **Example 1:** 

```
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

```

 **Example 2:** 

```
Input: nums = [0]
Output: [0]

```

 

 **Constraints:** 

- 1 <= nums.length <= 104
- -231 <= nums[i] <= 231 - 1

 

 **Follow up:**  Could you minimize the total number of operations done?

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 92.11%)  
**Memory:** 47.6 MB (beats 76.34%)  
**Submitted:** 2026-07-30T10:34:19.386Z  

```java
class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;

        for(int i = 0; i<nums.length;i++){
            if(nums[i] != 0){
                swap(nums,i,j); 
                j++;
            }
            
        }
    }
    static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/move-zeroes/)