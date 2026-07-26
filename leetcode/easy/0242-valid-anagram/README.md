# Valid Anagram

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given two strings `s` and `t`, return `true` if `t` is an anagram of `s`, and `false` otherwise.

 

 **Example 1:** 

 **Input:**  s = "anagram", t = "nagaram"

 **Output:**  true

 **Example 2:** 

 **Input:**  s = "rat", t = "car"

 **Output:**  false

 

 **Constraints:** 

- 1 <= s.length, t.length <= 5 * 104
- s and t consist of lowercase English letters.

 

 **Follow up:**  What if the inputs contain Unicode characters? How would you adapt your solution to such a case?

## Solution

**Language:** Java  
**Runtime:** 4 ms (beats 82.47%)  
**Memory:** 44.4 MB (beats 66.94%)  
**Submitted:** 2026-07-26T13:43:39.563Z  

```java
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] freq = new int[26];
        for(int i=0; i<s.length(); i++){
            freq[s.charAt(i) - 'a']++;
        }
            for(int i=0; i<t.length(); i++){
                freq[t.charAt(i) - 'a']--;
            }
            for(int count : freq){
                if(count != 0){
                    return false;
                }
            }
            return true;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/valid-anagram/)