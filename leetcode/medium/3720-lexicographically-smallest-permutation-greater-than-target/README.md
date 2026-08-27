# Lexicographically Smallest Permutation Greater Than Target

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given two strings `s` and `target`, both having length `n`, consisting of lowercase English letters.

Return the  **lexicographically smallest permutation**  of `s` that is  **strictly**  greater than `target`. If no permutation of `s` is lexicographically strictly greater than `target`, return an empty string.

A string `a` is  **lexicographically strictly greater** than a string `b` (of the same length) if in the first position where `a` and `b` differ, string `a` has a letter that appears later in the alphabet than the corresponding letter in `b`.

 

 **Example 1:** 

 **Input:**  s = "abc", target = "bba"

 **Output:**  "bca"

 **Explanation:** 

- The permutations of s (in lexicographical order) are "abc", "acb", "bac", "bca", "cab", and "cba".
- The lexicographically smallest permutation that is strictly greater than target is "bca".

 **Example 2:** 

 **Input:**  s = "leet", target = "code"

 **Output:**  "eelt"

 **Explanation:** 

- The permutations of s (in lexicographical order) are "eelt", "eetl", "elet", "elte", "etel", "etle", "leet", "lete", "ltee", "teel", "tele", and "tlee".
- The lexicographically smallest permutation that is strictly greater than target is "eelt".

 **Example 3:** 

 **Input:**  s = "baba", target = "bbaa"

 **Output:**  ""

 **Explanation:** 

- The permutations of s (in lexicographical order) are "aabb", "abab", "abba", "baab", "baba", and "bbaa".
- None of them is lexicographically strictly greater than target. Therefore, the answer is "".

 

 **Constraints:** 

- 1 <= s.length == target.length <= 300
- s and target consist of only lowercase English letters.

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 91.94%)  
**Memory:** 44.8 MB (beats 67.74%)  
**Submitted:** 2026-08-27T11:05:28.043Z  

```java
class Solution {
    public String lexGreaterPermutation(String s, String target) {

        int[] count = new int[26];
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        int n = s.length();
        StringBuilder result = new StringBuilder();

        int i = 0;

        while (i < n) {

            int current = target.charAt(i) - 'a';

            if (count[current] > 0) {
                result.append(target.charAt(i));
                count[current]--;
                i++;
            } else {
                break;
            }
        }

        for (int pos = i; pos >= 0; pos--) {
            if (pos < result.length()) {
                char ch = result.charAt(pos);
                count[ch - 'a']++;
                result.setLength(pos);
            }
            if (pos < n) {
                int start = target.charAt(pos) - 'a' + 1;

                for (int j = start; j < 26; j++) {
                    if (count[j] > 0) {

                        result.append((char) ('a' + j));
                        count[j]--;

                        for (int k = 0; k < 26; k++) {
                            while (count[k] > 0) {
                                result.append((char) ('a' + k));
                                count[k]--;
                            }
                        }

                        return result.toString();
                    }
                }
            }
        }

        return "";
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/lexicographically-smallest-permutation-greater-than-target/)